package org.icao.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThereIsNoDataToConvert extends RuntimeException {

	private static final long serialVersionUID = 9160889012349597370L;
	private static final Logger logger = LoggerFactory.getLogger(ThereIsNoDataToConvert.class);

	public ThereIsNoDataToConvert(String message) {
		super(message);
		logger.debug("There is no data in database");
	}

	public ThereIsNoDataToConvert(String message, Exception e) {
		super(message);
		logger.debug("There is no data in database", e);
	}
}
