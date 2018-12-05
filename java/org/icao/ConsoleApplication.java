package org.icao;

import java.io.IOException;
import java.util.Scanner;

import org.icao.converter.FileConverter;
import org.icao.file.operation.FileReaderImpl;
import org.icao.file.operation.FileWriterImpl;
import org.icao.model.file.File;
import org.icao.model.file.SourceFile;
import org.icao.model.file.TargetFile;
import org.icao.model.message.FileMessageImpl;

public class ConsoleApplication {

	public void run() throws IOException {
		try (Scanner scanner = new Scanner(System.in)) {

			FileMessageImpl fileMessage = new FileMessageImpl();
			fileMessage.sourceFileNameMessage();
			String sourcePath = scanner.next();
			fileMessage.targetFileNameMessage();
			String targetPath = scanner.next();
			File sourceFile = new SourceFile(sourcePath);
			File targetFile = new TargetFile(targetPath);

			FileReaderImpl fileReader = new FileReaderImpl(sourceFile);
			FileWriterImpl fileWriter = new FileWriterImpl(targetFile);
			FileConverter fileConverter = new FileConverter(fileReader, fileWriter);
			fileConverter.convertFile();

		}
	}

}
