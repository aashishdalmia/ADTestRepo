package com.level3.dao;

import com.level3.config.ConfigurationRequest;
import com.level3.config.ConfigurationResponse;
import com.level3.entity.Criteria;


public interface IConfigurationRequestDAO {
	public Long findCriteriaId(String critAttrValueMatchType, String critAttrValueMatchValue);
	public String getTemplate(Long criteriaId);
	public Long findConfigurationId(Long criteriaId);
}
