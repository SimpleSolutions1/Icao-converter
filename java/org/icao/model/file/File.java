package org.icao.model.file;

public abstract class File {
	private String path;

	public File(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

}
