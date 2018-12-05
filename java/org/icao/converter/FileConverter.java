package org.icao.converter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.stream.Stream;

import org.icao.data.IcaoConverterMap;
import org.icao.exception.ProblemWithConvertFile;
import org.icao.exception.ProblemWithWriteToFile;
import org.icao.file.operation.FileReaderImpl;
import org.icao.file.operation.FileWriterImpl;

public class FileConverter {
	private FileReaderImpl fileReader;
	private FileWriterImpl fileWriter;
	private IcaoConverterImpl icaoConverter;

	public FileConverter(FileReaderImpl fileReader, FileWriterImpl fileWriter) {
		this.fileReader = fileReader;
		this.fileWriter = fileWriter;
	}

	public void convertFile() {
		prepareConverter();
		String convertedText = convertTextFromReadFile();
		writeConvertedTextToFile(convertedText);
	}

	private void prepareConverter() {
		IcaoConverterMap icaoConverterMap = new IcaoConverterMap();
		this.icaoConverter = new IcaoConverterImpl(icaoConverterMap.getConverterMap());
	}

	private String convertTextFromReadFile() {
		StringBuilder sb = new StringBuilder();
		try (Stream<String> stream = this.fileReader.readFile()) {
			for (String line : (Iterable<String>) stream::iterator) {
				sb.append(this.icaoConverter.convert(line));
			}
		} catch (Exception e) {
			throw new ProblemWithConvertFile("There is a problem with convert file " + fileReader.getFile().getPath(),
					e);
		}
		return sb.toString();
	}

	private void writeConvertedTextToFile(String convertedText) {

		try (BufferedWriter writer = this.fileWriter.writeFile()) {
			writer.write(convertedText);
			writer.flush();
		} catch (IOException io) {
			throw new ProblemWithWriteToFile("There is a problem with Write file ", io);
		} catch (Exception e) {
			throw new ProblemWithWriteToFile("There is a problem with Write file ", e);
		}
	}
}
