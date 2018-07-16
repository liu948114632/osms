package com.itecheasy.core.fba;

/**
 * @author whw
 * @date 2017-8-16
 * @description 淡旺季规则
 * @version
 */
public class MonthlyPeakOrLowRule {
	public enum PeakOrLowRuleKey {
		/**
		 * 四周销量起始值
		 */
		low_Sales,
		/**
		 * 国内库存批量/总的最近四周销量 (比较值)
		 */
		low_inventory_sales_specific,
		/**
		 *比较（ 国内库存批量/总的最近四周销量 ）的符号
		 */
		low_inventory_sales_specific_comparative,
		
		/**
		 * 销量系数（计算待补货批量）
		 */
		low_sales_coefficient,
		
		/**
		 * 比较模式 1、国内库存批量/总的最近四周销量  或者 0、库存
		 */
		low_inventory_or_sales_select,
		
		/**
		 * 四周销量起始值
		 */
		Peak_Sales,
		/**
		 * 国内库存批量/总的最近四周销量 (比较值)
		 */
		Peak_inventory_sales_specific,
		/**
		 *比较（ 国内库存批量/总的最近四周销量 ）的符号
		 */
		Peak_inventory_sales_specific_comparative,
		
		/**
		 * 销量系数（计算待补货批量）
		 */
		Peak_sales_coefficient,
		/**
		 * 比较模式 1、国内库存批量/总的最近四周销量  或者 0、库存
		 */
		Peak_inventory_or_sales_select,
		
		/**
		 * 四周销量结束值
		 */
		low_Sales_end,
		
		/**
		 * 四周销量结束值
		 */
		Peak_Sales_end,
	}

	private PeakOrLowRuleKey ruleKey;
	private String value;
	private int sort;

	public PeakOrLowRuleKey getRuleKey() {
		return ruleKey;
	}

	public void setRuleKey(PeakOrLowRuleKey ruleKey) {
		this.ruleKey = ruleKey;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	
	
}
