package com.wisely;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * 
 * 在spring boot默认配置上 增加 自己额外的配置 继承 WebMvcConfigurerAdapter 即可。
 * 
 * @author Administrator
 *
 */
@Configuration
public class WebMvcConfig  extends WebMvcConfigurerAdapter{
	
	 @Override
	   public void addViewControllers(ViewControllerRegistry registry) {
	       registry.addViewController("/xx").setViewName("/xx");
	   }

}
