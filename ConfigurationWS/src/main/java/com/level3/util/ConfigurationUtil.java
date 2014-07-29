package com.level3.util;

import org.modelmapper.ModelMapper;

import com.level3.config.ConfigurationResponse;
import com.level3.dataobject.CriteriaDO;
import com.level3.entity.Criteria;

public class ConfigurationUtil {

	/**
	 * This method takes the dataObject and Convert to Entity or vice-versa
	 * @param criteriaDO
	 * @param crt
	 * @param mapDOToEntity
	 * @return
	 */
	public static Object map(CriteriaDO criteriaDO, Criteria crt, boolean mapDOToEntity) {
		//* Maps {@code source} to an instance of {@code destinationType}.
		if(mapDOToEntity){
			crt = new ModelMapper().map(criteriaDO, Criteria.class);
			return crt;
		}else{
			criteriaDO = new ModelMapper().map(crt, CriteriaDO.class);
			return criteriaDO;
		}		
	}
	

	/**
	 * This method builds response for your REST services 
	 * @param resultMsg
	 * @param populatedTemplate
	 * @param crt
	 * @return
	 */
	public static ConfigurationResponse buildResponse(String resultMsg, String populatedTemplate, CriteriaDO crt) {
		/* set the response */
		ConfigurationResponse cresp = new ConfigurationResponse();
		cresp.setResult(resultMsg);
		cresp.setCriteria(crt);
		cresp.setPopulatedTemplate(populatedTemplate);
		cresp.setConfigTemplate(null);		
		return cresp;	
	}
	
}
