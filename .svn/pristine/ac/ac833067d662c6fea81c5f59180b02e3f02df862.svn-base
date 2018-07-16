package com.itecheasy.core.po;

import javax.persistence.*;
import java.util.Date;

/**
 * @author taozihao
 * @date 2018年7月3日 下午6:41:35
 * @description 海运备货计划操作日志
 */
@Entity
@Table(name = "sea_transportation_prepare_plan_operate_log")
public class SeaTransportationPreparePlanOperateLogPO {
    private int id;
    private String comment;
    private Integer seaTransportationPreparePlanId;
    private Date operateDate;
    private Integer operatorId;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "comment", nullable = true, length = 500)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Column(name = "sea_transportation_prepare_plan_id", nullable = true)
    public Integer getSeaTransportationPreparePlanId() {
        return seaTransportationPreparePlanId;
    }

    public void setSeaTransportationPreparePlanId(Integer seaTransportationPreparePlanId) {
        this.seaTransportationPreparePlanId = seaTransportationPreparePlanId;
    }

    @Column(name = "operate_date", nullable = true)
    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    @Column(name = "operator_id", nullable = true)
    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

}
