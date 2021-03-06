package com.itecheasy.core.fba;

import com.itecheasy.common.PageList;
import com.itecheasy.common.Param;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.core.fba.dao.FbaShopProductDao;
import com.itecheasy.core.po.FbaShopProductPO;
import com.itecheasy.core.product.ShopProductCmsInfo;
import com.itecheasy.core.product.ShopProductCmsInfoService;
import com.itecheasy.webservice.client.CMSClient;
import com.itecheasy.webservice.cms.OsmsStorageFreeze;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wanghw
 * @version 1.2.2
 * @date 2016-12-2
 * @description TODO
 */
public class FbaShopProductServiceImpl implements FbaShopProductService {
    private FbaShopProductDao fbaShopProductDao;
    private ShopProductCmsInfoService shopProductCmsInfoService;

    public void setShopProductCmsInfoService(ShopProductCmsInfoService shopProductCmsInfoService) {
        this.shopProductCmsInfoService = shopProductCmsInfoService;
    }

    public void setFbaShopProductDao(FbaShopProductDao fbaShopProductDao) {
        this.fbaShopProductDao = fbaShopProductDao;
    }

    @Override
    public int mergeFbaShopProduct(FbaShopProduct shopProduct) {
        FbaShopProductPO po = fbaShopProductDao.findByHql("from FbaShopProductPO where shopId=? and sku=?", new Object[]{shopProduct.getShopId(), shopProduct.getSku()});
        boolean save = false;
        if (po == null) {
            po = new FbaShopProductPO();
            save = true;
        }
        po.setCmsProductCode(shopProduct.getCmsProductCode());
        po.setFbaBarcodeName(shopProduct.getFbaBarcodeName());
        po.setFbaBarcodeSku(shopProduct.getFbaBarcodeSku());
        po.setSku(shopProduct.getSku());
        po.setStatus(shopProduct.getStatus());
        po.setShopId(shopProduct.getShopId());
        if (StringUtils.isNotEmpty(shopProduct.getCmsProductCode())) {
            // TODO cms code换了，是否重新计算补货中的数量。
            po.setCmsProductId(shopProductCmsInfoService.mergeShopProductCmsInfo(shopProduct.getCmsProductCode()));
        }
        if(save){
        	fbaShopProductDao.addObject(po);
        }else{
        	fbaShopProductDao.mergeObject(po);
        }
        return po.getId();
    }

    @Override
    public void replaceSku(int shopId, String oldSku, String newSku) {
        FbaShopProduct old = getFbaShopProduct(oldSku, shopId);
        if (old != null && getFbaShopProduct(newSku, shopId) == null) {
            FbaShopProductPO po = fbaShopProductDao.getObject(old.getId());
            po.setSku(newSku);
        }
    }

    @Override
    public void addFbaShopProduct(FbaShopProduct shopProduct) {
        FbaShopProduct relation = getFbaShopProduct(shopProduct.getSku(), shopProduct.getShopId());
        if (relation == null) {
            FbaShopProductPO po = BeanUtils.copyProperties(shopProduct, FbaShopProductPO.class);
            fbaShopProductDao.addObject(po);
            if (StringUtils.isNotEmpty(shopProduct.getCmsProductCode())) {
                po.setCmsProductId(shopProductCmsInfoService.addShopProductCmsInfo(shopProduct.getCmsProductCode()));
            }
        }
    }


    @Override
    public void setFbaShopProductRelated(String cmsProductCode, int fbaShopProductId) {
        FbaShopProductPO po = fbaShopProductDao.getObject(fbaShopProductId);
        po.setCmsProductId(shopProductCmsInfoService.addShopProductCmsInfo(cmsProductCode));
        po.setCmsProductCode(po.getCmsProductCode());
    }

    @Override
    public void confirmFbaShopProduct(int[] fbaShopProductIds) {
        for (int i = 0; i < fbaShopProductIds.length; i++) {
            FbaShopProductPO po = fbaShopProductDao.getObject(fbaShopProductIds[i]);
            po.setStatus(FbaShopProductStatus.已确认.ordinal());
            fbaShopProductDao.mergeObject(po);
        }
    }

    @Override
    public FbaShopProduct getFbaShopProduct(String sku, int shopId) {
        String hql = "from FbaShopProductPO where shopId=? and sku=?";
        return BeanUtils.copyProperties(fbaShopProductDao.findByHql(hql, new Object[]{shopId, sku}),
                FbaShopProduct.class);
    }

    @Override
    public FbaShopProduct getFbaShopProduct(int id) {
        return BeanUtils.copyProperties(fbaShopProductDao.getObject(id),
                FbaShopProduct.class);
    }

    @Override
    public FbaShopProduct getFbaShopProductByOtherCode(String cmsProductCode, int shopId) {
        String hql = "from FbaShopProductPO where shopId=? and cmsProductCode=?";
        return BeanUtils.copyProperties(fbaShopProductDao.findByHql(hql, new Object[]{shopId, cmsProductCode}),
                FbaShopProduct.class);
    }

    @Override
    public ShopProductRelated getRelatedBySku(String sku, int shopId) {
        FbaShopProduct fba = getFbaShopProduct(sku, shopId);
        if (fba != null) {
            ShopProductRelated related = BeanUtils.copyProperties(fba, ShopProductRelated.class);
            ShopProductCmsInfo cms = shopProductCmsInfoService.getShopProductCmsInfoById(fba.getCmsProductId());
            if (cms != null) {
                BeanUtils.copyProperties(cms, related, new String[]{"id"});
            }
            return related;
        }
        return null;
    }

    @Override
    public ShopProductRelated getRelatedByOtherCode(String cmsProductCode, int shopId) {
        String hql = "from FbaShopProductPO where shopId=? and cmsProductCode=?";
        FbaShopProductPO fba = fbaShopProductDao.findByHql(hql, new Object[]{shopId, cmsProductCode});
        if (fba != null) {
            ShopProductRelated related = BeanUtils.copyProperties(fba, ShopProductRelated.class);
            ShopProductCmsInfo cms = shopProductCmsInfoService.getShopProductCmsInfoById(fba.getCmsProductId());
            if (cms != null) {
                BeanUtils.copyProperties(cms, related, new String[]{"id"});
            }
            return related;
        }
        return null;
    }

    @Override
    public PageList<ShopProductRelated> findShopProductRelated(SearchShopProductRelated search) {
        List<Param> params = new ArrayList<Param>();

        //存储过程 增加条件 增加返回参数
        if (search.getHasSeaTransportBlackList() > -1) {
            params.add(new Param("isSeaTransportBlackList", search.getHasSeaTransportBlackList()));
        }

        if (search.getShopId() > -1) {
            params.add(new Param("shopId", search.getShopId()));
        }
        if (search.getStatus() > -1) {
            params.add(new Param("status", search.getStatus()));
        }
        if (CollectionUtils.isNotEmpty(search.getSkus())) {
            StringBuilder productCodeList = new StringBuilder();
            for (String productCode : search.getSkus()) {
                productCodeList.append(productCode + ",");
            }
            params.add(new Param("skus", productCodeList.substring(0, productCodeList.length() - 1)));
        } else if (StringUtils.isNotEmpty(search.getSku())) {
            params.add(new Param("sku", search.getSku()));
        }

        if (CollectionUtils.isNotEmpty(search.getCmsProductCodes())) {
            StringBuilder productCodeList = new StringBuilder();
            for (String productCode : search.getCmsProductCodes()) {
                productCodeList.append(productCode + ",");
            }
            params.add(new Param("cmsProductCodes", productCodeList.substring(0, productCodeList.length() - 1)));
        } else if (StringUtils.isNotEmpty(search.getCmsProductCode())) {
            params.add(new Param("cmsProductCode", search.getCmsProductCode()));
        }

        params.add(new Param("PageSize", String.valueOf(search.getPageSize())));
        params.add(new Param("PageIndex", String.valueOf(search.getCurrentPage())));
        PageList<ShopProductRelated> pl = fbaShopProductDao.findPageListByStoredProcedure(search.getCurrentPage(), search.getPageSize(),
                "p_fba_shop_product", params, ShopProductRelated.class);
//FbaShopProductPO
        List<String> cmsProductCode = new ArrayList<String>();
        for (ShopProductRelated vo : pl.getData()) {
            cmsProductCode.add(vo.getCmsProductCode());
        }
        List<OsmsStorageFreeze> frees = CMSClient.getAvailableStockAndFreezeQtys(cmsProductCode);
        for (ShopProductRelated vo : pl.getData()) {
            for (OsmsStorageFreeze free : frees) {
                if (vo.getCmsProductCode().equals(free.getProductCode())) {
                    vo.setAvailableQuantity(free.getAvailableQuantity());
                    break;
                }
            }
        }
        return pl;
    }

    @Override
    public void statisticFbaShopProductMonthSales(Date startDate, Date endDate) {
        List<Param> param = new ArrayList<Param>();
        param.add(new Param("startDate", startDate));
        param.add(new Param("endDate", endDate));
        fbaShopProductDao.execStoredProcedure("p_statistic_fba_shop_product_month_sales", param);
    }

    @Override
    public List<String> getHotSaleProducts(Date startDate, Date endDate, int shopId, int amount) {
        return fbaShopProductDao.getHotSaleProducts(startDate, endDate, shopId, amount);
    }

    @Override
    public List<FbaShopProductPO> getProductsNotSeaTransported(int shopId) {
        return fbaShopProductDao.findListByHql("FROM FbaShopProductPO WHERE (hasSeaTransported=0 OR hasSeaTransported IS NULL) AND (isSeaTransportationBlacklist=0 OR isSeaTransportationBlacklist IS NULL) AND shopId = ?", new Object[]{shopId});
    }

}
