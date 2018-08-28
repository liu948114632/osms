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
import java.util.Date;
import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/8/24 09:52
 * @Description:
 */
@Entity
@Table(name = "line_of_business", schema = "dbo")
public class LineOfBusinessPO {
    private int id;

    private String lineOfBusinessName;
    private BigDecimal normalProductStockCycle;
    private BigDecimal superLongPrepareProductStockCycle;
    private String lineOfBusinessExplain;
    private Date createTime;
    private Date lastUpdateTime;
    private Integer lineOfBusinessStatus;


    /**
     * 业务线绑定的店铺的Id
     */
    private Integer businessBindShopId;


    /**
     * 业务线id
     */
    private String lineOfBusinessId;

    @Basic
    @Column(name = "line_of_business_id")
    public String getLineOfBusinessId() {
        return lineOfBusinessId;
    }

    public void setLineOfBusinessId(String lineOfBusinessId) {
        this.lineOfBusinessId = lineOfBusinessId;
    }





    @Basic
    @Column(name = "business_bind_shop_id", nullable = true)
    public Integer getBusinessBindShopId() {
        return businessBindShopId;
    }

    public void setBusinessBindShopId(Integer businessBindShopId) {
        this.businessBindShopId = businessBindShopId;
    }





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
    @Column(name = "line_of_business_name", nullable = true, length = 230)
    public String getLineOfBusinessName() {
        return lineOfBusinessName;
    }

    public void setLineOfBusinessName(String lineOfBusinessName) {
        this.lineOfBusinessName = lineOfBusinessName;
    }

    @Basic
    @Column(name = "normal_product_stock_cycle", nullable = true, precision = 3)
    public BigDecimal getNormalProductStockCycle() {
        return normalProductStockCycle;
    }

    public void setNormalProductStockCycle(BigDecimal normalProductStockCycle) {
        this.normalProductStockCycle = normalProductStockCycle;
    }

    @Basic
    @Column(name = "super_long_prepare_product_stock_cycle", nullable = true, precision = 3)
    public BigDecimal getSuperLongPrepareProductStockCycle() {
        return superLongPrepareProductStockCycle;
    }

    public void setSuperLongPrepareProductStockCycle(BigDecimal superLongPrepareProductStockCycle) {
        this.superLongPrepareProductStockCycle = superLongPrepareProductStockCycle;
    }

    @Basic
    @Column(name = "line_of_business_explain", nullable = true, length = 230)
    public String getLineOfBusinessExplain() {
        return lineOfBusinessExplain;
    }

    public void setLineOfBusinessExplain(String lineOfBusinessExplain) {
        this.lineOfBusinessExplain = lineOfBusinessExplain;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "last_update_time", nullable = true)
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Basic
    @Column(name = "line_of_business_status", nullable = true)
    public Integer getLineOfBusinessStatus() {
        return lineOfBusinessStatus;
    }

    public void setLineOfBusinessStatus(Integer lineOfBusinessStatus) {
        this.lineOfBusinessStatus = lineOfBusinessStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineOfBusinessPO that = (LineOfBusinessPO) o;

        if (id != that.id) return false;
        if (lineOfBusinessName != null ? !lineOfBusinessName.equals(that.lineOfBusinessName) : that.lineOfBusinessName != null)
            return false;
        if (normalProductStockCycle != null ? !normalProductStockCycle.equals(that.normalProductStockCycle) : that.normalProductStockCycle != null)
            return false;
        if (superLongPrepareProductStockCycle != null ? !superLongPrepareProductStockCycle.equals(that.superLongPrepareProductStockCycle) : that.superLongPrepareProductStockCycle != null)
            return false;
        if (lineOfBusinessExplain != null ? !lineOfBusinessExplain.equals(that.lineOfBusinessExplain) : that.lineOfBusinessExplain != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (lastUpdateTime != null ? !lastUpdateTime.equals(that.lastUpdateTime) : that.lastUpdateTime != null)
            return false;
        if (lineOfBusinessStatus != null ? !lineOfBusinessStatus.equals(that.lineOfBusinessStatus) : that.lineOfBusinessStatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lineOfBusinessName != null ? lineOfBusinessName.hashCode() : 0);
        result = 31 * result + (normalProductStockCycle != null ? normalProductStockCycle.hashCode() : 0);
        result = 31 * result + (superLongPrepareProductStockCycle != null ? superLongPrepareProductStockCycle.hashCode() : 0);
        result = 31 * result + (lineOfBusinessExplain != null ? lineOfBusinessExplain.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (lastUpdateTime != null ? lastUpdateTime.hashCode() : 0);
        result = 31 * result + (lineOfBusinessStatus != null ? lineOfBusinessStatus.hashCode() : 0);
        return result;
    }
}
