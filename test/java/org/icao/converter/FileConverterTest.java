package org.icao.converter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.icao.file.operation.FileReaderImpl;
import org.icao.file.operation.FileWriterImpl;
import org.icao.model.file.SourceFile;
import org.icao.model.file.TargetFile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class FileConverterTest {
	private FileReaderImpl fileReader;
	private FileWriterImpl fileWriter;
	private FileConverter fileConverter;
	private Path sourceFilePath;
	private Path targetFilePath;
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Before
	public void setUp() throws IOException {
		createTargetFile();
		createSourceFile();
		this.fileConverter = new FileConverter(fileReader, fileWriter);
	}

	private void createSourceFile() throws IOException {
		String textInFile = "DUMMY";
		File testFile = folder.newFile();
		sourceFilePath = testFile.toPath();
		SourceFile sourceFile = new SourceFile(sourceFilePath.toString());
		this.fileReader = new FileReaderImpl(sourceFile);
		FileWriterImpl writeSourceFile = new FileWriterImpl(sourceFile);
		BufferedWriter writerToTestSourceFile = writeSourceFile.writeFile();
		writerToTestSourceFile.write(textInFile);
		writerToTestSourceFile.flush();
		List<String> read = Files.readAllLines(sourceFilePath);
	}

	private void createTargetFile() throws IOException {
		File testargetFile = folder.newFile();
		targetFilePath = testargetFile.toPath();
		TargetFile targetFile = new TargetFile(targetFilePath.toString());
		this.fileWriter = new FileWriterImpl(targetFile);
	}

	@Test
	public void testConvertFile_GivenSourceFile_WhenConvertFile_ThenReturnConvertedFile() throws IOException {
		this.fileConverter.convertFile();
		List<String> read = Files.readAllLines(targetFilePath);
		
		Assert.assertEquals("DeltaUniformMikeMikeYankee", read.get(0));
	}
}
