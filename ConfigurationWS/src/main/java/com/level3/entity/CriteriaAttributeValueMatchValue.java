package com.level3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "CRIT_ATTR_VAL_MATCH_VALUE")
public class CriteriaAttributeValueMatchValue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
		
	@Column(name = "VALUE")
	private String value;

	public CriteriaAttributeValueMatchValue(){		
	}
	
	public CriteriaAttributeValueMatchValue(CriteriaAttributeValue criteriaAttributeValue, String value){
		this.value = value;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
		
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
