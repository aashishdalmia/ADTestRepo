package com.level3.service;

import java.util.Iterator;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.level3.config.ConfigurationRequest;
import com.level3.config.ConfigurationResponse;
import com.level3.dao.ConfigurationRequestDAOImpl;
import com.level3.dao.IConfigurationRequestDAO;
import com.level3.dataobject.ConfigurationDO;
import com.level3.dataobject.CriteriaDO;
import com.level3.entity.Criteria;
import com.level3.entity.CriteriaAttribute;
import com.level3.entity.CriteriaAttributeValue;
import com.level3.template.IVelocityTemplateEngine;
import com.level3.template.VelocityTemplateEngineImpl;
import com.level3.util.ConfigurationUtil;

public class ConfigurationWSImpl implements IConfigurationWS {

	private static Logger logger = Logger.getLogger(ConfigurationWSImpl.class);

//	@Inject
//	private ConfigurationRequestDAOImpl crdaoImpl;
	
//	@Inject
//	private VelocityTemplateEngineImpl velTempEng;
	
	private String critAttrValueMatchType;
	private String critAttrValueMatchValue;
	private ConfigurationResponse cresp;
	private Criteria crt;

	private final String RESULT_MSG_FAILURE =  "Template Population Error";
	private final String RESULT_MSG_VALIDATION_ERROR =  "Validation Error, please check inputs";
	private final String RESULT_MSG_SUCESS =  "Template Populated Successfully";

	@Override
	public Response getConfiguration(ConfigurationRequest confRqst) {
		
		logger.info("In RestEasy Post call");	

		try{
			//TODO-validate input message elements
			if(isInputValidated(confRqst)){	
				
				/* map input DO's to Entity Type */
				crt = (Criteria) ConfigurationUtil.map(confRqst.getCriteria(), crt, true);
				
				/* get Match type and match value *///TODO - make it better
				Iterator<CriteriaAttribute> itr = crt.getCriteriaAttributes().iterator();
				while(itr.hasNext()){
					CriteriaAttribute ca = (CriteriaAttribute) itr.next();
					Iterator<CriteriaAttributeValue> itr2 = ca.getCriteriaAttributeValues().iterator();
					while(itr2.hasNext()){
						CriteriaAttributeValue cav = (CriteriaAttributeValue) itr2.next();
						critAttrValueMatchType = cav.getCriteriaAttributeValueMatchType().getType();
						logger.info("--- Input cavmt = " + critAttrValueMatchType);
						critAttrValueMatchValue = cav.getCriteriaAttributeValueMatchValue().getValue();
						logger.info("--- Input cavmv = " + critAttrValueMatchValue);
					}
				}
				
				/* find criteria_Id */		
				//int criteriaId = this.crdaoImpl.findCriteriaId(critAttrValueMatchType, critAttrValueMatchValue);
				IConfigurationRequestDAO crdaoImpl = new ConfigurationRequestDAOImpl();
				Long criteriaId = crdaoImpl.findCriteriaId(critAttrValueMatchType, critAttrValueMatchValue);
				logger.info("--- criteriaId received from backend -- " + criteriaId);
				
				if(criteriaId != null){
					/* get template for that criteria id */				        
					String criteriaTemplate = crdaoImpl.getTemplate(criteriaId);
					logger.info("---tempReceivedFromDB --" + criteriaTemplate);

					/* replace template values with input DataObject variables */
					IVelocityTemplateEngine velTempEngImpl = new VelocityTemplateEngineImpl();
					//this.velTempEngImpl.populateTemplate((ConfigurationDO) confRqst.getConfigurationDO(), criteriaTemplate);
					String populatedTemplate = velTempEngImpl.populateTemplate(criteriaTemplate, (ConfigurationDO) confRqst.getConfigurationDO());
					logger.info("--- Populated Template --- " + populatedTemplate);
					
					/* map Criteria back to DO for response */		
					confRqst.setCriteria((CriteriaDO) ConfigurationUtil.map(confRqst.getCriteria(), crt, false));
					
					/* set the result Message and build response */
					if(!populatedTemplate.isEmpty()){
						cresp = ConfigurationUtil.buildResponse(RESULT_MSG_SUCESS, populatedTemplate, confRqst.getCriteria());						
				        return Response.status(200).entity(cresp).build();	
					}else{
						cresp = ConfigurationUtil.buildResponse(RESULT_MSG_FAILURE, populatedTemplate, confRqst.getCriteria());						
				        return Response.status(200).entity(cresp).build();
					}								
				}else{
					/* build the response with failure message */						
			        return Response.status(200).entity(ConfigurationUtil.buildResponse(RESULT_MSG_VALIDATION_ERROR, null, confRqst.getCriteria())).build();			
				}
			}
			else{
				/* build the response with Validation failure message */						
		        return Response.status(200).entity(ConfigurationUtil.buildResponse(RESULT_MSG_FAILURE, null, confRqst.getCriteria())).build();			
			}
		}catch(Exception ex){
			/* build the response with failure msg*/
			StringBuffer errorSB = new StringBuffer(RESULT_MSG_FAILURE);
			errorSB.append(" With Error Message = ");
			errorSB.append(ex.getMessage().substring(0, 30));
			cresp = ConfigurationUtil.buildResponse((RESULT_MSG_FAILURE + ex.getMessage()), null, confRqst.getCriteria());						
	        return Response.status(200).entity(cresp).build();
		}finally{			
		}
	}


	/**
	 * This method validates the input received in the REST call
	 * @param confRqst
	 * @return
	 */
	public static boolean isInputValidated(ConfigurationRequest confRqst) {
//		Iterator<CriteriaAttribute> caItr = confRqst.getCriteria().getCriteriaAttributes().iterator();
//		while(caItr.hasNext()){
//			logger.info("Processing Input Criteria::: " + caItr.next().getCriteriaAttributeValues()..getName());
//		}		
		return true;
	}
		 
}
