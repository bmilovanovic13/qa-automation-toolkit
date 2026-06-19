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

            if (input == null) {
                input = Config.class
                        .getClassLoader()
                        .getResourceAsStream("config/config.properties.example");
            }

            if (input != null) {
                props.load(input);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration", e);
        }
    }

    public static String get(String key) {

        String envValue = System.getenv(key);

        if (envValue != null && !envValue.isBlank()) {
            return envValue;
        }

        String propertyValue = props.getProperty(key);

        if (propertyValue != null && !propertyValue.isBlank()) {
            return propertyValue;
        }

        throw new RuntimeException("Property is missing or empty: " + key);
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

    public static String get(ConfigKey key) {
        return get(key.name());
    }

    public static boolean getBoolean(ConfigKey key) {
        return Boolean.parseBoolean(get(key));
    }
}
