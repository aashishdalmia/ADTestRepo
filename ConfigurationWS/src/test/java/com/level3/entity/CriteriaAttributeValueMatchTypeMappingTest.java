package com.level3.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.hibernate.Session;
import org.jboss.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.level3.util.HibernateUtil;

public class CriteriaAttributeValueMatchTypeMappingTest {
    
	//public static final String TEST_HIBERNATE_CFG_XML = "hibernate.cfg.xml";
	private static Logger logger = Logger.getLogger(CriteriaAttributeValueMatchTypeMappingTest.class);
	private static CriteriaAttributeValueMatchType cavmt;	
	private static Session session;
	private static Long crttIdRet;

	//	@Inject
//	protected MyHibernateUtil hibernateUtil;
	
	@BeforeClass
	public static void setUp(){
		session = HibernateUtil.getSessionFactory().openSession();
		//set CriteriaAttributeValueMatchType in the cavmv type
		cavmt = new CriteriaAttributeValueMatchType();
		cavmt.setType("this is cavmt345");	
	}

	@Test
	public void testCriteriaAttributeValueMatchTypeMappings(){
        try{
            //Begin transaction
            session.beginTransaction();
           
			//save criteria attribute object now
			crttIdRet = (Long)session.save(cavmt);
			logger.debug("= crttIdReturned : " + crttIdRet);

			//check if Criteria is returned back immediately after the insert
			org.hibernate.Criteria caLst2  =  session.createCriteria(CriteriaAttributeValueMatchType.class);
        	logger.debug("Test Case success, CriteriaAttributeValueMatchType - Hibernate Mappings are working fine");            
        }catch(Exception ex){
        	ex.printStackTrace();
        	fail(" CriteriaAttributeValue test method failed ");
        }finally{
        	session.getTransaction().commit();
        }        
    }
	
		
	@Test
	public void deleteCriteriaAttributeValueMatchType() {
		logger.debug("---deleting CriteriaAttributeValue = " + CriteriaAttributeValueMatchTypeMappingTest.crttIdRet);
		session.beginTransaction();
		CriteriaAttributeValueMatchType crt = (CriteriaAttributeValueMatchType)session.get(CriteriaAttributeValueMatchType.class, crttIdRet); 
		session.delete(crt);		
        session.getTransaction().commit();
        assertNotNull("CriteriaAttributeValueMatchTypeId is not null", crt.getId());
	}
	
	
	@AfterClass
	public static void tearDown(){
		cavmt = null;
		crttIdRet = null;
        session.close();        
		session = null;
	}
	
//	public URL getResourceUrl(String aResource) {
//		URL mResUrl = null;
//		if (aResource != null) {
//			//check if resource file exists in file system
//			try {
//				File mFile = new File(aResource);
//				if (mFile.exists()) {
//					mResUrl = mFile.toURI().toURL();
//				}
//			} catch(Throwable aEx) {
//				logger.debug("Resource file not found in file system");
//				mResUrl = null;
//			}
//			
//			//check if resource file is a resource in classpath
//			if (mResUrl == null) {
//				try {
//					mResUrl = ClassLoader.getSystemResource(aResource);
//					mResUrl.getContent();
//				} catch(Throwable aEx) {
//					logger.debug("Resource file not found in classpath");
//					mResUrl = null;
//				}	
//			}
//			
//			//check if resource file is a URL
//			if (mResUrl == null) {
//				try {
//					mResUrl = new URL(aResource);
//					mResUrl.getContent();
//				} catch(Throwable aEx) {
//					logger.debug("Resource file not accessible as an URL");
//					mResUrl = null;
//				}	
//			}
//		}
//		return mResUrl;
//	}
//	
//	public URL getHibernateConfigUrl() {
//		return this.getResourceUrl(CriteriaTest.TEST_HIBERNATE_CFG_XML);
//	}
   
}

