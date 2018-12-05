package org.icao.file.operation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.icao.model.file.File;

public class FileReaderImpl implements FileReader {

	private File file;

	public FileReaderImpl(File file) {
		this.file = file;
	}

	@Override
	public Stream<String> readFile() throws IOException {
		return Files.lines(Paths.get(this.file.getPath()));
	}

	public File getFile() {
		return file;
	}

}
