package logging;

import org.apache.log4j.Logger;

public class SampleClass {

	private static final Logger LOGGER = Logger.getLogger(SampleClass.class);

	public void printSomething() {
		LOGGER.info("We are in printSomething() method.");
		System.out.println("Something");
		LOGGER.fatal("A fatal error occurred.");
	}
}
