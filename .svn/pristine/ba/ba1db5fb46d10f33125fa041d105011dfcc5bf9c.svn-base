package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author taozihao
 * @date 2018年8月24日 下午5:17:34
 * @description 清仓跟踪操作记录
 */
@Entity
@Table(name = "clear_inventory_tracking_operate_log" )
public class ClearInventoryTrackingOperateLogPO {
    private int id;
    private Integer clearInventoryTrackingId;
    private Integer operatorId;
    private Date operateTime;
    private String comment;

    @Id
    @GeneratedValue
    @Column(name = "id" )
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "clear_inventory_tracking_id" )
    public Integer getClearInventoryTrackingId() {
        return clearInventoryTrackingId;
    }

    public void setClearInventoryTrackingId(Integer clearInventoryTrackingId) {
        this.clearInventoryTrackingId = clearInventoryTrackingId;
    }

    @Basic
    @Column(name = "operator_id" )
    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    @Basic
    @Column(name = "operate_time" )
    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    @Basic
    @Column(name = "comment" )
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
