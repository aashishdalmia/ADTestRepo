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
import javax.persistence.Table;


@Entity
@Table (name = "CRITERIA")
public class Criteria implements Serializable {
	
	private static final long serialVersionUID = 5742005478008525234L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name = "CRITERIA_CRITERIAATTRIBUTES", joinColumns = {@JoinColumn(name = "CRITERIA_ID", referencedColumnName = "ID")},
    													inverseJoinColumns = {@JoinColumn(name = "CRITERIA_ATTRIBUTE_ID", referencedColumnName = "ID")})
	private Set<CriteriaAttribute> criteriaAttributes = new HashSet<CriteriaAttribute>();

	
	public Criteria(){		
	}
	
	public Criteria(Set<CriteriaAttribute> criteriaAttributes){
		this.criteriaAttributes = criteriaAttributes;
	}
	
	public Long getId() {
		return this.id;
	} 
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Set<CriteriaAttribute> getCriteriaAttributes() {
		return this.criteriaAttributes;
	}
	
	public void setCriteriaAttributes(Set<CriteriaAttribute> criteriaAttributes){	
		this.criteriaAttributes = criteriaAttributes;
	}
	
}
