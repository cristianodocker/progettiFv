package com.fideuram.startdtsx.utils;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:db.properties" })
public class MgAlfaDBConfiguration {
	@Bean(name = "mgalfaDatasource")
	@Primary
	@ConfigurationProperties(prefix = "spring.mgalfa-datasource")
	public DataSource mgalfaDatasource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "mgalfaEntityManager")
	public LocalContainerEntityManagerFactoryBean pucEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(mgalfaDatasource()).persistenceUnit("mgalfaPU")
				.packages("com.fideuram.startdtsx.model").build();
	}
}
