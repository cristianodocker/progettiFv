package com.fideuram.startdtsx.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fideuram.startdtsx.component.FileUtils;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class StartDtsxBusinessImpl implements StartDtsxBusiness {

	private FileUtils fileUtils;

	@Autowired
	public StartDtsxBusinessImpl(FileUtils fileUtils) {
		this.fileUtils = fileUtils;
	}

	@Override
	public void process() {

		try {

			if (fileUtils.isFileExists()) {
				fileUtils.execStoredProcedure();
			} else {
				log.info("Non sono presenti file in input");
			}

		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
