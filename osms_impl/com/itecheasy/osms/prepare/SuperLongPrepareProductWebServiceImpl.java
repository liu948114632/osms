/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.osms.prepare;

import com.itecheasy.common.PageList;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.core.po.ShopProductCmsInfoPO;
import com.itecheasy.core.po.SuperLongPrepareProductPO;
import com.itecheasy.core.prepare.IsExistSuperLongPrepareProductDataBase;
import com.itecheasy.core.prepare.SuperLongPrepareProductSearchForm;
import com.itecheasy.core.prepare.SuperLongPrepareProductService;
import com.itecheasy.core.prepare.SuperLongPrepareProductVO;
import com.itecheasy.core.product.ShopProductCmsInfo;
import com.itecheasy.core.product.ShopProductCmsInfoService;

import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/8/24 16:12
 * @Description:
 */
public class SuperLongPrepareProductWebServiceImpl implements SuperLongPrepareProductWebService {

    /**
     *  shop_product_cms_info
     */

    private SuperLongPrepareProductService superLongPrepareProductService;


    private ShopProductCmsInfoService shopProductCmsInfoService;

    public void setShopProductCmsInfoService(ShopProductCmsInfoService shopProductCmsInfoService) {
        this.shopProductCmsInfoService = shopProductCmsInfoService;
    }

    public void setSuperLongPrepareProductService(SuperLongPrepareProductService superLongPrepareProductService) {
        this.superLongPrepareProductService = superLongPrepareProductService;
    }





    @Override
    public PageList<SuperLongPrepareProductVO> showSuperLongPrepareProduct(SuperLongPrepareProductSearchForm superLongPrepareProductSearchForm) {
        return superLongPrepareProductService.showSuperLongPrepareProduct3(superLongPrepareProductSearchForm);
    }

    @Override
    public IsExistSuperLongPrepareProductDataBase checkRepeatCmsCode(List<String> cmsCodes, Integer operatorId) {
        return superLongPrepareProductService.checkRepeatCmsCode(cmsCodes, operatorId);
    }

    @Override
    public PageList<SuperLongPrepareProductVO> showSuperLongPrepareProduct3(SuperLongPrepareProductSearchForm searchForm) {
        return superLongPrepareProductService.showSuperLongPrepareProduct3(searchForm);
    }

    @Override
    public List<ShopProductCmsInfo> addSuperLongPrepareProducts(List<String> cmsCodes, Integer operatorId) {
        List<Integer> duplicateSuperLongPrepareProduct = superLongPrepareProductService.addSuperLongPrepareProducts(cmsCodes, operatorId);
        List<ShopProductCmsInfo> cmsInfos = getCmsCodeBySuperLongPrepareProductIds(duplicateSuperLongPrepareProduct);
        return cmsInfos;
    }



    @Override
    public List<ShopProductCmsInfo> deleteSuperLongPrepareProducts( List<String> cmsCodes, Integer operatorId) {
        List<Integer> duplicateSuperLongPrepareProduct = superLongPrepareProductService.deleteSuperLongPrepareProducts(cmsCodes, operatorId);
        List<ShopProductCmsInfo> cmsInfos = getCmsCodeBySuperLongPrepareProductIds(duplicateSuperLongPrepareProduct);
        return cmsInfos;
    }

    /**
     * 得到cms的信息，通过superitem的id
     * @param superLongPrepareProductIds
     * @return
     */
    @Override
    public List<ShopProductCmsInfo> getCmsCodeBySuperLongPrepareProductIds(List<Integer> superLongPrepareProductIds) {
        return shopProductCmsInfoService.getCmsCodeBySuperLongPrepareProductIds(superLongPrepareProductIds);
    }

    @Override
    public List<SuperLongPrepareProductVO> getSuperLongPrepareProductById(List<Integer> ids, Integer operatorId) {
        List<SuperLongPrepareProductPO> superLongPrepareProductById = superLongPrepareProductService.getSuperLongPrepareProductById(ids, operatorId);

        return BeanUtils.copyList(superLongPrepareProductById,SuperLongPrepareProductVO.class);
    }
}
