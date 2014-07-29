package com.level3.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.level3.config.ConfigurationRequest;

/**
 * @author dalmia.aashish
 *
 */
@Path("/get")
public interface IConfigurationWS {

	@GET
    @Path("deviceconfiguration")
	@Consumes({"application/xml", "application/json" })
	@Produces({"application/xml", "application/json" })
    public Response getConfiguration(ConfigurationRequest confRqst);
	
}
