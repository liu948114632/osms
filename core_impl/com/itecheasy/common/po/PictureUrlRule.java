package com.itecheasy.common.po;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="common_picture_url_rule")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PictureUrlRule
  implements Serializable
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 4859554158429231476L;
private Integer id;
  private String storeRule;
  private String urlPath;
  private Integer ruleOrder;

  @Id
  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  @Column(name="store_rule")
  public String getStoreRule() {
    return this.storeRule;
  }

  public void setStoreRule(String storeRule) {
    this.storeRule = storeRule;
  }
  @Column(name="url_path")
  public String getUrlPath() {
    return this.urlPath;
  }

  public void setUrlPath(String urlPath) {
    this.urlPath = urlPath;
  }
  @Column(name="rule_order")
  public Integer getRuleOrder() {
    return this.ruleOrder;
  }

  public void setRuleOrder(Integer ruleOrder) {
    this.ruleOrder = ruleOrder;
  }
}