package com.level3.config;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.level3.dataobject.ConfigurationDO;
import com.level3.dataobject.CriteriaDO;

@XmlRootElement
public class ConfigurationRequest implements Serializable {

	private static final long serialVersionUID = -2838963171684995574L;

	@XmlElement
	private CriteriaDO crt;
	
	@XmlElement
	private ConfigurationDO confDataObject;//dataobj rename
		
	public CriteriaDO getCriteria() {
		return crt;
	}
	
	public void setCriteria(CriteriaDO crt) {
		this.crt = crt;
	}
	
	public ConfigurationDO getConfigurationDO() {
		return confDataObject;
	}
	
	public void setConfigurationDO(ConfigurationDO confDataObject) {
		this.confDataObject = confDataObject;
	}

}
