package org.icao.file.operation;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import org.icao.model.file.SourceFile;
import org.junit.Test;

public class FileReaderTest {

	@Test(expected = NoSuchFileException.class)
	public void testReadFile_WhenFileNotExists() throws IOException {
		SourceFile sourceFile = new SourceFile("x");
		FileReaderImpl fileReaderImpl = new FileReaderImpl(sourceFile);
		fileReaderImpl.readFile();
	}
}
