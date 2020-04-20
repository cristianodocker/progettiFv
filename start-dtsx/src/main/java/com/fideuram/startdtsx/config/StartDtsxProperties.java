package com.fideuram.startdtsx.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class StartDtsxProperties {

	/** mail.properties **/
	@Value("${mail.enabled}")
	private boolean enabled;
	@Value("${mail.from}")
	private String from;
	@Value("${mail.to}")
	private String to;
	@Value("${mail.cc}")
	private String cc;

	/** ftp.properties **/
	@Value("${remote.folderInputAttivi}")
	private String remoteFolderInputAttivi;
	@Value("${remote.folderInputPassivi}")
	private String remoteFolderInputPassivi;
	@Value("${file.user}")
	private String fileUser;
	@Value("${file.psw}")
	private String filePassword;

}
