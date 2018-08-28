/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.prepare;

import com.itecheasy.core.po.SuperLongPrepareProductPO;

import java.util.List;

/**
 * @Auther: liteng
 *
 * @Date: 2018/8/25 11:20
 * @Description:
 */
public class IsExistSuperLongPrepareProductDataBase {

    /**
     * 是超长备货商品
     */
    private List<SuperLongPrepareProductPO> superItem;

    /**
     * 非超长备货商品
     */
    private List<SuperLongPrepareProductPO> notSuperItem;


    public List<SuperLongPrepareProductPO> getSuperItem() {
        return superItem;
    }

    public void setSuperItem(List<SuperLongPrepareProductPO> superItem) {
        this.superItem = superItem;
    }

    public List<SuperLongPrepareProductPO> getNotSuperItem() {
        return notSuperItem;
    }

    public void setNotSuperItem(List<SuperLongPrepareProductPO> notSuperItem) {
        this.notSuperItem = notSuperItem;
    }
}
