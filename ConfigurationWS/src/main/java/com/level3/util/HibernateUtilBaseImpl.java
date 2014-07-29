//package com.level3.util;
// 
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//
//import org.apache.log4j.Logger;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
// 
//public class HibernateUtilBaseImpl implements IHibernateUtilBase {
//
//	private static Logger logger = Logger.getLogger(HibernateUtilBaseImpl.class);
//	
//	private URL hibernateConfigFileUrl;
//	private Configuration config;
//	private ServiceRegistry serviceRegistry;
//	private SessionFactory sessionFactory;
//	
//	public HibernateUtilBaseImpl() {
//	}
////
////	public void initialize(URL aCfgUrl) {
//	@Override
//	public void initialize() {
//		//this.hibernateConfigFileUrl = aCfgUrl;
// 		String mUrlStr = "hibernate.cfg.xml";
//		URL mUrl = null;
//		try {
//			mUrl = new URL("/hibernate.cfg.xml");
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		this.hibernateConfigFileUrl = mUrl;
//		
//		if (hibernateConfigFileUrl != null) {
//			try {
//				if (logger.isInfoEnabled()) {
//					logger.info(String.format("initialize(): Configuring Hibernate with config file: %s...", 
//							hibernateConfigFileUrl));
//				}
//				this.config = new Configuration().configure(hibernateConfigFileUrl);
//			} catch(Throwable aEx) {
//				logger.error(String.format("initialize(): Invalid Hibernate config file URL: %s", 
//						hibernateConfigFileUrl), aEx); 
//			}
//		} 
//		//default configure()
//		if (this.config == null) {
//			logger.info("initialize(): Configuring Hibernate with config file: /hibernate.cfg.xml...");
//			this.config = new Configuration().configure();
//		}
//		
//		ServiceRegistryBuilder mBuilder = 
//				new ServiceRegistryBuilder()
//					.applySettings(this.config.getProperties());
//		this.serviceRegistry = mBuilder.buildServiceRegistry();
//		this.sessionFactory = this.config.buildSessionFactory(this.serviceRegistry);
//	}
//	
//	@Override
//	public SessionFactory getSessionFactory() {
//		return this.sessionFactory;
//	}
//	
//	@Override
//	public Session openSession() {
//		return this.sessionFactory.openSession();
//	}
//	
//	@PostConstruct
//	public void create() {
//	}
//	
//	@PreDestroy
//	public void destroy() {
//		if (this.sessionFactory != null) {
//			this.sessionFactory.close();
//		}
//	}
//}
