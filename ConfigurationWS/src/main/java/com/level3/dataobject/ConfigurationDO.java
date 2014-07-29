package com.level3.dataobject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
public class ConfigurationDO implements Serializable {

	private static final long serialVersionUID = 8147260966915692148L;
	
	@XmlElement
	private Set<TemplateTokens> templTokens = new HashSet<TemplateTokens>();

	//private Map<String, String> templateTokensHashMap = new HashMap<String, String>();

	
	public ConfigurationDO(){
	}
	
	public Set<TemplateTokens> getTemplateTokens() {
		return templTokens;
	}
	
	public void setTemplateTokens(Set<TemplateTokens> templTokens) {
		this.templTokens = templTokens;
	}
	
//	public Map<String, String> getTemplateTokensHashMap() {
//		return templateTokensHashMap;
//	}
//
//	public void setTemplateTokensHashMap(Map<String, String> templateTokensHashMap) {
//		this.templateTokensHashMap = templateTokensHashMap;
//	}
	
}
