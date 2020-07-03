package com.hsuhau.spring5.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author hsuhau
 * @date 2020/7/3 23:26
 */
public class Log4j2Test {
    private static final Logger LOGGER = LoggerFactory.getLogger(Log4j2Test.class);

    @Test
    public void testLog4j2() {
        // 2020-07-03 23:58:52.573 [main] INFO  com.hsuhau.spring5.service.Log4j2Test - hello, log4j2
        LOGGER.info("hello, log4j2");
    }
}
