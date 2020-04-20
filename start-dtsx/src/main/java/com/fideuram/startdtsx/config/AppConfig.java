package com.fideuram.startdtsx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class AppConfig {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		propertySourcesPlaceholderConfigurer.setLocations(
				new FileSystemResource("C:\\Batch\\start-dtsx\\config\\mail.properties"),
				new FileSystemResource("C:\\Batch\\start-dtsx\\config\\file.properties"));
		return propertySourcesPlaceholderConfigurer;
	}
}
