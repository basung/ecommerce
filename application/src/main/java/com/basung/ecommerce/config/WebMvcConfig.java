package com.basung.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-09-28
 * Time: 上午9:20
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers( registry );
    }*/

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	  registry.addResourceHandler("swagger-ui.html")
		    .addResourceLocations("classpath:/META-INF/resources/");

	  registry.addResourceHandler("/webjars/**")
		    .addResourceLocations("classpath:/META-INF/resources/webjars/");

	  registry.addResourceHandler("/static/")
		    .addResourceLocations("classpath:/static/");
    }
}
