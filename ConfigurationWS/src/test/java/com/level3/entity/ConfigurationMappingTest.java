package com.level3.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.hibernate.Session;
import org.jboss.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.level3.util.HibernateUtil;

public class ConfigurationMappingTest {
    
	//public static final String TEST_HIBERNATE_CFG_XML = "hibernate.cfg.xml";
	private static Logger logger = Logger.getLogger(ConfigurationMappingTest.class);
	private static Configuration conf;
	private static Session session;
	private static Long confId;
	
//	@Inject
//	protected MyHibernateUtil hibernateUtil;
	
	@BeforeClass
	public static void setUp(){
		conf = new Configuration();
		session = HibernateUtil.getSessionFactory().openSession();		
	}

	@Test
	public void testConfigurationMappings(){
        try{
            //Begin transaction
            session.beginTransaction();
           

			//check if Configuration is returned back immediately after the insert
			org.hibernate.Criteria caLst2  =  session.createCriteria(Configuration.class);
            List<Configuration> itr =  caLst2.list();
            
            //for(Configuration c: itr){
            	logger.debug("--- " + conf.getId());
            	   //insert into Configuration
                Configuration conf = new Configuration();
                conf.setCriteriaId(21234564489l);
                conf.setTemplate("/ conf test temnplate string.....works ${username} and this is my id - ${id} or ... whatever");
                confId = (Long)session.save(conf);
                logger.debug("---- confId --- " + confId);
            	assertNotNull(confId);
            	logger.debug("Test Case success, Hibernate Mappings are working fine");
            //}    
        }catch(Exception ex){
        	ex.printStackTrace();
        	fail(" ConfigurationTest test method failed ");
        }finally{
        	session.getTransaction().commit();
        }        
    }
	
	
	@Test
	public void deleteConfiguration(){
		logger.debug("---deleting Configuration = " + ConfigurationMappingTest.confId);
		session.beginTransaction();
		Configuration config = (Configuration)session.get(Configuration.class, confId); 
		session.delete(config);		
        session.getTransaction().commit();
        assertNotNull("confId is not null", config.getId());
	}
	

	@AfterClass
	public static void tearDown(){
		conf = null;
		confId = null;
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
//		return this.getResourceUrl(ConfigurationTest.TEST_HIBERNATE_CFG_XML);
//	}
   
}

