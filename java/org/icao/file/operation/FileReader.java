package org.icao.file.operation;

import java.io.IOException;
import java.util.stream.Stream;

public interface FileReader {
	public Stream<String> readFile() throws IOException;
}
