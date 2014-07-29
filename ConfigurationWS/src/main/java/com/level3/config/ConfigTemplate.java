package com.level3.config;

public class ConfigTemplate {

	private String rawTempl;

	public String getRawTemplate() {
		return rawTempl;
	}

	public void setRawTemplate(String rawTempl) {
		this.rawTempl = rawTempl;
	}
	
	@Override
	public String toString(){
		return rawTempl;		
	}
	
	
}
