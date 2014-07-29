package com.level3.entity;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.hibernate.Session;
import org.jboss.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.level3.util.HibernateUtil;

public class CriteriaAttributeNameMappingTest {
    
	//public static final String TEST_HIBERNATE_CFG_XML = "hibernate.cfg.xml";
	private static Logger logger = Logger.getLogger(CriteriaAttributeNameMappingTest.class);
	private static CriteriaAttribute ca;	
	private static CriteriaAttributeName can;
	private static CriteriaAttributeValue cav;	
	private static Session session;
	private static Long crttIdRet;

	//	@Inject
//	protected MyHibernateUtil hibernateUtil;
	
	@BeforeClass
	public static void setUp(){
		ca = new CriteriaAttribute();
		can = new CriteriaAttributeName();
		session = HibernateUtil.getSessionFactory().openSession();
		can.setName("crit attr name123");
	}

	@Test
	public void testCriteriaAttributeNameMappings(){
        try{
            //Begin transaction
            session.beginTransaction();
           
			//save criteriaAttributeName object now
			crttIdRet = (Long)session.save(can);
			System.out.println("= crttIdReturned : " + crttIdRet);

			//check if Criteria is returned back immediately after the insert
			org.hibernate.Criteria caLst2  =  session.createCriteria(CriteriaAttributeName.class);
            List<CriteriaAttributeName> itr =  caLst2.list();
        	System.out.println("Test Case success, CriteriaAttributeName - Hibernate Mappings are working fine");            
        }catch(Exception ex){
        	ex.printStackTrace();
        	fail(" CriteriaAttributeNameTest test method failed ");
        }finally{
        	session.getTransaction().commit();
        }        
    }
	
		
	@Test
	public void deleteCriteriaAttributeName() {
		System.out.println("---deleting CriteriaAttributeName = " + CriteriaAttributeNameMappingTest.crttIdRet);
		session.beginTransaction();
		CriteriaAttributeName crt = (CriteriaAttributeName)session.get(CriteriaAttributeName.class, crttIdRet); 
		session.delete(crt);		
        session.getTransaction().commit();
        assertNotNull("criteria_Id is not null", crt.getId());
	}
	
	
	@AfterClass
	public static void tearDown(){
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
//				System.out.println("Resource file not found in file system");
//				mResUrl = null;
//			}
//			
//			//check if resource file is a resource in classpath
//			if (mResUrl == null) {
//				try {
//					mResUrl = ClassLoader.getSystemResource(aResource);
//					mResUrl.getContent();
//				} catch(Throwable aEx) {
//					System.out.println("Resource file not found in classpath");
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
//					System.out.println("Resource file not accessible as an URL");
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

