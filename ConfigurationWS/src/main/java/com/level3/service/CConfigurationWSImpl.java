//package com.level3.service;
//
//import java.util.Iterator;
//
//import javax.ws.rs.core.Response;
//
//import com.level3.config.ConfigurationRequest;
//import com.level3.entity.CriteriaAttribute;
//import com.level3.service.IConfigurationWS;
// 
//public class CConfigurationWSImpl implements IConfigurationWS {
//
//	@Override
//	public Response getConfiguration(ConfigurationRequest confRqst) {
//		System.out.println("in here second impl class ");
//		processInput(confRqst);	
//		
//        // DAO code for Database interactions happen here.
//		
//        return Response.status(200).entity("Received Configuration Successfully").build();
//        
//	}
//
//	/**
//	 * 
//	 * @param confRqst
//	 */
//	private void processInput(ConfigurationRequest confRqst) {
//		Iterator<CriteriaAttribute> caItr = confRqst.getCriteria().getCriteriaAttribute().iterator();
//		while(caItr.hasNext()){
//			System.out.println("2 nd Processing Input Criteria: " + caItr.next().getCriteriaAttributeName().getName());
//		}		
//	}
//	 
//}
