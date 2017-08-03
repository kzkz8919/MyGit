package log4j;

import org.testng.annotations.Test;

public class TestLog {

	public Log log = new Log(this.getClass());
	@Test
	public void testLog() {
		log.error("this is error log!");
		log.info("this is info log!");
		log.debug("this is debug log!");
	}
}
