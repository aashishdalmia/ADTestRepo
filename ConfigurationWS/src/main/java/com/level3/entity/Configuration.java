package com.level3.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "CONFIGURATION")
public class Configuration implements Serializable {

	
	private static final long serialVersionUID = -6228401856797947844L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "CRITERIA_ID")
	private Long criteriaId;
	
	@Column(name = "TEMPLATE")
	private String templ;
	
	public Long getId() {
		return this.id;
	} 
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getCriteriaId(){
		return this.criteriaId;
	}
	
	public void setCriteriaId(Long criteriaId){
		this.criteriaId = criteriaId;
	}
	
	public String getTemplate(){
		return this.templ;
	}
	
	public void setTemplate(String templ){
		this.templ = templ;
	}
}
