//package com.level3.template;
//
//
//import java.io.StringWriter;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Map;
//import java.util.HashMap;
//import java.util.Properties;
//
//import org.apache.velocity.Template;
//import org.apache.velocity.VelocityContext;
//import org.apache.velocity.app.VelocityEngine;
//import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
//import org.apache.velocity.runtime.resource.util.StringResourceRepository;
//public class Temp {
//    public static void main( String[] args )
//        throws Exception
//    {
//        /*  first, get and initialize an engine  */
//    	VelocityEngine ve = null;
//        ve = getVelocityEngine(ve);
//        ve.init();
//        /*  organize our data  */
//        /*  add that list to a VelocityContext  */
//        VelocityContext context = new VelocityContext();
//        context.put("username", "dududududududeeee");
//        
//        StringResourceRepository repo = StringResourceLoader.getRepository();
//
//        String myTemplateName = "customer.vm";
//        String myTemplate = "Hi, ${username}... this is some template!";
//        repo.putStringResource(myTemplateName, myTemplate);
//        
//        /*  get the Template  */
//        Template t = ve.getTemplate( myTemplateName );
//        //template = engine.getTemplate("myTemplateName");
//        /*  now render the template into a Writer  */
//        StringWriter writer = new StringWriter();
//        t.merge( context, writer );
//        /* use the output in your email body */
//    
//        System.out.println(writer.toString() );
//    }
//    
//    private static VelocityEngine getVelocityEngine(VelocityEngine engine)
//    		throws Exception
//    		{
//    		    // Initializes the velocity engine with properties. We should specify
//    		    // the resource loader as string and the class for
//    		    // string.resource.loader in properties
//    		    Properties p = new Properties();
//    		 
//    		    p.setProperty("resource.loader", "string");
//    		    p.setProperty("string.resource.loader.class", "org.apache.velocity.runtime.resource.loader.StringResourceLoader");
//    		    engine = new VelocityEngine();
//    		    engine.init(p);
//    		 
//    		    return (engine);
//    		}
//}