package com.itecheasy.test.hibernateG;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "fba_replenishment_plan_operate_log", schema = "dbo", catalog = "Develop_OSMS")
public class FbaReplenishmentPlanOperateLogEntity {
    private int id;
    private Integer replenishmentPlanId;
    private String comment;
    private String operator;
    private Timestamp operateTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "replenishment_plan_id")
    public Integer getReplenishmentPlanId() {
        return replenishmentPlanId;
    }

    public void setReplenishmentPlanId(Integer replenishmentPlanId) {
        this.replenishmentPlanId = replenishmentPlanId;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "operator")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Basic
    @Column(name = "operate_time")
    public Timestamp getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Timestamp operateTime) {
        this.operateTime = operateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FbaReplenishmentPlanOperateLogEntity that = (FbaReplenishmentPlanOperateLogEntity) o;

        if (id != that.id) return false;
        if (replenishmentPlanId != null ? !replenishmentPlanId.equals(that.replenishmentPlanId) : that.replenishmentPlanId != null)
            return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (operateTime != null ? !operateTime.equals(that.operateTime) : that.operateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (replenishmentPlanId != null ? replenishmentPlanId.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (operateTime != null ? operateTime.hashCode() : 0);
        return result;
    }
}
