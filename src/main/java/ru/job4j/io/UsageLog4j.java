package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");

        byte byteNumber = 4;
        short shortNumber = 200;
        int intNumber = 1234;
        long longNumber = 5000000000L;
        float floatNumber = 12.4F;
        double doubleNumber = 23.33;
        boolean b = true;
        char ch = 'a';
        LOG.debug("Byte = {}, short = {}, int = {}, long = {}, float = {}, double = {}, boolean = {}, char = {}",
                byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber, b, ch);
    }
}
