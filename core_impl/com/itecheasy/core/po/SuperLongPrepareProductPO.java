/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.po;

import javax.persistence.*;
import java.util.Date;

/**
 * @Auther: liteng
 * @Date: 2018/8/25 11:11
 * @Description:
 */
@Entity
@Table(name = "super_long_prepare_product")
public class SuperLongPrepareProductPO {
    private int id;

    private Integer shopProductCmsInfoId;

    /**
     * 1超长备货商品，
     *
     * 0非超长备货商品
     */
    private Integer isSuperLongPrepareProduct;


    private Date joinSuperLongPrepareProductDate;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "shop_product_cms_info_id", nullable = true)
    public Integer getShopProductCmsInfoId() {
        return shopProductCmsInfoId;
    }

    public void setShopProductCmsInfoId(Integer shopProductCmsInfoId) {
        this.shopProductCmsInfoId = shopProductCmsInfoId;
    }

    @Basic
    @Column(name = "is_super_long_prepare_product", nullable = true)
    public Integer getIsSuperLongPrepareProduct() {
        return isSuperLongPrepareProduct;
    }

    public void setIsSuperLongPrepareProduct(Integer isSuperLongPrepareProduct) {
        this.isSuperLongPrepareProduct = isSuperLongPrepareProduct;
    }

    @Basic
    @Column(name = "join_super_long_prepare_product_date", nullable = true)
    public Date getJoinSuperLongPrepareProductDate() {
        return joinSuperLongPrepareProductDate;
    }

    public void setJoinSuperLongPrepareProductDate(Date joinSuperLongPrepareProductDate) {
        this.joinSuperLongPrepareProductDate = joinSuperLongPrepareProductDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SuperLongPrepareProductPO that = (SuperLongPrepareProductPO) o;

        if (id != that.id) return false;
        if (shopProductCmsInfoId != null ? !shopProductCmsInfoId.equals(that.shopProductCmsInfoId) : that.shopProductCmsInfoId != null)
            return false;
        if (isSuperLongPrepareProduct != null ? !isSuperLongPrepareProduct.equals(that.isSuperLongPrepareProduct) : that.isSuperLongPrepareProduct != null)
            return false;
        if (joinSuperLongPrepareProductDate != null ? !joinSuperLongPrepareProductDate.equals(that.joinSuperLongPrepareProductDate) : that.joinSuperLongPrepareProductDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (shopProductCmsInfoId != null ? shopProductCmsInfoId.hashCode() : 0);
        result = 31 * result + (isSuperLongPrepareProduct != null ? isSuperLongPrepareProduct.hashCode() : 0);
        result = 31 * result + (joinSuperLongPrepareProductDate != null ? joinSuperLongPrepareProductDate.hashCode() : 0);
        return result;
    }
}