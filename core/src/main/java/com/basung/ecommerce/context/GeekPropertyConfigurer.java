package com.basung.ecommerce.context;

import com.basung.ecommerce.GeekSystem;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Date: 2018-10-17-下午8:06
 */
public class GeekPropertyConfigurer extends PropertyPlaceholderConfigurer {
    public GeekPropertyConfigurer() {
    }

    protected Properties mergeProperties() throws IOException {
	  Properties props = super.mergeProperties();
	  String propFiles = GeekSystem.getProperty("jade.props");
	  if (StringUtils.isNotBlank(propFiles)) {
		String[] files = StringUtils.split(propFiles, ',');
		String[] var4 = files;
		int var5 = files.length;

		for(int var6 = 0; var6 < var5; ++var6) {
		    String filepath = var4[var6];

		    try {
			  Resource resource = null;
			  File file = new File(filepath);
			  if (file.exists()) {
				resource = new FileSystemResource(file);
			  } else {
				resource = new ClassPathResource(filepath);
			  }

			  EncodedResource encodedResource = new EncodedResource((Resource)resource, "UTF-8");
			  CollectionUtils.mergePropertiesIntoMap(PropertiesLoaderUtils.loadProperties(encodedResource), props);
		    } catch (Throwable var11) {
			  GeekSystem.getLog().warn("Can't parse config file " + filepath, var11);
		    }
		}
	  }

	  return props;
    }

    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
	  super.processProperties(beanFactoryToProcess, props);
	  Enumeration propertyNames = props.propertyNames();

	  while(propertyNames.hasMoreElements()) {
		String propertyName = (String)propertyNames.nextElement();
		String propertyValue = props.getProperty(propertyName);
		GeekSystem.getLog().debug("Set property " + propertyName + "to " + propertyValue);
		GeekSystem.setProperty(propertyName, propertyValue);
	  }

    }
}
