package com.itecheasy.common.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.itecheasy.common.dao.Order.OrderType;

@SuppressWarnings("unchecked")
public class Criteria {
	private boolean isSubGroup ;
	private List<Restriction> andRestictions;
	private List<Restriction> orRestictions;
	private List<Criteria> orSubCriterias;
	private List<Criteria> andSubCriterias;
	private List<Order> orders ;
	private Class classz;
	private Class currentClassz;
	private Set<Class> classzes = new HashSet<Class>();
	public Criteria(Class classz){
		this.classz = classz;
		currentClassz = classz;
		classzes.add(classz);
		isSubGroup = false;
		andRestictions = new ArrayList<Restriction>();
		orRestictions = new ArrayList<Restriction>();
		orders = new ArrayList<Order>();
		orSubCriterias = new ArrayList<Criteria>();
		andSubCriterias = new ArrayList<Criteria>();
	}
	public Criteria switchSubject(Class<?> classz,String... foreignField){
		if(!classzes.contains(classz)){
			classzes.add(classz);
			if(foreignField != null && foreignField[0] != null){
				and(Restriction.joinCondition(foreignField[0] + " = " + classz.getSimpleName() + ".id"));
			}
		}
		this.currentClassz = classz;
		return this;
	}
	public boolean isValid(){
		return andRestictions.size() > 0 
			| orRestictions.size()>0
			| orSubCriterias.size() > 0
			| andSubCriterias.size() > 0;
	}
	public void clear(){
		isSubGroup = false;
		andRestictions.clear();
		orRestictions.clear();
		orSubCriterias.clear();
		andSubCriterias.clear();
		orders.clear();
		classzes.clear();
		currentClassz = classz;
		classzes.add(classz);
	}
	public Criteria and(Restriction restriction){
		String fieldName = restriction.getAttributeName();
		fieldName = currentClassz.getSimpleName() + "." + fieldName;
		restriction.setAttributeName(fieldName);
		andRestictions.add(restriction);
		return this;
	}
	
	public Criteria or(Restriction restriction){
		String fieldName = restriction.getAttributeName();
		fieldName = currentClassz.getSimpleName() + "." + fieldName;
		restriction.setAttributeName(fieldName);
		orRestictions.add(restriction);
		return this;
	}
	public Criteria order(String orderAttributeName,OrderType orderType){
		orders.add(new Order(currentClassz.getSimpleName() + "." + orderAttributeName,orderType));
		return this;
	}
	public Criteria group(boolean isAndGroup){
		if(this.isSubGroup)
			throw new RuntimeException("the sub criteria is not able to create the create another sub criteria.");
		Criteria c = new Criteria(classz);
		c.isSubGroup = false;
		if(isAndGroup)
			andSubCriterias.add(c);
		else
			orSubCriterias.add(c);
		return c;
	}

	public boolean isSubGroup() {
		return isSubGroup;
	}

	public void setSubGroup(boolean isSubGroup) {
		this.isSubGroup = isSubGroup;
	}

	public List<Restriction> getAndRestictions() {
		return andRestictions;
	}

	public void setAndRestictions(List<Restriction> andRestictions) {
		this.andRestictions = andRestictions;
	}

	public List<Restriction> getOrRestictions() {
		return orRestictions;
	}

	public void setOrRestictions(List<Restriction> orRestictions) {
		this.orRestictions = orRestictions;
	}


	public List<Criteria> getAndSubCriterias() {
		return andSubCriterias;
	}
	public List<Criteria> getOrSubCriterias() {
		return orSubCriterias;
	}

	public void setOrSubCriterias(List<Criteria> orSubCriterias) {
		this.orSubCriterias = orSubCriterias;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public Set<Class> getClasszes() {
		return classzes;
	}
	public Class getClassz() {
		return classz;
	}
	
	
	
}
