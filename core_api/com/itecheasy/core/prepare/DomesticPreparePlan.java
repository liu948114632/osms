/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.prepare;

/**
 * @Auther: liteng
 * @Date: 2018/8/6 09:30
 * @Description:
 */
public interface DomesticPreparePlan {


    void findDomesticPreparePlanBySku(int PreparePlanStatus,String sku);

    void createDomesticPreparePlan(int PreparePlanStatus,String sku);

    void updateDomesticPreparePlan(int PreparePlanStatus,String sku);

    void cancelDomesticPreparePlan(int PreparePlanStatus,String sku);


    public enum  DomesticPreparePlanStatusEnum {
        //    国内补货计划状态状态
        推荐(1),
        待审核(3),
        已审核(5),
        不通过(8),
        已建单(12),
        删除(15);

        private Integer code;

        DomesticPreparePlanStatusEnum(int code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }

        public DomesticPreparePlanStatusEnum getByCode(Integer code){
            for (DomesticPreparePlanStatusEnum value : DomesticPreparePlanStatusEnum.values()) {
                if (value.getCode().equals(code)){
                    return value;
                }
            }
            return null;
        }


    }
}
