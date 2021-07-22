package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private Properties properties = new Properties();
    public PropertyReader(String filepath) {
        filepath = "src/main/resources/configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(filepath);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getPropertyValueByKey(String key) {
        properties.getProperty(key);
        return properties.getProperty(key);
    }
}