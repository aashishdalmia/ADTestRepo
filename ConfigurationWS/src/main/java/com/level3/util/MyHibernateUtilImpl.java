//package com.level3.util;
//
//import java.net.URL;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import javax.inject.Named;
//
//import org.apache.log4j.Logger;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
//
//
//public class MyHibernateUtilImpl implements MyHibernateUtil {
//
//	private static Logger logger = Logger.getLogger(MyHibernateUtilImpl.class);
//	
//	private URL hibernateConfigFileUrl;
//	private Configuration config;
//	private ServiceRegistry serviceRegistry;
//	private SessionFactory sessionFactory;
//	
//	public MyHibernateUtilImpl() {
//	}
//	
//	@Override
//	public void initialize(URL aCfgUrl) {
//		this.hibernateConfigFileUrl = aCfgUrl;
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
