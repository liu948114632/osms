package com.itecheasy.common.po;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "common_picture_store_rule")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PictureStoreRule implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2853583155858856439L;
	private Integer id;
	private String pictureRule;
	private String storePath;
	private Integer ruleOrder;

	@Id
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "picture_rule")
	public String getPictureRule() {
		return this.pictureRule;
	}

	public void setPictureRule(String pictureRule) {
		this.pictureRule = pictureRule;
	}

	@Column(name = "store_path")
	public String getStorePath() {
		return this.storePath;
	}

	public void setStorePath(String storePath) {
		this.storePath = storePath;
	}

	@Column(name = "rule_order")
	public Integer getRuleOrder() {
		return this.ruleOrder;
	}

	public void setRuleOrder(Integer ruleOrder) {
		this.ruleOrder = ruleOrder;
	}
}