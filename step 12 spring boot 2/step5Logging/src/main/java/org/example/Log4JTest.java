package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JTest {

  private static final Logger logger = LogManager.getLogger(Log4JTest.class);

    public static void main(String[] args) {
        process();
    }

  public static void process(){
      //service
      logger.trace("From The Trace Method");
      logger.debug("From The Debug Method");
      logger.info("From The info Method");
      logger.warn("From The Warm Method");
      logger.error("From The Error Method");
      logger.fatal("From The Fatal Method");
  }

}
