package com.level3.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.level3.util.HibernateUtil;

public class CriteriaMappingTest {
    
	//public static final String TEST_HIBERNATE_CFG_XML = "hibernate.cfg.xml";
	private static Logger logger = Logger.getLogger(CriteriaMappingTest.class);
	private static Criteria c;
	private static CriteriaAttribute ca;	
	private static CriteriaAttributeName can;
	private static CriteriaAttributeValue cav;	
	private static Session session;
	private static Long crttIdRet;
	private static Long confId;
//	@Inject
//	protected MyHibernateUtil hibernateUtil;
	
	@BeforeClass
	public static void setUp(){
		c = new Criteria();
		ca = new CriteriaAttribute();
		can = new CriteriaAttributeName();
		cav = new CriteriaAttributeValue();
		session = HibernateUtil.getSessionFactory().openSession();
				 
        Set<CriteriaAttribute> caLst = new HashSet<CriteriaAttribute>();		
		//set CriteriaAttributeValue in the cav type
		CriteriaAttributeValueMatchType cavmt = new CriteriaAttributeValueMatchType();
		cavmt.setType("this is cavmt123");
		CriteriaAttributeValueMatchValue cavmv = new CriteriaAttributeValueMatchValue();
		cavmv.setValue("this is cavmv123");	
		cav.setCriteriaAttributeValueMatchType(cavmt);
		cav.setCriteriaAttributeValueMatchValue(cavmv);
		can.setName("crit attr name123");

		ca.getCriteriaAttributeValues().add(cav);
		ca.setCriteriaAttributeName(can);

		caLst.add(ca);
		c.setCriteriaAttributes(caLst);

	}

	@Test
	public void testCriteriaMappings(){
        try{
            //Begin transaction
            session.beginTransaction();
            logger.debug("Saving criteria object");
			//save criteria object now
			crttIdRet = (Long)session.save(c);
			logger.debug("= crttIdReturned : " + crttIdRet);

			//check if Criteria is returned back immediately after the insert
			//org.hibernate.Criteria caLst2  =  session.createCriteria(Criteria.class);
            //List<Criteria> itr =  caLst2.list();
            
            //for(Criteria c: itr){
            	logger.debug("--- " + c.getId());
            	   //insert into Configuration
                Configuration conf = new Configuration();
                conf.setCriteriaId(c.getId());
                conf.setTemplate("/first conf test temnplate string.....works ${username} and this is my id - ${id} or ... whatever");
                confId = (Long)session.save(conf);
                logger.debug("---- confId --- " + confId);
            	assertNotNull(crttIdRet);
            	logger.debug("Test Case success, Hibernate Mappings are working fine");
            //}    
        }catch(Exception ex){
        	ex.printStackTrace();
        	fail(" CriteriaTest test method failed ");
        }finally{
        	session.getTransaction().commit();
        }        
    }
	
		
	@Test
	public void deleteCriteria() {
		logger.debug("---deleting Criteria = " + CriteriaMappingTest.crttIdRet);
		session.beginTransaction();
		Criteria crt = (Criteria)session.get(Criteria.class, crttIdRet); 
		session.delete(crt);		
        session.getTransaction().commit();
        assertNotNull("criteria_Id is not null", crt.getId());
	}
	
	
	@Test
	public void deleteConfiguration(){
		logger.debug("---deleting Configuration = " + CriteriaMappingTest.confId);
		session.beginTransaction();
		Configuration config = (Configuration)session.get(Configuration.class, confId); 
		session.delete(config);		
        session.getTransaction().commit();
        assertNotNull("confId is not null", config.getId());
	}
	

	@AfterClass
	public static void tearDown(){
		c = null;
		ca = null;
		can = null;
		cav = null;
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

