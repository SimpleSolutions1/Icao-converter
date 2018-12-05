package org.icao.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProblemWithWriteToFile extends RuntimeException {
	private static final Logger logger = LoggerFactory.getLogger(ProblemWithWriteToFile.class);
	private static final long serialVersionUID = 1516850182405324146L;

	public ProblemWithWriteToFile(String message) {
		super(message);
		logger.debug("There is a problem with Write to file ");
	}

	public ProblemWithWriteToFile(String message, Exception e) {
		super(message);
		logger.debug("There is a problem with Write to file ", e);
	}
}
