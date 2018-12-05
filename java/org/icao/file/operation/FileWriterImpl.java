package org.icao.file.operation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.icao.model.file.File;

public class FileWriterImpl implements FileWriter {

	private File file;

	public FileWriterImpl(File file) {
		this.file = file;
	}

	@Override
	public BufferedWriter writeFile() throws IOException {
		return Files.newBufferedWriter(Paths.get(this.file.getPath()), StandardOpenOption.CREATE);
	}

}
