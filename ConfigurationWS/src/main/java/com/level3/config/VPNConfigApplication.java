package com.level3.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.level3.service.ConfigurationWSImpl;

public class VPNConfigApplication  extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	 
	public VPNConfigApplication() {
		//singletons.add(new ConfigurationWSImpl());
	}
 
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
