/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.operation;

import com.itecheasy.common.PageList;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.fba.dao.AmazonInventoryAgedReportDao;
import com.itecheasy.core.fba.dao.ShopProductCmsInfoDao;
import com.itecheasy.core.po.AmazonInventoryAgedReportPO;
import com.itecheasy.core.po.ShopProductCmsInfoPO;
import com.itecheasy.core.system.Shop;
import com.itecheasy.core.system.SystemService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: liteng
 * @Date: 2018/8/11 16:46
 * @Description:
 */
public class ShowAmazonAgedReportImpl implements ShowAmazonAgedReport {
    private SystemService systemService;

    private ShopProductCmsInfoDao shopProductCmsInfoDao;

    public void setShopProductCmsInfoDao(ShopProductCmsInfoDao shopProductCmsInfoDao) {
        this.shopProductCmsInfoDao = shopProductCmsInfoDao;
    }

    private AmazonInventoryAgedReportDao amazonInventoryAgedReportDao;

    public void setAmazonInventoryAgedReportDao(AmazonInventoryAgedReportDao amazonInventoryAgedReportDao) {
        this.amazonInventoryAgedReportDao = amazonInventoryAgedReportDao;
    }

    public void setSystemService(SystemService systemService) {
        this.systemService = systemService;
    }

    @Override
    public PageList<AmazonAgedReportVO> getAmazonAgedReport(AmazonAgedReportForm amazonAgedReportForm) {

        List<Shop> shops = systemService.getShopsByUserId(amazonAgedReportForm.getOperatorId());
        if (CollectionUtils.isEmpty(shops)){
            throw new BussinessException("用户id不正确");
        }

        PageList<AmazonInventoryAgedReportPO> amazonInventoryAgedReportPOPageList = amazonInventoryAgedReportDao.findPageListTrendHql(amazonAgedReportForm, shops);

        //把cms的图片信息给赋值上去
        Map<String,String> map = new HashMap<String, String>();
        for (AmazonInventoryAgedReportPO datum : amazonInventoryAgedReportPOPageList.getData()) {
            List<Object> params = new ArrayList<Object>();
            params.add(datum.getShopId());
            params.add(datum.getSku());
            List<ShopProductCmsInfoPO> cmsInfoPO = shopProductCmsInfoDao.findListBySql
                    ("select * from shop_product_cms_info c left join fba_shop_product f on f.cms_product_code = c.cms_product_code where shop_id= ? and sku= ? ",params);
            if (CollectionUtils.isNotEmpty(cmsInfoPO)){
                map.put(datum.getSku(),cmsInfoPO.get(0).getPrimaryPictureCode());
            }
        }

        List<AmazonAgedReportVO> amazonAgedReportVOS = BeanUtils.copyList(amazonInventoryAgedReportPOPageList.getData(), AmazonAgedReportVO.class);

        //set cms pictureCode
        for (AmazonAgedReportVO amazonAgedReportVO : amazonAgedReportVOS) {
            amazonAgedReportVO.setPrimaryPictureCode(map.get(amazonAgedReportVO.getSku()));
        }

        PageList<AmazonAgedReportVO> amazonAgedReportVOPageList = new PageList<AmazonAgedReportVO>();
        amazonAgedReportVOPageList.setData(amazonAgedReportVOS);
        amazonAgedReportVOPageList.setPage(amazonInventoryAgedReportPOPageList.getPage());
        System.out.println("amazonAgedReportVOPageList = " + amazonAgedReportVOPageList);
        return amazonAgedReportVOPageList;
    }
}
