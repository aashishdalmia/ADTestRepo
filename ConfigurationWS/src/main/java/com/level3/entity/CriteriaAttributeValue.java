package com.level3.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CRITERIA_ATTRIBUTE_VALUE")
public class CriteriaAttributeValue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id; 
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "CRIT_ATTR_VAL_MATCH_TYPE_ID", referencedColumnName = "ID" )	
	private CriteriaAttributeValueMatchType cavmt;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "CRIT_ATTR_VAL_MATCH_VALUE_ID", referencedColumnName = "ID" )
	private CriteriaAttributeValueMatchValue cavmv;
	
	public CriteriaAttributeValue(){
	}
	
	public CriteriaAttributeValueMatchValue getCriteriaAttributeValueMatchValue() {
		return cavmv;
	}

	public void setCriteriaAttributeValueMatchValue(CriteriaAttributeValueMatchValue cavmv) {
		this.cavmv = cavmv;
	}

	public CriteriaAttributeValueMatchType getCriteriaAttributeValueMatchType() {
		return cavmt;
	}

	public void setCriteriaAttributeValueMatchType(CriteriaAttributeValueMatchType cavmt) {
		this.cavmt = cavmt;
	}


	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
}
