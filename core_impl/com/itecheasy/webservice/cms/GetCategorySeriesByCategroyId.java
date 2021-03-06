
package com.itecheasy.webservice.cms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getCategorySeriesByCategroyId complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="getCategorySeriesByCategroyId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="categoryId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCategorySeriesByCategroyId", propOrder = {
    "categoryId"
})
public class GetCategorySeriesByCategroyId {

    protected int categoryId;

    /**
     * 获取categoryId属性的值。
     * 
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * 设置categoryId属性的值。
     * 
     */
    public void setCategoryId(int value) {
        this.categoryId = value;
    }

}
