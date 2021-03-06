/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.prepare;

import com.itecheasy.common.Page;
import com.itecheasy.common.PageList;
import com.itecheasy.common.util.*;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.po.ShopProductCmsInfoPO;
import com.itecheasy.core.po.SuperLongPrepareProductPO;
import com.itecheasy.core.prepare.dao.SuperLongPrepareProductDao;
import com.itecheasy.core.product.ShopProductCmsInfo;
import com.itecheasy.core.product.ShopProductCmsInfoService;

import java.sql.Timestamp;
import java.util.*;

/**
 * @Auther: liteng
 * @Date: 2018/8/24 16:14
 * @Description:
 */

public class SuperLongPrepareProductServiceImpl implements SuperLongPrepareProductService {

    private SuperLongPrepareProductDao superLongPrepareProductDao;

//    ShopProductCmsInfoPO

    private ShopProductCmsInfoService shopProductCmsInfoService;


    public void setSuperLongPrepareProductDao(SuperLongPrepareProductDao superLongPrepareProductDao) {
        this.superLongPrepareProductDao = superLongPrepareProductDao;
    }

    public void setShopProductCmsInfoService(ShopProductCmsInfoService shopProductCmsInfoService) {
        this.shopProductCmsInfoService = shopProductCmsInfoService;
    }

    public static void main(String[] args) {
        Date d = new Date();
        Date fullDate = DateUtils.getFullDate(d);
        Date realDate = DateUtils.getRealDate(d);
        System.out.println("realDate = " + realDate);
        System.out.println("fullDate = " + fullDate);
    }

    /**
     * 连表查询
     *
     * @param searchForm
     * @return
     */
    public PageList<SuperLongPrepareProductVO> showSuperLongPrepareProduct3(SuperLongPrepareProductSearchForm searchForm) {

        //查找shop product cms info表
        List<Object> params = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT c.cms_product_code AS cmsProductCode, ");
        sql.append(" c.product_name AS productName, ");
        sql.append(" c.primary_picture_code AS primaryPictureCode, ");

        sql.append(" c.unit_quantity AS unitQuantity, ");
        sql.append(" c.unit AS unit, ");
        sql.append(" c.available_stock AS availableStock, ");
        sql.append(" c.cost_price AS costPrice, ");
        sql.append(" c.color_card_picture_code AS colorCardPictureCode, ");
        sql.append(" c.unit_weight AS unitWeight, ");
        sql.append(" c.unit_volume AS unitVolume, ");
        sql.append(" c.await_replenishment AS cmsAwaitReplenishment, ");
        sql.append(" c.the_replenishment AS cmsTheReplenishment, ");


        sql.append(" s.id AS id, ");
        sql.append(" s.shop_product_cms_info_id AS shopProductCmsInfoId, ");
        sql.append(" s.is_super_long_prepare_product AS isSuperLongPrepareProduct, ");
        sql.append(" s.join_super_long_prepare_product_date AS joinSuperLongPrepareProductDate ");

        sql.append(" FROM shop_product_cms_info c ");

        sql.append(" LEFT JOIN super_long_prepare_product s ");
        sql.append(" on c.cms_product_id = s.shop_product_cms_info_id ");
        sql.append(" where 1=1 ");

        if (searchForm.getJoinSuperLongPrepareProductDateStart() != null) {
            sql.append("AND join_super_long_prepare_product_date>=? ");
            params.add(new Timestamp(DateUtils.getRealDate(searchForm.getJoinSuperLongPrepareProductDateStart()).getTime()));
        }

        if (searchForm.getJoinSuperLongPrepareProductDateEnd() != null) {
            sql.append("AND join_super_long_prepare_product_date<=? ");
            params.add(new Timestamp(DateUtils.getFullDate(searchForm.getJoinSuperLongPrepareProductDateEnd()).getTime()));
        }

        sql.append(" AND is_super_long_prepare_product=1 ");

        sql.append(" AND s.id is not null ");


        if (CollectionUtils.isNotEmpty(searchForm.getCmsCodes())) {
            String jointCriteriaString = HqlUtils.jointCriteriaString(" ", searchForm.getCmsCodes());
            sql.append(" AND cms_product_code " + jointCriteriaString);
        }

        if (searchForm.getCmsCodeName() != null) {
            sql.append(" AND product_name LIKE '%" + searchForm.getCmsCodeName() + "%' ");
        }


        System.out.println(sql.toString());

        Integer totalCount = (Integer) superLongPrepareProductDao.getSingleObjectBySql("SELECT COUNT(*) FROM ( " + sql.toString() + " ) tem", params.toArray());

        int offsetPosition = (searchForm.getCurrentPage() - 1) * searchForm.getPageSize();

        sql.append(" ORDER BY id DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY ");
        params.add(offsetPosition);
        params.add(searchForm.getPageSize());

        System.out.println(sql.toString());

        List<SuperLongPrepareProductVO> list = superLongPrepareProductDao.findListBySql(sql.toString(), params,
                SuperLongPrepareProductVO.class);

        PageList<SuperLongPrepareProductVO> pageList = new PageList<SuperLongPrepareProductVO>();
        Page page = new Page(totalCount, searchForm.getCurrentPage(), searchForm.getPageSize());
        pageList.setPage(page);
        pageList.setData(list);
        return pageList;
    }


    /**
     * 再也不用分解查询了 真是坑
     *
     * @param superLongPrepareProductSearchForm
     * @return
     */
    @Deprecated
    @Override
    public PageList<SuperLongPrepareProductVO> showSuperLongPrepareProduct(SuperLongPrepareProductSearchForm superLongPrepareProductSearchForm) {
        List<String> cmsCodes = superLongPrepareProductSearchForm.getCmsCodes();

        //根据用户传来的来获取所有的条件匹配的cms信息
        List<ShopProductCmsInfo> infoByCmsCodes = shopProductCmsInfoService.findInfoByCmsCodesAndName3(cmsCodes, superLongPrepareProductSearchForm);

        //查询superItem表
        List<Object> params = new ArrayList<Object>();
        StringBuilder hql = new StringBuilder("from SuperLongPrepareProductPO where 1=1 ");


        if (superLongPrepareProductSearchForm.getJoinSuperLongPrepareProductDateStart() != null) {
            hql.append("AND joinSuperLongPrepareProductDate>=? ");
            params.add(com.itecheasy.common.util.DateUtils.getRealDate(superLongPrepareProductSearchForm.getJoinSuperLongPrepareProductDateStart()));
        }

        if (superLongPrepareProductSearchForm.getJoinSuperLongPrepareProductDateEnd() != null) {
            hql.append("AND joinSuperLongPrepareProductDate<=? ");
            params.add(DateUtils.getFullDate(superLongPrepareProductSearchForm.getJoinSuperLongPrepareProductDateEnd()));
        }


        /**
         * 不一定所有的cmsCode都能查到，所以只去在cms表中能查询得到的
         */
        List<ShopProductCmsInfo> legalCmsPO = new ArrayList<ShopProductCmsInfo>();
        if (cmsCodes != null) {
            for (ShopProductCmsInfo infoByCmsCode : infoByCmsCodes) {
                if (cmsCodes.contains(infoByCmsCode.getCmsProductCode())) {
                    legalCmsPO.add(infoByCmsCode);
                }
            }
        } else {
            legalCmsPO.addAll(infoByCmsCodes);
        }


        //取出cmsId
        List<Integer> cmsIds = new ArrayList<Integer>();
        for (ShopProductCmsInfo shopProductCmsInfo : legalCmsPO) {
            cmsIds.add(shopProductCmsInfo.getCmsProductId());
        }

        //拼接cmsId
        if (CollectionUtils.isNotEmpty(cmsIds)) {
            String jointCriteriaInt = HqlUtils.jointCriteriaInt(cmsIds);
            hql.append(" AND shopProductCmsInfoId in (" + jointCriteriaInt + ") ");
        }

        //根据时间和cmsId来查找所有的superPOS
        PageList<SuperLongPrepareProductPO> superLongPrepareProductPOPageList = superLongPrepareProductDao.findPageListByHql(superLongPrepareProductSearchForm.getCurrentPage(),
                superLongPrepareProductSearchForm.getPageSize(), hql.toString(), params.toArray());

        List<ShopProductCmsInfoPO> cmsInfoPOS = BeanUtils.copyList(legalCmsPO, ShopProductCmsInfoPO.class);

        //map分类
        List<SuperLongPrepareProductVO> superLongPrepareProductVOS = new ArrayList<SuperLongPrepareProductVO>();
        Map<Integer, ShopProductCmsInfoPO> newAgedItemListPOMap = new HashMap<Integer, ShopProductCmsInfoPO>();
        for (ShopProductCmsInfoPO newAgedItemAgedReportPO : cmsInfoPOS) {
            newAgedItemListPOMap.put(newAgedItemAgedReportPO.getCmsProductId(), newAgedItemAgedReportPO);
        }
        for (SuperLongPrepareProductPO superLongPrepareProductPO : superLongPrepareProductPOPageList.getData()) {
            SuperLongPrepareProductVO vo = new SuperLongPrepareProductVO();
            ShopProductCmsInfoPO shopProductCmsInfoPO = newAgedItemListPOMap.get(superLongPrepareProductPO.getShopProductCmsInfoId());
            //拼装数据
            BeanUtils.copyProperties(shopProductCmsInfoPO, vo);
            BeanUtils.copyProperties(superLongPrepareProductPO, vo);
            superLongPrepareProductVOS.add(vo);
        }

        PageList<SuperLongPrepareProductVO> pageList = new PageList<SuperLongPrepareProductVO>();
        pageList.setData(superLongPrepareProductVOS);
        pageList.setPage(superLongPrepareProductPOPageList.getPage());
        return pageList;
    }


    /**
     * 返回的是依据用户传来的
     * <p>
     * 如果原来的状态是超长备货
     *
     * @param cmsCodes
     * @param operatorId
     * @return
     */
    @Override
    public IsExistSuperLongPrepareProductDataBase checkRepeatCmsCode(List<String> cmsCodes, Integer operatorId) {

        List<String> notIsExistCmsCodes = new ArrayList<String>(cmsCodes);

        //全部都是
        if (CollectionUtils.isEmpty(notIsExistCmsCodes)){
          return null;
        }

        List<ShopProductCmsInfo> infoByCmsCodes = shopProductCmsInfoService.findInfoByCmsCodes(notIsExistCmsCodes);

        //通过用户传来的cmsCode得到所有对应的cmsCode信息
        List<Integer> cmsInfoId = new ArrayList<Integer>();
        for (ShopProductCmsInfo cmsInfo : infoByCmsCodes) {
            cmsInfoId.add(cmsInfo.getCmsProductId());
        }

        String hql = "";
        if (CollectionUtils.isNotEmpty(cmsInfoId)) {
            String jointCriteriaInt = HqlUtils.jointCriteriaInt(cmsInfoId);
            hql = " from SuperLongPrepareProductPO where shopProductCmsInfoId in (" + jointCriteriaInt + " ) ";
        } else {
            hql = " from SuperLongPrepareProductPO ";
        }
        //哪些cmsCode是已经在超长商品备货里面的
        List<SuperLongPrepareProductPO> superLongPrepareProductPOS = superLongPrepareProductDao.findListByHql(hql);

        List<SuperLongPrepareProductPO> superItem = new ArrayList<SuperLongPrepareProductPO>();
        List<SuperLongPrepareProductPO> notSuperItem = new ArrayList<SuperLongPrepareProductPO>();

        for (SuperLongPrepareProductPO superLongPrepareProductPO : superLongPrepareProductPOS) {
            if (superLongPrepareProductPO.getIsSuperLongPrepareProduct().equals(0)) {
                notSuperItem.add(superLongPrepareProductPO);
            } else if (superLongPrepareProductPO.getIsSuperLongPrepareProduct().equals(1)) {
                superItem.add(superLongPrepareProductPO);
            }
        }

        IsExistSuperLongPrepareProductDataBase isExistSuperLongPrepareProductDataBase = new IsExistSuperLongPrepareProductDataBase();
        isExistSuperLongPrepareProductDataBase.setSuperItem(superItem);
        isExistSuperLongPrepareProductDataBase.setNotSuperItem(notSuperItem);

        return isExistSuperLongPrepareProductDataBase;
    }




    /**
     * 是否存在super表中
     *
     * @param cmsCodes
     * @return 返回不存在表中的cmsCodeId和code
     */
    public Map<Integer, String> notIsExistSuperItemTable(List<String> cmsCodes) {
        List<ShopProductCmsInfo> dataBaseByCmsCodes = shopProductCmsInfoService.findInfoByCmsCodes(cmsCodes);

        Map<Integer, String> itemListPOMap = new HashMap<Integer, String>();
        for (ShopProductCmsInfo shopProductCmsInfo : dataBaseByCmsCodes) {
            itemListPOMap.put(shopProductCmsInfo.getCmsProductId(), shopProductCmsInfo.getCmsProductCode());
        }

        StringBuilder hql = new StringBuilder(" from SuperLongPrepareProductPO where 1=1 ");

        if (CollectionUtils.isNotEmpty(dataBaseByCmsCodes)){
            List<Integer> param = new ArrayList<Integer>(itemListPOMap.keySet());
            String jointCriteriaInt = HqlUtils.jointCriteriaInt( param);
            hql.append(" and shopProductCmsInfoId ");
            hql.append(" in ( ");
            hql.append(jointCriteriaInt);
            hql.append(" ) ");
        }

        System.out.println("hql = " + hql);

        List<SuperLongPrepareProductPO> dataBaseSuperItems = superLongPrepareProductDao.findListByHql(hql.toString());

        for (SuperLongPrepareProductPO dataBaseSuperItem : dataBaseSuperItems) {
            if (itemListPOMap.keySet().contains(dataBaseSuperItem.getShopProductCmsInfoId())){
                itemListPOMap.remove(dataBaseSuperItem.getShopProductCmsInfoId());
            }
        }

        return itemListPOMap;
    }


    @Override
    public List<Integer> addSuperLongPrepareProducts(List<String> cmsCodes, Integer operatorId) {
        //检查cmsCode是否合法
        List<String> illegal = shopProductCmsInfoService.cmsCodeCheckExist(cmsCodes);

        if (CollectionUtils.isNotEmpty(illegal)) {
            throw new BussinessException("cmsCode : " + illegal + " 不存在");
        }


        //分类superItem分为已经是和不是的
        IsExistSuperLongPrepareProductDataBase isExistSuperLongPrepareProductDataBase = checkRepeatCmsCode(cmsCodes, operatorId);

        //你小子玩我呢，一个cmsCode都不添加
        if (isExistSuperLongPrepareProductDataBase==null){
           return null;
        }


        List<Integer> existIds = new ArrayList<Integer>();
        //first 因为表里还没有数据
        if (isExistSuperLongPrepareProductDataBase.getSuperItem().size() == 0 && isExistSuperLongPrepareProductDataBase.getNotSuperItem().size() == 0) {
            List<ShopProductCmsInfo> infoByCmsCodes = shopProductCmsInfoService.findInfoByCmsCodes(cmsCodes);

            Date date = new Date();
            List<SuperLongPrepareProductPO> superLongPrepareProductPOS = new ArrayList<SuperLongPrepareProductPO>();

            for (ShopProductCmsInfo shopProductCmsInfo : infoByCmsCodes) {
                SuperLongPrepareProductPO po = new SuperLongPrepareProductPO();
                po.setShopProductCmsInfoId(shopProductCmsInfo.getCmsProductId());
                po.setIsSuperLongPrepareProduct(ItemType.superPrepareItem.getCode());
                po.setJoinSuperLongPrepareProductDate(date);
                superLongPrepareProductPOS.add(po);
            }


            superLongPrepareProductDao.addObject(superLongPrepareProductPOS);
            return null;
        }

        /**
         * 根据用户传来的code获取是超长备货的商品
         */

        for (SuperLongPrepareProductPO superLongPrepareProductPO : isExistSuperLongPrepareProductDataBase.getSuperItem()) {
            existIds.add(superLongPrepareProductPO.getId());
        }



        //不存在表中的
        Map<Integer, String> notIsExistSuperItemTable = notIsExistSuperItemTable(cmsCodes);
        List<Integer> cmsIds = new ArrayList<Integer>(notIsExistSuperItemTable.keySet());
        List<SuperLongPrepareProductPO> superLongPrepareProductPOS = convertPO(cmsIds, operatorId, 1);
        superLongPrepareProductDao.addObject(superLongPrepareProductPOS);


        //把不是超长备货的商品给改掉的给改掉
        List<SuperLongPrepareProductPO> notSuperItems = isExistSuperLongPrepareProductDataBase.getNotSuperItem();
        for (SuperLongPrepareProductPO notSuperItem : notSuperItems) {
            notSuperItem.setIsSuperLongPrepareProduct(ItemType.superPrepareItem.code);
        }

        superLongPrepareProductDao.updateObject(notSuperItems);

        //返回已经存在的商品，这些商品需要提示
        return existIds;
    }

    private List<SuperLongPrepareProductPO> convertPO(List<Integer> cmsId, Integer operatorId, int addOrDelete) {
        List<SuperLongPrepareProductPO> pos = new ArrayList<SuperLongPrepareProductPO>();
        for (Integer id : cmsId) {
            Date date = new Date();

            SuperLongPrepareProductPO po = new SuperLongPrepareProductPO();

            po.setShopProductCmsInfoId(id);
            if (addOrDelete == 1) {
                // superItem
                po.setIsSuperLongPrepareProduct(ItemType.superPrepareItem.getCode());
            } else if (addOrDelete == 2) {
                // 非superItem
                po.setIsSuperLongPrepareProduct(ItemType.notSuperPrepareItem.getCode());
            }
            po.setJoinSuperLongPrepareProductDate(date);
            pos.add(po);
        }
        return pos;
    }


    @Override
    public List<Integer> deleteSuperLongPrepareProducts(List<String> cmsCodes, Integer operatorId) {

        //检查cmsCode是否合法
        List<String> illeagal = shopProductCmsInfoService.cmsCodeCheckExist(cmsCodes);

        if (CollectionUtils.isNotEmpty(illeagal)) {
            throw new BussinessException("cmsCode : " + illeagal + " 不存在");
        }

        IsExistSuperLongPrepareProductDataBase isExistSuperLongPrepareProductDataBase = checkRepeatCmsCode(cmsCodes, operatorId);

        //你小子玩我呢，一个cmsCode都不添加
        if (isExistSuperLongPrepareProductDataBase==null){
            return null;
        }

        List<Integer> notExistIds = new ArrayList<Integer>();
        //first
        if (isExistSuperLongPrepareProductDataBase.getSuperItem().size() == 0 && isExistSuperLongPrepareProductDataBase.getNotSuperItem().size() == 0) {
            List<ShopProductCmsInfo> infoByCmsCodes = shopProductCmsInfoService.findInfoByCmsCodes(cmsCodes);

            Date date = new Date();
            List<SuperLongPrepareProductPO> superLongPrepareProductPOS = new ArrayList<SuperLongPrepareProductPO>();

            for (ShopProductCmsInfo shopProductCmsInfo : infoByCmsCodes) {
                SuperLongPrepareProductPO po = new SuperLongPrepareProductPO();
                po.setShopProductCmsInfoId(shopProductCmsInfo.getCmsProductId());
                po.setIsSuperLongPrepareProduct(ItemType.notSuperPrepareItem.getCode());
                po.setJoinSuperLongPrepareProductDate(date);
                superLongPrepareProductPOS.add(po);
            }
            superLongPrepareProductDao.addObject(superLongPrepareProductPOS);
            return notExistIds;
        }

        /**
         * 根据用户传来的code获取不是超长备货的商品
         *
         */

        for (SuperLongPrepareProductPO superLongPrepareProductPO : isExistSuperLongPrepareProductDataBase.getNotSuperItem()) {
            notExistIds.add(superLongPrepareProductPO.getId());
        }

        List<SuperLongPrepareProductPO> superItem = isExistSuperLongPrepareProductDataBase.getSuperItem();
        for (SuperLongPrepareProductPO superLongPrepareProductPO : superItem) {
            superLongPrepareProductPO.setIsSuperLongPrepareProduct(ItemType.notSuperPrepareItem.code);
        }
        superLongPrepareProductDao.updateObject(superItem);


        //不存在表中的
        Map<Integer, String> notIsExistSuperItemTable = notIsExistSuperItemTable(cmsCodes);
        List<Integer> cmsIds = new ArrayList<Integer>(notIsExistSuperItemTable.keySet());
        List<SuperLongPrepareProductPO> superLongPrepareProductPOS = convertPO(cmsIds, operatorId, 2);
        superLongPrepareProductDao.addObject(superLongPrepareProductPOS);


        return notExistIds;
    }


    @Override
    public List<SuperLongPrepareProductPO> getSuperLongPrepareProductById(List<Integer> ids, Integer operatorId) {


        String jointCriteriaInt = HqlUtils.jointCriteriaInt(ids);

        List<SuperLongPrepareProductPO> superLongPrepareProductPOS = superLongPrepareProductDao.findListByHql
                (" from SuperLongPrepareProductPO where id in ( " + jointCriteriaInt + " ) ");

        return superLongPrepareProductPOS;
    }


}
