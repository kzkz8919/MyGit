package log4j;

import org.apache.log4j.Logger;
import org.testng.Reporter;

public class Log {

	private Logger logger;

	public Log(Class<?> clazz) {
		logger = Logger.getLogger(clazz);
	}

	public Log(String s) {
		logger = Logger.getLogger(s);
	}

	public void info(Object message) {
		logger.info(message);
		this.testngLogOutput(message);
	}

	public void error(Object message) {
		logger.error(message);
		this.testngLogOutput(message);
	}

	public void warn(Object message) {
		logger.warn(message);
		this.testngLogOutput(message);
	}

	public void debug(Object message) {
		logger.debug(message);
		this.testngLogOutput(message);
	}

	private void testngLogOutput(Object message) {
		Reporter.log(message.toString());
	}

}
