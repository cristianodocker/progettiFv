package com.fideuram.startdtsx;

import java.net.MalformedURLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.fideuram.startdtsx.business.StartDtsxBusiness;

import jcifs.smb.SmbException;

@SpringBootApplication
@ComponentScan(basePackages = "com.fideuram.startdtsx")
public class StartDtsxApplication {

	public static void main(String[] args) throws MalformedURLException, SmbException {

		ApplicationContext applicationContext = SpringApplication.run(StartDtsxApplication.class, args);
		StartDtsxBusiness business = applicationContext.getBean(StartDtsxBusiness.class);
		business.process();

	}

}
