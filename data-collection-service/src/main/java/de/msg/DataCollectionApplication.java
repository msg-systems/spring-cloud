package de.msg;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * A simple {@link SpringBootApplication} bootstraps Spring's
 * {@link org.springframework.context.ApplicationContext} and generates some
 * simple example test data.
 * 
 * @author Rafael Kansy, Micahel Schäfer 
 */
public class DataCollectionApplication {

	/**
	 * Main method as entry point of {@link DataCollectionApplication}.
	 *
	 * @param args
	 *            The command line arguments.
	 */
	public static void main(String[] args) {
		new SpringApplicationBuilder(DataCollectionConfiguration.class).web(true).run(args);
	}
}