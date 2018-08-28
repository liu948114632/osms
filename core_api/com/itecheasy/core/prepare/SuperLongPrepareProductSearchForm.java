/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.prepare;

import com.itecheasy.core.BaseSearchForm;

import java.util.Date;
import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/8/24 17:02
 * @Description:
 */
public class SuperLongPrepareProductSearchForm extends BaseSearchForm {


    private List<String> cmsCodes;

    private List<String> cmsCodeName;

    private Integer operatorId;

    private Date joinSuperLongPrepareProductDate;


    public Date getJoinSuperLongPrepareProductDate() {
        return joinSuperLongPrepareProductDate;
    }

    public void setJoinSuperLongPrepareProductDate(Date joinSuperLongPrepareProductDate) {
        this.joinSuperLongPrepareProductDate = joinSuperLongPrepareProductDate;
    }

    public List<String> getCmsCodes() {
        return cmsCodes;
    }

    public void setCmsCodes(List<String> cmsCodes) {
        this.cmsCodes = cmsCodes;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public List<String> getCmsCodeName() {
        return cmsCodeName;
    }

    public void setCmsCodeName(List<String> cmsCodeName) {
        this.cmsCodeName = cmsCodeName;
    }
}