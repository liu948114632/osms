package com.itecheasy.test.hibernateG;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_prepare_product", schema = "dbo", catalog = "Develop_OSMS")
public class OrderPrepareProductEntity {
    private int id;
    private BigDecimal orderQty;
    private BigDecimal prepareQty;
    private Integer status;
    private Integer cmsProductId;
    private Integer unitQty;
    private String unit;
    private String cmsProductCode;
    private Integer orderId;
    private Integer unitWeight;
    private Integer unitVolume;
    private String box;
    private BigDecimal costPrice;
    private Boolean isLimit;
    private Byte cmsPrepare;
    private Boolean abnormalMate;
    private Boolean electronic;
    private Boolean isDeleted;
    private Boolean magnetism;
    private Boolean textile;
    private String customerRemark;
    private String branchRemark;
    private String csRemark;
    private Boolean swPackageStockOut;
    private String purchaseRemark;
    private Integer moreBatchAuditWaitTaskId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_qty", nullable = true, precision = 2)
    public BigDecimal getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(BigDecimal orderQty) {
        this.orderQty = orderQty;
    }

    @Basic
    @Column(name = "prepare_qty", nullable = true, precision = 2)
    public BigDecimal getPrepareQty() {
        return prepareQty;
    }

    public void setPrepareQty(BigDecimal prepareQty) {
        this.prepareQty = prepareQty;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "cms_product_id", nullable = true)
    public Integer getCmsProductId() {
        return cmsProductId;
    }

    public void setCmsProductId(Integer cmsProductId) {
        this.cmsProductId = cmsProductId;
    }

    @Basic
    @Column(name = "unit_qty", nullable = true)
    public Integer getUnitQty() {
        return unitQty;
    }

    public void setUnitQty(Integer unitQty) {
        this.unitQty = unitQty;
    }

    @Basic
    @Column(name = "unit", nullable = true, length = 10)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "cms_product_code", nullable = true, length = 50)
    public String getCmsProductCode() {
        return cmsProductCode;
    }

    public void setCmsProductCode(String cmsProductCode) {
        this.cmsProductCode = cmsProductCode;
    }

    @Basic
    @Column(name = "order_id", nullable = true)
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "unit_weight", nullable = true, precision = 0)
    public Integer getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(Integer unitWeight) {
        this.unitWeight = unitWeight;
    }

    @Basic
    @Column(name = "unit_volume", nullable = true, precision = 0)
    public Integer getUnitVolume() {
        return unitVolume;
    }

    public void setUnitVolume(Integer unitVolume) {
        this.unitVolume = unitVolume;
    }

    @Basic
    @Column(name = "box", nullable = true, length = 50)
    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    @Basic
    @Column(name = "cost_price", nullable = true, precision = 3)
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    @Basic
    @Column(name = "is_limit", nullable = true)
    public Boolean getLimit() {
        return isLimit;
    }

    public void setLimit(Boolean limit) {
        isLimit = limit;
    }

    @Basic
    @Column(name = "cms_prepare", nullable = true)
    public Byte getCmsPrepare() {
        return cmsPrepare;
    }

    public void setCmsPrepare(Byte cmsPrepare) {
        this.cmsPrepare = cmsPrepare;
    }

    @Basic
    @Column(name = "abnormal_mate", nullable = true)
    public Boolean getAbnormalMate() {
        return abnormalMate;
    }

    public void setAbnormalMate(Boolean abnormalMate) {
        this.abnormalMate = abnormalMate;
    }

    @Basic
    @Column(name = "electronic", nullable = true)
    public Boolean getElectronic() {
        return electronic;
    }

    public void setElectronic(Boolean electronic) {
        this.electronic = electronic;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Basic
    @Column(name = "magnetism", nullable = true)
    public Boolean getMagnetism() {
        return magnetism;
    }

    public void setMagnetism(Boolean magnetism) {
        this.magnetism = magnetism;
    }

    @Basic
    @Column(name = "Textile", nullable = true)
    public Boolean getTextile() {
        return textile;
    }

    public void setTextile(Boolean textile) {
        this.textile = textile;
    }

    @Basic
    @Column(name = "customer_remark", nullable = true, length = 500)
    public String getCustomerRemark() {
        return customerRemark;
    }

    public void setCustomerRemark(String customerRemark) {
        this.customerRemark = customerRemark;
    }

    @Basic
    @Column(name = "branch_remark", nullable = true, length = 500)
    public String getBranchRemark() {
        return branchRemark;
    }

    public void setBranchRemark(String branchRemark) {
        this.branchRemark = branchRemark;
    }

    @Basic
    @Column(name = "cs_remark", nullable = true, length = 500)
    public String getCsRemark() {
        return csRemark;
    }

    public void setCsRemark(String csRemark) {
        this.csRemark = csRemark;
    }

    @Basic
    @Column(name = "sw_package_stock_out", nullable = true)
    public Boolean getSwPackageStockOut() {
        return swPackageStockOut;
    }

    public void setSwPackageStockOut(Boolean swPackageStockOut) {
        this.swPackageStockOut = swPackageStockOut;
    }

    @Basic
    @Column(name = "purchase_remark", nullable = true, length = 2147483647)
    public String getPurchaseRemark() {
        return purchaseRemark;
    }

    public void setPurchaseRemark(String purchaseRemark) {
        this.purchaseRemark = purchaseRemark;
    }

    @Basic
    @Column(name = "more_batch_audit_wait_task_id", nullable = true)
    public Integer getMoreBatchAuditWaitTaskId() {
        return moreBatchAuditWaitTaskId;
    }

    public void setMoreBatchAuditWaitTaskId(Integer moreBatchAuditWaitTaskId) {
        this.moreBatchAuditWaitTaskId = moreBatchAuditWaitTaskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderPrepareProductEntity that = (OrderPrepareProductEntity) o;

        if (id != that.id) return false;
        if (orderQty != null ? !orderQty.equals(that.orderQty) : that.orderQty != null) return false;
        if (prepareQty != null ? !prepareQty.equals(that.prepareQty) : that.prepareQty != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (cmsProductId != null ? !cmsProductId.equals(that.cmsProductId) : that.cmsProductId != null) return false;
        if (unitQty != null ? !unitQty.equals(that.unitQty) : that.unitQty != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        if (cmsProductCode != null ? !cmsProductCode.equals(that.cmsProductCode) : that.cmsProductCode != null)
            return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (unitWeight != null ? !unitWeight.equals(that.unitWeight) : that.unitWeight != null) return false;
        if (unitVolume != null ? !unitVolume.equals(that.unitVolume) : that.unitVolume != null) return false;
        if (box != null ? !box.equals(that.box) : that.box != null) return false;
        if (costPrice != null ? !costPrice.equals(that.costPrice) : that.costPrice != null) return false;
        if (cmsPrepare != null ? !cmsPrepare.equals(that.cmsPrepare) : that.cmsPrepare != null) return false;
        if (abnormalMate != null ? !abnormalMate.equals(that.abnormalMate) : that.abnormalMate != null) return false;
        if (electronic != null ? !electronic.equals(that.electronic) : that.electronic != null) return false;
        if (magnetism != null ? !magnetism.equals(that.magnetism) : that.magnetism != null) return false;
        if (textile != null ? !textile.equals(that.textile) : that.textile != null) return false;
        if (customerRemark != null ? !customerRemark.equals(that.customerRemark) : that.customerRemark != null)
            return false;
        if (branchRemark != null ? !branchRemark.equals(that.branchRemark) : that.branchRemark != null) return false;
        if (csRemark != null ? !csRemark.equals(that.csRemark) : that.csRemark != null) return false;
        if (swPackageStockOut != null ? !swPackageStockOut.equals(that.swPackageStockOut) : that.swPackageStockOut != null)
            return false;
        if (purchaseRemark != null ? !purchaseRemark.equals(that.purchaseRemark) : that.purchaseRemark != null)
            return false;
        if (moreBatchAuditWaitTaskId != null ? !moreBatchAuditWaitTaskId.equals(that.moreBatchAuditWaitTaskId) : that.moreBatchAuditWaitTaskId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (orderQty != null ? orderQty.hashCode() : 0);
        result = 31 * result + (prepareQty != null ? prepareQty.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (cmsProductId != null ? cmsProductId.hashCode() : 0);
        result = 31 * result + (unitQty != null ? unitQty.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (cmsProductCode != null ? cmsProductCode.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (unitWeight != null ? unitWeight.hashCode() : 0);
        result = 31 * result + (unitVolume != null ? unitVolume.hashCode() : 0);
        result = 31 * result + (box != null ? box.hashCode() : 0);
        result = 31 * result + (costPrice != null ? costPrice.hashCode() : 0);
        result = 31 * result + (cmsPrepare != null ? cmsPrepare.hashCode() : 0);
        result = 31 * result + (abnormalMate != null ? abnormalMate.hashCode() : 0);
        result = 31 * result + (electronic != null ? electronic.hashCode() : 0);
        result = 31 * result + (magnetism != null ? magnetism.hashCode() : 0);
        result = 31 * result + (textile != null ? textile.hashCode() : 0);
        result = 31 * result + (customerRemark != null ? customerRemark.hashCode() : 0);
        result = 31 * result + (branchRemark != null ? branchRemark.hashCode() : 0);
        result = 31 * result + (csRemark != null ? csRemark.hashCode() : 0);
        result = 31 * result + (swPackageStockOut != null ? swPackageStockOut.hashCode() : 0);
        result = 31 * result + (purchaseRemark != null ? purchaseRemark.hashCode() : 0);
        result = 31 * result + (moreBatchAuditWaitTaskId != null ? moreBatchAuditWaitTaskId.hashCode() : 0);
        return result;
    }
}
