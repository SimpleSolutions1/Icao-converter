package org.icao.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProblemWithConvertFile extends RuntimeException {

	private static final long serialVersionUID = 8652842803372200241L;
	private static final Logger logger = LoggerFactory.getLogger(ProblemWithConvertFile.class);

	public ProblemWithConvertFile(String message) {
		super(message);
		logger.debug("There is a problem with convert file ");
	}

	public ProblemWithConvertFile(String message, Exception e) {
		super(message);
		logger.debug("There is a problem with convert file ", e);
	}
}
