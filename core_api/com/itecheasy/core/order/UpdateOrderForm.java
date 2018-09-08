/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.order;

import java.math.BigDecimal;

/**
 * @Auther: liteng
 * @Date: 2018/9/7 09:24
 * @Description: 更新订单的其他信息
 */
public class UpdateOrderForm {

    private String labelRemark;

    /**
     * 发票金额百分比
     */
    private BigDecimal subTotalPercent;

    /**
     * 报关运费百分比(发票运费百分比)
     */
    private BigDecimal reimburseFreightPercent;

    /**
     * 网站重量
     */
    private Integer webWeight;


    public Integer getWebWeight() {
        return webWeight;
    }

    public void setWebWeight(Integer webWeight) {
        this.webWeight = webWeight;
    }

    public BigDecimal getSubTotalPercent() {
        return subTotalPercent;
    }

    public void setSubTotalPercent(BigDecimal subTotalPercent) {
        this.subTotalPercent = subTotalPercent;
    }

    public BigDecimal getReimburseFreightPercent() {
        return reimburseFreightPercent;
    }

    public void setReimburseFreightPercent(BigDecimal reimburseFreightPercent) {
        this.reimburseFreightPercent = reimburseFreightPercent;
    }

    public String getLabelRemark() {
        return labelRemark;
    }

    public void setLabelRemark(String labelRemark) {
        this.labelRemark = labelRemark;
    }
}
