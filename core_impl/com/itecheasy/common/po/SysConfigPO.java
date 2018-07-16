package com.itecheasy.common.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="common_sys_config")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SysConfigPO
  implements Serializable
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 4560858288417431722L;
private Integer id;
  private String model;
  private String key;
  private String value;
  private String valueText;
  private String remark;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getModel() {
    return this.model;
  }

  public void setModel(String model) {
    this.model = model;
  }
  @Column(name="_key")
  public String getKey() {
    return this.key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }
  @Column(name="value_text")
  public String getValueText() {
    return this.valueText;
  }

  public void setValueText(String valueText) {
    this.valueText = valueText;
  }

  public String getRemark() {
    return this.remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }
}