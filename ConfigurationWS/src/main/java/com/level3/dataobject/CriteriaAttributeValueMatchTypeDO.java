package com.level3.dataobject;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CriteriaAttributeValueMatchTypeDO implements Serializable {
	
	private static final long serialVersionUID = -428961946648086143L;

	@XmlAttribute
	private Long id;
	
	@XmlElement
	private String type;

	public  CriteriaAttributeValueMatchTypeDO(){		
	}
	
	public CriteriaAttributeValueMatchTypeDO(CriteriaAttributeValueDO criteriaAttributeValue, String type){
		this.type = type;
	}
	
	public Long getCriteriaAttributeValueMatchTypeId() {
		return id;
	}

	public void setCriteriaAttributeValueMatchTypeId(Long id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}	

	public void setType(String type) {
		this.type = type;
	}

}
