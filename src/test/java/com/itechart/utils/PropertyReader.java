package com.itechart.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private Properties properties = new Properties();

    public PropertyReader(String filepath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filepath);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getPropertyValueByKey(String key) {
        if (properties.getProperty(key) != null) {
            return properties.getProperty(key);
        } else {
            System.out.println("Cannot find properly by key: " + key);
            throw new RuntimeException("Cannot find properly by key: " + key);
        }
    }
}