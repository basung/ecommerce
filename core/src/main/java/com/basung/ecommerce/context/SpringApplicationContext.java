package com.basung.ecommerce.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.NoSuchMessageException;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * Date: 2018-10-17-下午8:07
 */

@Named("system_applictionContext")
public class SpringApplicationContext implements GeekApplicationContext, ApplicationContextAware {
    private ApplicationContext applicationContext;

    public SpringApplicationContext() {
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	  this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
	  return this.applicationContext;
    }

    @PostConstruct
    public void init() {
	  ApplicationContextUtils.setApplicationContext(this);
    }

    public <T> T getBean(String name) {
	  return (T) this.applicationContext.getBean(name);
    }

    public <T> T getBean(String name, Class<T> tClass) {
	  return this.applicationContext.getBean(name, tClass);
    }

    public <T> T getBean(Class<T> tClass) {
	  return this.applicationContext.getBean(tClass);
    }

    public boolean containsBean(String name) {
	  return this.applicationContext.containsBean(name);
    }

    public String getMessage(String code, Locale loc, Object... args) {
	  try {
		return this.applicationContext.getMessage(code, args, loc);
	  } catch (NoSuchMessageException var5) {
		return null;
	  }
    }
}
