package com.level3.config;

import com.level3.dataobject.CriteriaDO;

public class ConfigurationResponse {

	private CriteriaDO crt;
	private ConfigTemplate confTemplate;
	private String populatedTemplate;
	private String result;
		
	
	public CriteriaDO getCriteria() {
		return crt;
	}
	
	public void setCriteria(CriteriaDO crt) {
		this.crt = crt;
	}
	
	public ConfigTemplate getConfigTemplate() {
		return confTemplate;
	}
	
	public void setConfigTemplate(ConfigTemplate confTemplate) {
		this.confTemplate = confTemplate;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String getPopulatedTemplate() {
		return populatedTemplate;
	}

	public void setPopulatedTemplate(String populatedTemplate) {
		this.populatedTemplate = populatedTemplate;
	}
	
}
