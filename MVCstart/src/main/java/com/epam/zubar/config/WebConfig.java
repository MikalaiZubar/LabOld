package com.epam.zubar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.epam.zubar.web")
public class WebConfig extends WebMvcConfigurerAdapter{
	
	private static final String PREFIX = "/WEB-INF/views/";
	private static final String SUFFIX = ".jsp";

	
	//Configure a jsp view resolver
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		//resolver.setViewClass(JstlView.class);
		resolver.setPrefix(PREFIX);
		resolver.setSuffix(SUFFIX);
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	
	//Configure static content
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
