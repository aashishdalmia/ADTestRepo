package com.level3.template;

import com.level3.dataobject.ConfigurationDO;

public interface IVelocityTemplateEngine {
	public String populateTemplate(String criteriaTemplate, ConfigurationDO configureDataObject);
}
