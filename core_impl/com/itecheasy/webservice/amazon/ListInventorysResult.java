
package com.itecheasy.webservice.amazon;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>listInventorysResult complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="listInventorysResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fbaInventorys" type="{http://amazon.core.itecheasy.com/}fbaInventory" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="marketplaceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nextToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sellerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listInventorysResult", propOrder = {
    "fbaInventorys",
    "marketplaceId",
    "nextToken",
    "sellerId"
})
public class ListInventorysResult {

    @XmlElement(nillable = true)
    protected List<FbaInventory> fbaInventorys;
    protected String marketplaceId;
    protected String nextToken;
    protected String sellerId;

    /**
     * Gets the value of the fbaInventorys property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fbaInventorys property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFbaInventorys().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FbaInventory }
     * 
     * 
     */
    public List<FbaInventory> getFbaInventorys() {
        if (fbaInventorys == null) {
            fbaInventorys = new ArrayList<FbaInventory>();
        }
        return this.fbaInventorys;
    }

    /**
     * 获取marketplaceId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarketplaceId() {
        return marketplaceId;
    }

    /**
     * 设置marketplaceId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarketplaceId(String value) {
        this.marketplaceId = value;
    }

    /**
     * 获取nextToken属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextToken() {
        return nextToken;
    }

    /**
     * 设置nextToken属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextToken(String value) {
        this.nextToken = value;
    }

    /**
     * 获取sellerId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * 设置sellerId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerId(String value) {
        this.sellerId = value;
    }

}
