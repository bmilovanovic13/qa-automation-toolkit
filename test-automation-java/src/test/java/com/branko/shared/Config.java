package com.branko.shared;

import java.io.InputStream;
import java.util.Properties;

public class Config {

        private static final Properties props = new Properties();

        static {
            try {
                InputStream input = Config.class
                        .getClassLoader()
                        .getResourceAsStream("config/config.properties");

                props.load(input);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public static String get(String key) {
            String value = props.getProperty(key);

            if (value == null || value.isBlank()) {
                throw new RuntimeException("Property is missing or empty: " + key);
            }

            return value;
        }

        public static boolean getBoolean(String key) {
            return Boolean.parseBoolean(get(key));
         }
}
