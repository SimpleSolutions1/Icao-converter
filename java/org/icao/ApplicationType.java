package org.icao;

public enum ApplicationType {
	CONSOLE("C"), WEB("W");

	private String value;

	ApplicationType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
