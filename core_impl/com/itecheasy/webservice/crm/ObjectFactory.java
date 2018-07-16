package com.itecheasy.webservice.crm;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.itecheasy.webservice.crm package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _AccountSetting_QNAME = new QName("http://tempuri.org/", "AccountSetting");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: com.itecheasy.webservice.crm
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link GetFirstWayOrderResponse }
	 * 
	 */
	public GetFirstWayOrderResponse createGetFirstWayOrderResponse() {
		return new GetFirstWayOrderResponse();
	}

	/**
	 * Create an instance of {@link GetFirstWayOrder }
	 * 
	 */
	public GetFirstWayOrder createGetFirstWayOrder() {
		return new GetFirstWayOrder();
	}

	/**
	 * Create an instance of {@link IsOrderLimitModifyByOrderIdResponse }
	 * 
	 */
	public IsOrderLimitModifyByOrderIdResponse createIsOrderLimitModifyByOrderIdResponse() {
		return new IsOrderLimitModifyByOrderIdResponse();
	}

	/**
	 * Create an instance of {@link ArrayOfOrderItem }
	 * 
	 */
	public ArrayOfOrderItem createArrayOfOrderItem() {
		return new ArrayOfOrderItem();
	}

	/**
	 * Create an instance of {@link FirstWayOrderInfo }
	 * 
	 */
	public FirstWayOrderInfo createFirstWayOrderInfo() {
		return new FirstWayOrderInfo();
	}

	/**
	 * Create an instance of {@link IsOrderLimitModifyByProductIdResponse }
	 * 
	 */
	public IsOrderLimitModifyByProductIdResponse createIsOrderLimitModifyByProductIdResponse() {
		return new IsOrderLimitModifyByProductIdResponse();
	}

	/**
	 * Create an instance of {@link OrderItem }
	 * 
	 */
	public OrderItem createOrderItem() {
		return new OrderItem();
	}

	/**
	 * Create an instance of {@link AccountSetting }
	 * 
	 */
	public AccountSetting createAccountSetting() {
		return new AccountSetting();
	}

	/**
	 * Create an instance of {@link IsOrderLimitModifyByOrderId }
	 * 
	 */
	public IsOrderLimitModifyByOrderId createIsOrderLimitModifyByOrderId() {
		return new IsOrderLimitModifyByOrderId();
	}

	/**
	 * Create an instance of {@link ShopCustomerOrderItem }
	 * 
	 */
	public ShopCustomerOrderItem createShopCustomerOrderItem() {
		return new ShopCustomerOrderItem();
	}

	/**
	 * Create an instance of {@link IsOrderLimitModifyByProductId }
	 * 
	 */
	public IsOrderLimitModifyByProductId createIsOrderLimitModifyByProductId() {
		return new IsOrderLimitModifyByProductId();
	}

	/**
	 * Create an instance of {@link ArrayOfFirstWayOrderInfo }
	 * 
	 */
	public ArrayOfFirstWayOrderInfo createArrayOfFirstWayOrderInfo() {
		return new ArrayOfFirstWayOrderInfo();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link AccountSetting }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "AccountSetting")
	public JAXBElement<AccountSetting> createAccountSetting(AccountSetting value) {
		return new JAXBElement<AccountSetting>(_AccountSetting_QNAME, AccountSetting.class, null, value);
	}

}
