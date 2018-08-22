/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan. 
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna. 
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus. 
 * Vestibulum commodo. Ut rhoncus gravida arcu. 
 */

package com.itecheasy.core.po;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @Auther: liteng
 * @Date: 2018/8/22 15:15
 * @Description:
 */
@Entity
@Table(name = "amazon_logistics_forecast_cost_report", schema = "dbo")
public class AmazonLogisticsForecastCostReportPO {

    private int id;
    private Integer shopId;
    private Date syncFirst;
    private Date syncLast;
    private String sku;

    private String fnsku;
    private String asin;
    private String productName;
    private String productGroup;
    private String brand;
    private String fulfilledBy;
    private BigDecimal yourPrice;
    private BigDecimal salesPrice;
    private BigDecimal longestSide;
    private BigDecimal medianSide;
    private BigDecimal shortestSide;
    private BigDecimal lengthAndGirth;
    private String unitOfDimension;
    private BigDecimal itemPackageWeight;
    private String unitOfWeight;
    private String productSizeTier;
    private String currency;
    private BigDecimal estimatedFeeTotal;
    private BigDecimal estimatedReferralFeePerUnit;
    private BigDecimal estimatedVariableClosingFee;
    private BigDecimal estimatedOrderHandlingFeePerOrder;
    private BigDecimal estimatedPickPackFeePerUnit;
    private BigDecimal estimatedWeightHandlingFeePerUnit;
    private BigDecimal expectedFulfillmentFeePerUnit;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "shop_id", nullable = true)
    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "sync_first", nullable = true)
    public Date getSyncFirst() {
        return syncFirst;
    }

    public void setSyncFirst(Date syncFirst) {
        this.syncFirst = syncFirst;
    }

    @Basic
    @Column(name = "sync_last", nullable = true)
    public Date getSyncLast() {
        return syncLast;
    }

    public void setSyncLast(Date syncLast) {
        this.syncLast = syncLast;
    }

    @Basic
    @Column(name = "sku", nullable = true, length = 100)
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Basic
    @Column(name = "fnsku", nullable = true, length = 100)
    public String getFnsku() {
        return fnsku;
    }

    public void setFnsku(String fnsku) {
        this.fnsku = fnsku;
    }

    @Basic
    @Column(name = "asin", nullable = true, length = 100)
    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    @Basic
    @Column(name = "product_name", nullable = true, length = 3000)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "product_group", nullable = true, length = 100)
    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    @Basic
    @Column(name = "brand", nullable = true, length = 100)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "fulfilled_by", nullable = true, length = 100)
    public String getFulfilledBy() {
        return fulfilledBy;
    }

    public void setFulfilledBy(String fulfilledBy) {
        this.fulfilledBy = fulfilledBy;
    }

    @Basic
    @Column(name = "your_price", nullable = true, precision = 3)
    public BigDecimal getYourPrice() {
        return yourPrice;
    }

    public void setYourPrice(BigDecimal yourPrice) {
        this.yourPrice = yourPrice;
    }

    @Basic
    @Column(name = "sales_price", nullable = true, precision = 3)
    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    @Basic
    @Column(name = "longest_side", nullable = true, precision = 3)
    public BigDecimal getLongestSide() {
        return longestSide;
    }

    public void setLongestSide(BigDecimal longestSide) {
        this.longestSide = longestSide;
    }

    @Basic
    @Column(name = "median_side", nullable = true, precision = 3)
    public BigDecimal getMedianSide() {
        return medianSide;
    }

    public void setMedianSide(BigDecimal medianSide) {
        this.medianSide = medianSide;
    }

    @Basic
    @Column(name = "shortest_side", nullable = true, precision = 3)
    public BigDecimal getShortestSide() {
        return shortestSide;
    }

    public void setShortestSide(BigDecimal shortestSide) {
        this.shortestSide = shortestSide;
    }

    @Basic
    @Column(name = "length_and_girth", nullable = true, precision = 3)
    public BigDecimal getLengthAndGirth() {
        return lengthAndGirth;
    }

    public void setLengthAndGirth(BigDecimal lengthAndGirth) {
        this.lengthAndGirth = lengthAndGirth;
    }

    @Basic
    @Column(name = "unit_of_dimension", nullable = true, length = 100)
    public String getUnitOfDimension() {
        return unitOfDimension;
    }

    public void setUnitOfDimension(String unitOfDimension) {
        this.unitOfDimension = unitOfDimension;
    }

    @Basic
    @Column(name = "item_package_weight", nullable = true, precision = 3)
    public BigDecimal getItemPackageWeight() {
        return itemPackageWeight;
    }

    public void setItemPackageWeight(BigDecimal itemPackageWeight) {
        this.itemPackageWeight = itemPackageWeight;
    }

    @Basic
    @Column(name = "unit_of_weight", nullable = true, length = 100)
    public String getUnitOfWeight() {
        return unitOfWeight;
    }

    public void setUnitOfWeight(String unitOfWeight) {
        this.unitOfWeight = unitOfWeight;
    }

    @Basic
    @Column(name = "product_size_tier", nullable = true, length = 100)
    public String getProductSizeTier() {
        return productSizeTier;
    }

    public void setProductSizeTier(String productSizeTier) {
        this.productSizeTier = productSizeTier;
    }

    @Basic
    @Column(name = "currency", nullable = true, length = 100)
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "estimated_fee_total", nullable = true, precision = 3)
    public BigDecimal getEstimatedFeeTotal() {
        return estimatedFeeTotal;
    }

    public void setEstimatedFeeTotal(BigDecimal estimatedFeeTotal) {
        this.estimatedFeeTotal = estimatedFeeTotal;
    }

    @Basic
    @Column(name = "estimated_referral_fee_per_unit", nullable = true, precision = 3)
    public BigDecimal getEstimatedReferralFeePerUnit() {
        return estimatedReferralFeePerUnit;
    }

    public void setEstimatedReferralFeePerUnit(BigDecimal estimatedReferralFeePerUnit) {
        this.estimatedReferralFeePerUnit = estimatedReferralFeePerUnit;
    }

    @Basic
    @Column(name = "estimated_variable_closing_fee", nullable = true, precision = 3)
    public BigDecimal getEstimatedVariableClosingFee() {
        return estimatedVariableClosingFee;
    }

    public void setEstimatedVariableClosingFee(BigDecimal estimatedVariableClosingFee) {
        this.estimatedVariableClosingFee = estimatedVariableClosingFee;
    }

    @Basic
    @Column(name = "estimated_order_handling_fee_per_order", nullable = true, precision = 3)
    public BigDecimal getEstimatedOrderHandlingFeePerOrder() {
        return estimatedOrderHandlingFeePerOrder;
    }

    public void setEstimatedOrderHandlingFeePerOrder(BigDecimal estimatedOrderHandlingFeePerOrder) {
        this.estimatedOrderHandlingFeePerOrder = estimatedOrderHandlingFeePerOrder;
    }

    @Basic
    @Column(name = "estimated_pick_pack_fee_per_unit", nullable = true, precision = 3)
    public BigDecimal getEstimatedPickPackFeePerUnit() {
        return estimatedPickPackFeePerUnit;
    }

    public void setEstimatedPickPackFeePerUnit(BigDecimal estimatedPickPackFeePerUnit) {
        this.estimatedPickPackFeePerUnit = estimatedPickPackFeePerUnit;
    }

    @Basic
    @Column(name = "estimated_weight_handling_fee_per_unit", nullable = true, precision = 3)
    public BigDecimal getEstimatedWeightHandlingFeePerUnit() {
        return estimatedWeightHandlingFeePerUnit;
    }

    public void setEstimatedWeightHandlingFeePerUnit(BigDecimal estimatedWeightHandlingFeePerUnit) {
        this.estimatedWeightHandlingFeePerUnit = estimatedWeightHandlingFeePerUnit;
    }

    @Basic
    @Column(name = "expected_fulfillment_fee_per_unit", nullable = true, precision = 3)
    public BigDecimal getExpectedFulfillmentFeePerUnit() {
        return expectedFulfillmentFeePerUnit;
    }

    public void setExpectedFulfillmentFeePerUnit(BigDecimal expectedFulfillmentFeePerUnit) {
        this.expectedFulfillmentFeePerUnit = expectedFulfillmentFeePerUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AmazonLogisticsForecastCostReportPO that = (AmazonLogisticsForecastCostReportPO) o;

        if (id != that.id) return false;
        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) return false;
        if (syncFirst != null ? !syncFirst.equals(that.syncFirst) : that.syncFirst != null) return false;
        if (syncLast != null ? !syncLast.equals(that.syncLast) : that.syncLast != null) return false;
        if (sku != null ? !sku.equals(that.sku) : that.sku != null) return false;
        if (fnsku != null ? !fnsku.equals(that.fnsku) : that.fnsku != null) return false;
        if (asin != null ? !asin.equals(that.asin) : that.asin != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (productGroup != null ? !productGroup.equals(that.productGroup) : that.productGroup != null) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (fulfilledBy != null ? !fulfilledBy.equals(that.fulfilledBy) : that.fulfilledBy != null) return false;
        if (yourPrice != null ? !yourPrice.equals(that.yourPrice) : that.yourPrice != null) return false;
        if (salesPrice != null ? !salesPrice.equals(that.salesPrice) : that.salesPrice != null) return false;
        if (longestSide != null ? !longestSide.equals(that.longestSide) : that.longestSide != null) return false;
        if (medianSide != null ? !medianSide.equals(that.medianSide) : that.medianSide != null) return false;
        if (shortestSide != null ? !shortestSide.equals(that.shortestSide) : that.shortestSide != null) return false;
        if (lengthAndGirth != null ? !lengthAndGirth.equals(that.lengthAndGirth) : that.lengthAndGirth != null)
            return false;
        if (unitOfDimension != null ? !unitOfDimension.equals(that.unitOfDimension) : that.unitOfDimension != null)
            return false;
        if (itemPackageWeight != null ? !itemPackageWeight.equals(that.itemPackageWeight) : that.itemPackageWeight != null)
            return false;
        if (unitOfWeight != null ? !unitOfWeight.equals(that.unitOfWeight) : that.unitOfWeight != null) return false;
        if (productSizeTier != null ? !productSizeTier.equals(that.productSizeTier) : that.productSizeTier != null)
            return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (estimatedFeeTotal != null ? !estimatedFeeTotal.equals(that.estimatedFeeTotal) : that.estimatedFeeTotal != null)
            return false;
        if (estimatedReferralFeePerUnit != null ? !estimatedReferralFeePerUnit.equals(that.estimatedReferralFeePerUnit) : that.estimatedReferralFeePerUnit != null)
            return false;
        if (estimatedVariableClosingFee != null ? !estimatedVariableClosingFee.equals(that.estimatedVariableClosingFee) : that.estimatedVariableClosingFee != null)
            return false;
        if (estimatedOrderHandlingFeePerOrder != null ? !estimatedOrderHandlingFeePerOrder.equals(that.estimatedOrderHandlingFeePerOrder) : that.estimatedOrderHandlingFeePerOrder != null)
            return false;
        if (estimatedPickPackFeePerUnit != null ? !estimatedPickPackFeePerUnit.equals(that.estimatedPickPackFeePerUnit) : that.estimatedPickPackFeePerUnit != null)
            return false;
        if (estimatedWeightHandlingFeePerUnit != null ? !estimatedWeightHandlingFeePerUnit.equals(that.estimatedWeightHandlingFeePerUnit) : that.estimatedWeightHandlingFeePerUnit != null)
            return false;
        if (expectedFulfillmentFeePerUnit != null ? !expectedFulfillmentFeePerUnit.equals(that.expectedFulfillmentFeePerUnit) : that.expectedFulfillmentFeePerUnit != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + (syncFirst != null ? syncFirst.hashCode() : 0);
        result = 31 * result + (syncLast != null ? syncLast.hashCode() : 0);
        result = 31 * result + (sku != null ? sku.hashCode() : 0);
        result = 31 * result + (fnsku != null ? fnsku.hashCode() : 0);
        result = 31 * result + (asin != null ? asin.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productGroup != null ? productGroup.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (fulfilledBy != null ? fulfilledBy.hashCode() : 0);
        result = 31 * result + (yourPrice != null ? yourPrice.hashCode() : 0);
        result = 31 * result + (salesPrice != null ? salesPrice.hashCode() : 0);
        result = 31 * result + (longestSide != null ? longestSide.hashCode() : 0);
        result = 31 * result + (medianSide != null ? medianSide.hashCode() : 0);
        result = 31 * result + (shortestSide != null ? shortestSide.hashCode() : 0);
        result = 31 * result + (lengthAndGirth != null ? lengthAndGirth.hashCode() : 0);
        result = 31 * result + (unitOfDimension != null ? unitOfDimension.hashCode() : 0);
        result = 31 * result + (itemPackageWeight != null ? itemPackageWeight.hashCode() : 0);
        result = 31 * result + (unitOfWeight != null ? unitOfWeight.hashCode() : 0);
        result = 31 * result + (productSizeTier != null ? productSizeTier.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (estimatedFeeTotal != null ? estimatedFeeTotal.hashCode() : 0);
        result = 31 * result + (estimatedReferralFeePerUnit != null ? estimatedReferralFeePerUnit.hashCode() : 0);
        result = 31 * result + (estimatedVariableClosingFee != null ? estimatedVariableClosingFee.hashCode() : 0);
        result = 31 * result + (estimatedOrderHandlingFeePerOrder != null ? estimatedOrderHandlingFeePerOrder.hashCode() : 0);
        result = 31 * result + (estimatedPickPackFeePerUnit != null ? estimatedPickPackFeePerUnit.hashCode() : 0);
        result = 31 * result + (estimatedWeightHandlingFeePerUnit != null ? estimatedWeightHandlingFeePerUnit.hashCode() : 0);
        result = 31 * result + (expectedFulfillmentFeePerUnit != null ? expectedFulfillmentFeePerUnit.hashCode() : 0);
        return result;
    }
}
