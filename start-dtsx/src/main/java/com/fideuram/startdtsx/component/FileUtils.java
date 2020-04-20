package com.fideuram.startdtsx.component;

import java.net.MalformedURLException;

import jcifs.smb.SmbException;

public interface FileUtils {

	boolean isFileExists() throws MalformedURLException, SmbException;
	void execStoredProcedure();

}
