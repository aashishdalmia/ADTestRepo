package com.level3.dataobject;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.level3.entity.Criteria;

@XmlRootElement
public class CriteriaAttributeDO implements Serializable{

	private static final long serialVersionUID = -6856090192931047275L;

	@XmlAttribute
	private Long id;
	
	@XmlElement
	private CriteriaAttributeNameDO crtAttrName;
	
	@XmlElement
	private Set<CriteriaAttributeValueDO> criteriaAttributeValues = new HashSet<CriteriaAttributeValueDO>();
	
	public CriteriaAttributeDO(){		
	}
	
	public CriteriaAttributeDO(Criteria criteria, Set<CriteriaAttributeValueDO> criteriaAttributeValues){
		this.criteriaAttributeValues = criteriaAttributeValues;
	}
	
	public Long getId() {
		return id;
	}	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public CriteriaAttributeNameDO getCriteriaAttributeName() {
		return crtAttrName;
	}

	public void setCriteriaAttributeName(CriteriaAttributeNameDO crtAttrName) {
		this.crtAttrName = crtAttrName;
	}
	
	public Set<CriteriaAttributeValueDO> getCriteriaAttributeValues() {
		return criteriaAttributeValues;
	}
	
	public void setCriteriaAttributeValues(Set<CriteriaAttributeValueDO> criteriaAttributeValues) {
		this.criteriaAttributeValues = criteriaAttributeValues;
	}	
}

