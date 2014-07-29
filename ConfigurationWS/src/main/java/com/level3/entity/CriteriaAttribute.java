package com.level3.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author dalmia.aashish
 *
 */
@Entity
@Table(name = "CRITERIA_ATTRIBUTE")
public class CriteriaAttribute implements Serializable{

	private static final long serialVersionUID = -2068228799660762336L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "CRITERIA_ATTRIBUTE_NAME_ID", referencedColumnName = "ID" )
	private CriteriaAttributeName crtAttrName;


	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name = "CRITATTR_CRITATTRVALUES", joinColumns = {@JoinColumn(name = "CRITERIA_ATTRIBUTE_ID", referencedColumnName = "ID")},
    									  inverseJoinColumns = {@JoinColumn(name = "CRITERIA_ATTRIBUTE_VALUE_ID", referencedColumnName = "ID")}
    )
	private Set<CriteriaAttributeValue> criteriaAttributeValues = new HashSet<CriteriaAttributeValue>();
	
	
	public CriteriaAttribute(){		
	}
	
	public CriteriaAttribute(Criteria criteria, Set<CriteriaAttributeValue> criteriaAttributeValues){
		this.criteriaAttributeValues = criteriaAttributeValues;
	}
	
	public Long getId() {
		return id;
	}	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public CriteriaAttributeName getCriteriaAttributeName() {
		return crtAttrName;
	}

	public void setCriteriaAttributeName(CriteriaAttributeName crtAttrName) {
		this.crtAttrName = crtAttrName;
	}
	
	public Set<CriteriaAttributeValue> getCriteriaAttributeValues() {
		return criteriaAttributeValues;
	}
	
	public void setCriteriaAttributeValues(Set<CriteriaAttributeValue> criteriaAttributeValues) {
		this.criteriaAttributeValues = criteriaAttributeValues;
	}
	
}
