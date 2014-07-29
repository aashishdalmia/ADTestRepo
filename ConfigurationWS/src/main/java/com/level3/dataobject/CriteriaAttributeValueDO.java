package com.level3.dataobject;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CriteriaAttributeValueDO implements Serializable {

	private static final long serialVersionUID = -4434350615593262470L;

	@XmlAttribute
	private Long id;	
	
	@XmlElement
	private CriteriaAttributeValueMatchTypeDO cavmt;
	
	@XmlElement
	private CriteriaAttributeValueMatchValueDO cavmv;

	public CriteriaAttributeValueDO(){
	}
	
	public CriteriaAttributeValueMatchValueDO getCriteriaAttributeValueMatchValue() {
		return cavmv;
	}

	public void setCriteriaAttributeValueMatchValue(CriteriaAttributeValueMatchValueDO cavmv) {
		this.cavmv = cavmv;
	}

	public CriteriaAttributeValueMatchTypeDO getCriteriaAttributeValueMatchType() {
		return cavmt;
	}

	public void setCriteriaAttributeValueMatchType(CriteriaAttributeValueMatchTypeDO cavmt) {
		this.cavmt = cavmt;
	}

	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
}
