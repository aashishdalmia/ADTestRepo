package com.level3.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CRITERIA_ATTRIBUTE_NAME")
public class CriteriaAttributeName implements Serializable {

	private static final long serialVersionUID = 7299060243576004349L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;	
	
	@Column(name = "NAME")
	private String name;
	
	public CriteriaAttributeName(){		
	}
	
	public CriteriaAttributeName(CriteriaAttribute criteriaAttribute, String name){
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}	
	public void setId(Long id) {
		this.id = id;
	}	
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
}
