package Tests;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

    public class Logback {
        private static final Logger LOGGER =
                LoggerFactory.getLogger(Logback.class);

        public static void main(String[] args) {
            String exe2 = "cde";
            String exe = "abc";
            LOGGER.info("{}",exe);
            LOGGER.error("This is an ERROR level log message!");
            LOGGER.info("Hello World!");
       }
    }


