package com.level3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CRIT_ATTR_VAL_MATCH_TYPE")
public class CriteriaAttributeValueMatchType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;	
		
	@Column(name = "TYPE")
	private String type;

	public  CriteriaAttributeValueMatchType(){		
	}
	
	public CriteriaAttributeValueMatchType(CriteriaAttributeValue criteriaAttributeValue, String type){
		this.type = type;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}	
	public void setType(String type) {
		this.type = type;
	}


}
