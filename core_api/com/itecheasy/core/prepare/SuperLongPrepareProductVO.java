/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.prepare;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: liteng
 * @Date: 2018/8/24 16:48
 * @Description:
 */
public class SuperLongPrepareProductVO {

    private int id;
    private Integer shopProductCmsInfoId;
    private Integer isSuperLongPrepareProduct;

    /**
     * 加入到超长备货商品列表的时间
     */
    private Date joinSuperLongPrepareProductDate;


    private String cmsProductCode;
    private String productName;
    private int unitQuantity;

    private String primaryPictureCode;	//商品的图片

    private String unit;

    private double availableStock; //数量
    private BigDecimal costPrice;
    private String colorCardPictureCode;
    private Double unitWeight;
    private Double unitVolume;

    private int cmsAwaitReplenishment;
    private int cmsTheReplenishment;
    private boolean ts;

    private int sales;


    public String getCmsProductCode() {
        return cmsProductCode;
    }

    public void setCmsProductCode(String cmsProductCode) {
        this.cmsProductCode = cmsProductCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(int unitQuantity) {
        this.unitQuantity = unitQuantity;
    }

    public String getPrimaryPictureCode() {
        return primaryPictureCode;
    }

    public void setPrimaryPictureCode(String primaryPictureCode) {
        this.primaryPictureCode = primaryPictureCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(double availableStock) {
        this.availableStock = availableStock;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public String getColorCardPictureCode() {
        return colorCardPictureCode;
    }

    public void setColorCardPictureCode(String colorCardPictureCode) {
        this.colorCardPictureCode = colorCardPictureCode;
    }

    public Double getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(Double unitWeight) {
        this.unitWeight = unitWeight;
    }

    public Double getUnitVolume() {
        return unitVolume;
    }

    public void setUnitVolume(Double unitVolume) {
        this.unitVolume = unitVolume;
    }

    public int getCmsAwaitReplenishment() {
        return cmsAwaitReplenishment;
    }

    public void setCmsAwaitReplenishment(int cmsAwaitReplenishment) {
        this.cmsAwaitReplenishment = cmsAwaitReplenishment;
    }

    public int getCmsTheReplenishment() {
        return cmsTheReplenishment;
    }

    public void setCmsTheReplenishment(int cmsTheReplenishment) {
        this.cmsTheReplenishment = cmsTheReplenishment;
    }

    public boolean isTs() {
        return ts;
    }

    public void setTs(boolean ts) {
        this.ts = ts;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getShopProductCmsInfoId() {
        return shopProductCmsInfoId;
    }

    public void setShopProductCmsInfoId(Integer shopProductCmsInfoId) {
        this.shopProductCmsInfoId = shopProductCmsInfoId;
    }

    public Integer getIsSuperLongPrepareProduct() {
        return isSuperLongPrepareProduct;
    }

    public void setIsSuperLongPrepareProduct(Integer isSuperLongPrepareProduct) {
        this.isSuperLongPrepareProduct = isSuperLongPrepareProduct;
    }

    public Date getJoinSuperLongPrepareProductDate() {
        return joinSuperLongPrepareProductDate;
    }

    public void setJoinSuperLongPrepareProductDate(Date joinSuperLongPrepareProductDate) {
        this.joinSuperLongPrepareProductDate = joinSuperLongPrepareProductDate;
    }
}
