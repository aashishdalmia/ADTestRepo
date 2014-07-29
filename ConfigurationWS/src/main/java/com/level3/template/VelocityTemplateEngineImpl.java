package com.level3.template;

import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;



import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.runtime.resource.util.StringResourceRepository;



import com.level3.dataobject.ConfigurationDO;
import com.level3.dataobject.TemplateTokens;


public class VelocityTemplateEngineImpl implements IVelocityTemplateEngine {

	private static Logger logger = Logger.getLogger(VelocityTemplateEngineImpl.class);

	public VelocityTemplateEngineImpl() {
	}
		
	@Override
	public String populateTemplate(String criteriaTemplate, ConfigurationDO confDO) {
		
		 /* first, get and initialize an engine */
    	VelocityEngine ve = null;
        ve = getVelocityEngine();
        ve.init();
		
		/* create context */
        VelocityContext context = new VelocityContext();
        
        /* get variables from data object map */       		
//		for(Map.Entry<String, String> entry : confDO.getTemplateTokensHashMap().entrySet()){
        
        for (Iterator<TemplateTokens> i = confDO.getTemplateTokens().iterator(); i.hasNext();) {
        	TemplateTokens templTkns = (TemplateTokens) i.next();
            logger.info("Key = " + templTkns.getKey() + " & value = " + templTkns.getValue());
	        context.put(templTkns.getKey(), templTkns.getValue());        
        }
        
		
		/* load template */
//		Template mTemplate = this.loadTemplate(ve, context, criteriaTemplate);			
		logger.debug("-- input TemplateString -- " + criteriaTemplate);
		String mTemplate = this.loadTemplate(ve, context, criteriaTemplate);	
		logger.debug("--mTemplate --" + mTemplate);
		return mTemplate;
	}

	
//	private Template loadTemplate(VelocityEngine ve, VelocityContext context, String criteriaTemplate) {
	private String loadTemplate(VelocityEngine ve, VelocityContext context, String criteriaTemplate) {
		
		StringResourceRepository repo = StringResourceLoader.getRepository();
        String myTempTemplateName = "temp.vm";
        String myTemplate = criteriaTemplate; //"Hi, ${username}... this is a ${param2} template!";
        repo.putStringResource(myTempTemplateName, myTemplate);
        
        /*  get the Template  */
        Template t = ve.getTemplate( myTempTemplateName );
        
        /*  now render the template into a Writer  */
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        
        /* use the output in your response */  
//		return t;
        return writer.toString();
	}


	
	public VelocityEngine getVelocityEngine()
	{
	    /* Initializes the velocity engine with properties. We should specify
	       the resource loader as string and the class for
	       string.resource.loader in properties at minimum */
	    Properties p = new Properties();	 
	    p.setProperty("resource.loader", "string");
	    p.setProperty("string.resource.loader.class", "org.apache.velocity.runtime.resource.loader.StringResourceLoader");
	    VelocityEngine engine = new VelocityEngine();
	    engine.init(p);	 
	    return (engine);
	}
}
