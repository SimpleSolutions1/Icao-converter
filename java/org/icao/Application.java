package org.icao;

import java.io.IOException;

import org.icao.converter.ConverterComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Application {

	public static void main(String[] args) throws IOException {

		if (args.length < 1 || ApplicationType.WEB.getValue().equals((args[0]))) {
			ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
			context.getBean(ConverterComponent.class).convert();
		} else if (ApplicationType.CONSOLE.getValue().equals(args[0])) {
			ConsoleApplication console = new ConsoleApplication();
			console.run();
		}
	}

}
