package com.epam.zubar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * class used instead dispatcher-servlet.xml
 * @author Mikalai_Zubar
 *
 */

@Configuration
@ComponentScan({"com.epam.zubar"}) //very important to scan on base package level
public class DispatcherConfig {
	private static final String PREFIX = "/WEB-INF/views/";
	private static final String SUFFIX = ".jsp";
	
	@Bean
	public InternalResourceViewResolver resolver(){
		
		return new InternalResourceViewResolver(PREFIX, SUFFIX);
		
	}
	

}
