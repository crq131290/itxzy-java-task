package com.crq.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Test {

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger("AsyncFileLogger"); // Logger的名称

        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
        logger.fatal("fatal level");
    }
}
