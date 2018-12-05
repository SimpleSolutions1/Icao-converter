package org.icao.model.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileMessageImpl implements FileMessage {
	private static final Logger logger = LoggerFactory.getLogger(FileMessageImpl.class);

	@Override
	public void sourceFileNameMessage() {
		logger.info("Enter source file path ");
	}

	@Override
	public void targetFileNameMessage() {
		logger.info("Enter target file path ");
	}

}
