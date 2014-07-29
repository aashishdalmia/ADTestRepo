package com.level3.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.level3.config.ConfigurationRequest;
import com.level3.config.ConfigurationResponse;
import com.level3.dataobject.ConfigurationDO;
import com.level3.dataobject.CriteriaAttributeDO;
import com.level3.dataobject.CriteriaAttributeNameDO;
import com.level3.dataobject.CriteriaAttributeValueDO;
import com.level3.dataobject.CriteriaAttributeValueMatchTypeDO;
import com.level3.dataobject.CriteriaAttributeValueMatchValueDO;
import com.level3.dataobject.CriteriaDO;
import com.level3.dataobject.TemplateTokens;


/**
 * @author dalmia.aashish
 *
 */
public class ConfigurationWSTest {

	static final String ROOT_URL = "http://localhost:8080/ConfigurationWS/rest/get/deviceconfiguration";
	private static ConfigurationRequest configRqst = null;
	private static Logger logger = Logger.getLogger(ConfigurationWSTest.class);
	private static CriteriaDO c;
	private static CriteriaAttributeDO ca;	
	private static CriteriaAttributeNameDO can;
	private static CriteriaAttributeValueDO cav;
	private static IConfigurationWS confWSImpl;
	private Response response;
	
	//TODO - getServer hostname dynamically otherwise this test will fail in Dev, QA etc
	//TODO - Add few more asserts in your test method
//	@Inject
//	private IConfigurationWS cdcGenService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//ConfigurationRequest
		configRqst = new ConfigurationRequest();		
		c = new CriteriaDO();
		ca = new CriteriaAttributeDO();
		can = new CriteriaAttributeNameDO();
		cav = new CriteriaAttributeValueDO();		
		Set<CriteriaAttributeDO> caLst = new HashSet<CriteriaAttributeDO>();		
			//set CriteriaAttributeValueDO in the cav type
		CriteriaAttributeValueMatchTypeDO cavmt = new CriteriaAttributeValueMatchTypeDO();
		cavmt.setType("this is cavmt123");
		CriteriaAttributeValueMatchValueDO cavmv = new CriteriaAttributeValueMatchValueDO();
		cavmv.setValue("this is cavmv123");	
		cav.setCriteriaAttributeValueMatchType(cavmt);
		cav.setCriteriaAttributeValueMatchValue(cavmv);
		can.setName("crit attr name123");
		ca.getCriteriaAttributeValues().add(cav);
		ca.setCriteriaAttributeName(can);
		caLst.add(ca);
		c.setCriteriaAttributes(caLst);
		configRqst.setCriteria(c);
		
		//set data object
//		Map<String, String> dataObjectMap = new HashMap<String, String>();
//		dataObjectMap.put("username", "dude123");
//		dataObjectMap.put("id", "myId");
//		ConfigurationDO confDO = new ConfigurationDO();
//		confDO.setTemplateTokensHashMap(dataObjectMap);
		
		Set<TemplateTokens> dataObjectMap = new HashSet<TemplateTokens>();		
		TemplateTokens tt = new TemplateTokens();
		tt.setKey("username");
		tt.setValue("dude123");
		dataObjectMap.add(tt);		
		tt.setKey("id");
		tt.setValue("bjhbjbjk");
		dataObjectMap.add(tt);
		
		ConfigurationDO confDO = new ConfigurationDO();
		confDO.setTemplateTokens(dataObjectMap);
		
		configRqst.setConfigurationDO(confDO);
		
		//for testing internal rest service
		confWSImpl = new ConfigurationWSImpl();
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		configRqst = null;
		confWSImpl=null;
	}

//	@Test
//	public void testInternalPathRestService() {
//		try {
//			Response resp = confWSImpl.getConfiguration(cr);
//			ConfigurationResponse respnCR = (ConfigurationResponse)resp.getEntity();
//			logger.info("-- after calling getConfiguration --");
//			assertFalse(respnCR.getCriteria().getCriteriaAttributes().size() == 0);
//			assertNotNull(respnCR.getResult());
//			assertNotNull(respnCR.getPopulatedTemplate());
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail(e.toString());
//		}finally{			
//		}
//	}
	
//	@Test
//	public void testExternalPathRestService() {
//		try {
//			ResteasyClient client = new ResteasyClientBuilder().build();
//			ResteasyWebTarget target = client.target(ConfigurationWSTest.ROOT_URL);
//			response = target.request().post(Entity.entity(cr, "application/json"));
//			if (response.getStatus() != 200) {
//				fail("Test Failed with response.getStatus = " + response.getStatus());
//				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());				
//			}
//			logger.info("Server response : \n");
//			logger.info(response.readEntity(String.class));
//			assertEquals("Must be 200", 200, response.getStatus() );
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail(e.toString());
//		}finally{
//			response.close();
//		}
//	}
	
	@Test
	public void testInvokeRealService() throws Exception {
		ClientRequest mReq = new ClientRequest(ConfigurationWSTest.ROOT_URL).body(MediaType.APPLICATION_XML, configRqst)
								.accept(MediaType.APPLICATION_JSON);
		ClientResponse<Response> mResp = mReq.get(Response.class);
		ConfigurationResponse confgResponse = mResp.getEntity(ConfigurationResponse.class);
		System.out.println("--- confgResponse, populatedResponse -- " + confgResponse.getPopulatedTemplate());
	}
	
	public void testMap(){
		
	}

}
