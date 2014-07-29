package com.level3.dataobject;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CriteriaDO implements Serializable {
	
	private static final long serialVersionUID = -5291736947176713897L;

	@XmlAttribute
	private Long id;
	
	@XmlElement
	private Set<CriteriaAttributeDO> criteriaAttributes = new HashSet<CriteriaAttributeDO>();
	
	public CriteriaDO(){		
	}
	
	public CriteriaDO(Set<CriteriaAttributeDO> criteriaAttributes){
		this.criteriaAttributes = criteriaAttributes;
	}
	
	public Long getId() {
		return this.id;
	} 
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Set<CriteriaAttributeDO> getCriteriaAttributes() {
		return this.criteriaAttributes;
	}
	
	public void setCriteriaAttributes(Set<CriteriaAttributeDO> criteriaAttributes){	
		this.criteriaAttributes = criteriaAttributes;
	}

	
}
