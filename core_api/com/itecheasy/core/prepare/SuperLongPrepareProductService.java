/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.prepare;

import com.itecheasy.common.PageList;
import com.itecheasy.core.po.SuperLongPrepareProductPO;
import com.itecheasy.core.product.ShopProductCmsInfo;

import java.util.List;
import java.util.Map;

/**
 * @Auther: liteng
 * @Date: 2018/8/24 16:14
 * @Description:
 */
public interface SuperLongPrepareProductService {

    @Deprecated
    public abstract PageList<SuperLongPrepareProductVO> showSuperLongPrepareProduct
            (SuperLongPrepareProductSearchForm superLongPrepareProductSearchForm);


    /**
     * 连表查询
     * @param searchForm
     * @return
     */
    public PageList<SuperLongPrepareProductVO> showSuperLongPrepareProduct3(SuperLongPrepareProductSearchForm searchForm);


    public abstract IsExistSuperLongPrepareProductDataBase checkRepeatCmsCode(List<String> cmsCodes, Integer operatorId);

    public abstract List<Integer> addSuperLongPrepareProducts(List<String> cmsCodes, Integer operatorId);


    /**
     * 是否存在super表中
     * @param cmsCodes
     * @return 返回不存在表中的cmsCodeId
     */
    public abstract Map<Integer, String> notIsExistSuperItemTable(List<String> cmsCodes);

    public abstract List<Integer> deleteSuperLongPrepareProducts(List<String> cmsCodes, Integer operatorId);


//    public abstract List<ShopProductCmsInfo> getCmsCodeBySuperLongPrepareProductIds(List<Integer> superLongPrepareProductIds);


    public abstract List<SuperLongPrepareProductPO> getSuperLongPrepareProductById(List<Integer> ids, Integer operatorId);


    public enum ItemType {
        notSuperPrepareItem(0, "非长备货商品"),
        superPrepareItem(1, "超长备货商品"),
        ;

        int code;
        String description;


        ItemType(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public int getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }
}
