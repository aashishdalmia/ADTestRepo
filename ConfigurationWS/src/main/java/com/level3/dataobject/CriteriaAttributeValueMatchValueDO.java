package com.level3.dataobject;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.level3.entity.CriteriaAttributeValue;

@XmlRootElement
public class CriteriaAttributeValueMatchValueDO implements Serializable {

	private static final long serialVersionUID = -8865658746350583376L;

	@XmlAttribute
	private Long id;
	
	@XmlElement
	private String value;

	public CriteriaAttributeValueMatchValueDO(){
	}
	
	public CriteriaAttributeValueMatchValueDO(CriteriaAttributeValue criteriaAttributeValue, String value){
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
