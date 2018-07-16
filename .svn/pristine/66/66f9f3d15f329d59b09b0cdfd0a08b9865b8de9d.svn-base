package com.itecheasy.core.order;

/**
 * @author wanghw
 * @date 2016-1-16
 * @description 新增订单时匹配的条件
 * @version
 */
public class ConditionOfAddNewOrder {
	// 标识订单状态
	private int order_status = 1;
	// 带电标识
	private boolean isElectronic = false;

	// 无法识别备货商品的pending订单 sp 1.2.2
	private boolean _not_recognition = false;

	private int shippingMethod = 0;

	// 订单运费
	double shipTotalPrice = 0d;
	// 订单成本价
	double _cost_price = 0d;
	// 订单问题
	int problem = 0;
	//总批重
	private double unitWeightTotal=0d;

	public ConditionOfAddNewOrder() {
		super();
		this.order_status = 1;
		this.isElectronic = false;
		this._not_recognition = false;
		this.shippingMethod = 0;
		this.shipTotalPrice = 0;
		this._cost_price = 0;
		this.problem = 0;
		this.unitWeightTotal=0d;
	}

	public double getShipTotalPrice() {
		return shipTotalPrice;
	}

	public void setShipTotalPrice(double shipTotalPrice) {
		this.shipTotalPrice = shipTotalPrice;
	}

	public double get_cost_price() {
		return _cost_price;
	}

	public void set_cost_price(double _cost_price) {
		this._cost_price = _cost_price;
	}

	public int getProblem() {
		return problem;
	}

	public void setProblem(int problem) {
		this.problem = problem;
	}

	public int getOrder_status() {
		return order_status;
	}

	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}

	public boolean isElectronic() {
		return isElectronic;
	}

	public void setElectronic(boolean isElectronic) {
		this.isElectronic = isElectronic;
	}

	public boolean is_not_recognition() {
		return _not_recognition;
	}

	public void set_not_recognition(boolean _not_recognition) {
		this._not_recognition = _not_recognition;
	}

	public int getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(int shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public double getUnitWeightTotal() {
		return unitWeightTotal;
	}

	public void setUnitWeightTotal(double unitWeightTotal) {
		this.unitWeightTotal = unitWeightTotal;
	}

	
}
