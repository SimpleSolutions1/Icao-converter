package org.icao.file.operation;

import java.io.BufferedWriter;
import java.io.IOException;

public interface FileWriter {
	public BufferedWriter writeFile() throws IOException;
}
