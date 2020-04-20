package com.fideuram.startdtsx.component;

import java.net.MalformedURLException;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.fideuram.startdtsx.config.AppConfig;
import com.fideuram.startdtsx.config.StartDtsxProperties;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class FileUtilsImpl implements FileUtils {
	@Autowired
	@Qualifier("mgalfaEntityManager")
	private EntityManager emalfa;

	boolean fileExists;

	@SuppressWarnings("resource")
	public boolean isFileExists() throws MalformedURLException, SmbException {

		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class,
				StartDtsxProperties.class);
		StartDtsxProperties properties = context.getBean(StartDtsxProperties.class);

		String urlAttivi = properties.getRemoteFolderInputAttivi();
		String urlPassivi = properties.getRemoteFolderInputPassivi();
		NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, properties.getFileUser(),
				properties.getFilePassword());

		SmbFile dirAttivi = new SmbFile(urlAttivi, auth);
		log.info("Connessione riuscita al seguente path: " + urlAttivi);
		SmbFile dirPassivi = new SmbFile(urlPassivi, auth);
		log.info("Connessione riuscita al seguente path: " + urlPassivi);
		boolean fileExists;

		if (dirAttivi.listFiles().length > 0 || dirPassivi.listFiles().length > 0) {
			fileExists = true;
		} else {
			fileExists = false;
		}
		return fileExists;
	}

	@Override
	public void execStoredProcedure() {

		String storedName = "SP_MGAlfaBuilder";
		log.info("Eseguo stored Procedure: " + storedName);
		StoredProcedureQuery storedProcedure = emalfa.createStoredProcedureQuery(storedName);
		storedProcedure.execute();
	}


}
