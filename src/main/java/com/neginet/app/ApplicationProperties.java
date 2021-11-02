package com.neginet.app;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public enum ApplicationProperties {
    INSTANCE;

    private final Properties properties;

    ApplicationProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public String getPathTextFile() {
        return properties.getProperty("pathTextFile");
    }

    public String getMostCommonElementsSize() {
        return properties.getProperty("mostCommonElementsSize");
    }

    public String getListModifiedNamesSize() {
        return properties.getProperty("listModifiedNamesSize");
    }
}
