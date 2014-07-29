package com.level3.template;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.level3.config.ConfigurationRequest;
import com.level3.dataobject.ConfigurationDO;
import com.level3.dataobject.CriteriaAttributeDO;
import com.level3.dataobject.CriteriaAttributeNameDO;
import com.level3.dataobject.CriteriaAttributeValueDO;
import com.level3.dataobject.CriteriaAttributeValueMatchTypeDO;
import com.level3.dataobject.CriteriaAttributeValueMatchValueDO;
import com.level3.dataobject.CriteriaDO;

public class VelocityTemplateEngineTest {

	private static Logger logger = Logger.getLogger(VelocityTemplateEngineTest.class);
	private static ConfigurationRequest confRqst;
	private static CriteriaDO crtDO;
	private static CriteriaAttributeDO caDO;
	private static ConfigurationDO confDataObject;
	private static CriteriaAttributeValueDO cav;	
	private static CriteriaAttributeNameDO can;

	private static String crtTempl;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		confRqst = new ConfigurationRequest();
		
		caDO = new CriteriaAttributeDO();
		//set CriteriaAttributeValue in the cav type
		CriteriaAttributeValueMatchTypeDO cavmt = new CriteriaAttributeValueMatchTypeDO();
		cavmt.setType("this is cavmt000");
		CriteriaAttributeValueMatchValueDO cavmv = new CriteriaAttributeValueMatchValueDO();
		cavmv.setValue("this is cavmv12000");	
		cav = new CriteriaAttributeValueDO();
		cav.setCriteriaAttributeValueMatchType(cavmt);
		cav.setCriteriaAttributeValueMatchValue(cavmv);
		can = new CriteriaAttributeNameDO();
		can.setName("crit attr name120003");
		caDO.getCriteriaAttributeValues().add(cav);
		caDO.setCriteriaAttributeName(can);	
		crtDO = new CriteriaDO();		
        Set<CriteriaAttributeDO> caLst = new HashSet<CriteriaAttributeDO>();		
		caLst.add(caDO);		
		crtDO.setCriteriaAttributes(caLst);
		
		confDataObject = new ConfigurationDO();
		//set data object
//		Map<String, String> dataObjectMap = new HashMap<String, String>();
//		dataObjectMap.put("username", "d00000e123");
//		dataObjectMap.put("id", "myI0000d");				
//		confDataObject.setTemplateTokensHashMap(dataObjectMap);

		confRqst.setConfigurationDO(confDataObject);
		confRqst.setCriteria(crtDO);
		
		crtTempl = " /unit testing velocity template engine- ${username} velocity template code... ${id} and nothing else";
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		confRqst = null;
		crtDO = null;
		caDO = null;
		confDataObject = null;
		cav = null;
		can = null;
	}
	

	@Test
	public void test() {
		try {
			logger.info("--in test method--");
			IVelocityTemplateEngine vimpl = new VelocityTemplateEngineImpl();
			String templateString = vimpl.populateTemplate(crtTempl, confDataObject);
			logger.info("--- templateString --- " + templateString.toString());
			assertNotNull(templateString.toString());
			//assertEquals();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}finally{
		}
	}

	
}
