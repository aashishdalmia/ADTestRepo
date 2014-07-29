package com.level3.dataobject;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TemplateTokens implements Serializable {

	private static final long serialVersionUID = 7611148378939457286L;

	@XmlElement
	private String key;
	
	@XmlElement
	private String value;
	
	
	public String getKey(){
		return key;		
	}
	
	public void setKey(String key){
		this.key = key;
	}
	
	public String getValue(){
		return value;		
	}
	
	public void setValue(String value){
		this.value = value;
	}
}
