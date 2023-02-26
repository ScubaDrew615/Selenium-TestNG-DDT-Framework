package com.ab.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertiesReader {

    private PropertiesReader() {
    }

    private static Properties property = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    static {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/FrameworkConfigs.properties");
            property.load(inputStream);
            for (Map.Entry<Object, Object> entry : property.entrySet()) {
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getHashMapValues(String key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key))) {
            throw new Exception("Property name '" + key + "' is not found. Please check FrameworkConfigs.properties.");
        }
        return CONFIGMAP.get(key);
    }

    public static String getHashTableValues(String key) throws Exception {
        if (Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
            throw new Exception("Property name '" + key + "' is not found. Please check FrameworkConfigs.properties.");
        }
        String value = property.getProperty(key);
        return value;
    }

}
