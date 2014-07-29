package com.level3.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;

import com.level3.entity.Configuration;
import com.level3.entity.Criteria;
import com.level3.template.VelocityTemplateEngineImpl;
import com.level3.util.HibernateUtil;

public class ConfigurationRequestDAOImpl implements IConfigurationRequestDAO {

	private static Logger logger = Logger.getLogger(ConfigurationRequestDAOImpl.class);

	
	@SuppressWarnings("unchecked")
	@Override
	public Long findCriteriaId(String critAttrValueMatchType, String critAttrValueMatchValue) 
	{
		logger.debug("---- In findCriteriaId ----");
		
		/* open the session, begin transaction */
        getSession().beginTransaction();
        
		List<Criteria> mCriteriaList = null;
		Long criteriaIdReturnedFromDB = null;
		try {
			String hql = "Select c from Criteria AS c"
						+ "	Inner JOIN c.criteriaAttributes AS ca"
						+ "	Inner Join ca.criteriaAttributeValues AS cav"
						+ "	Inner Join cav.cavmt AS cavmt"
						+ "	where cavmt.type=:critAttrValueMatchType ";
			Query mQuery = getSession().createQuery(hql) ;
			mQuery.setParameter("critAttrValueMatchType", critAttrValueMatchType);
			//mQuery.setParameter("critAttrValueMatchValue", critAttrValueMatchValue);//TODO
			//mQuery.setCacheable(false);
			getSession().setCacheMode(CacheMode.IGNORE);
			mCriteriaList = (List<Criteria>)mQuery.list();
			logger.debug("----mCriteriaList  first element is =  " + mCriteriaList.get(0).getId());
			criteriaIdReturnedFromDB = mCriteriaList.get(0).getId();
		}catch(Exception ex){
			logger.debug("---- ex --- " + ex);
		}
		finally{
	        getSession().close();
		}
		return criteriaIdReturnedFromDB;
	}

	@Override
	public String getTemplate(Long criteriaId) 
	{
		/* open the session, begin transaction */        
        getSession().beginTransaction();
        
        /* get ConfId off of criteriaId */
        Long confId = findConfigurationId(criteriaId);
        
        /* get Configuration Object off of confId */
        Configuration conf = (Configuration)getSession().get(Configuration.class, confId);
        getSession().close();
        
        return conf.getTemplate();
	}	
	
	
	public Session getSession(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		return session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long findConfigurationId(Long criteriaId) {
        getSession().beginTransaction();
		List<Configuration> mConfigurationList = null;
		
		/* query to get Configuration Object */
		String hql = " FROM Configuration where criteriaId= :criteriaId";
		Query mQuery = getSession().createQuery(hql) ;
		mQuery.setParameter("criteriaId", criteriaId);
		mQuery.setCacheable(false);
		mConfigurationList = (List<Configuration>)mQuery.list();
		logger.debug("----mConfigurationList =  " + mConfigurationList.get(0).getId());
        getSession().close();
		return mConfigurationList.get(0).getId();
	}

}
