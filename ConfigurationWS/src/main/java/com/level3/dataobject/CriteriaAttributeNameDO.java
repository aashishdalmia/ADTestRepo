package com.level3.dataobject;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CriteriaAttributeNameDO implements Serializable {
	
	private static final long serialVersionUID = 6412583991136661687L;

	@XmlAttribute
	private Long id;
	
	@XmlElement
	private String name;
	
	public CriteriaAttributeNameDO(){		
	}
	
	public CriteriaAttributeNameDO(CriteriaAttributeDO criteriaAttribute, String name){
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