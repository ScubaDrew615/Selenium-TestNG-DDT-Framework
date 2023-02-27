package com.ab.utilities;

import com.ab.constants.FrameworkConstants;
import com.ab.enums.ConfigProperties;

import java.io.FileInputStream;
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
            inputStream = new FileInputStream(FrameworkConstants.getConfiguration());
            property.load(inputStream);
            for (Map.Entry<Object, Object> entry : property.entrySet()) {
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getHashMapValues(ConfigProperties key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(key)) {
            throw new Exception("Property name '" + key.name() + "' is not found. Please check FrameworkConfigs.properties.");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }

    public static String getHashTableValues(ConfigProperties key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(key)) {
            throw new Exception("Property name '" + key.name() + "' is not found. Please check FrameworkConfigs.properties.");
        }
        return property.getProperty(key.name().toLowerCase());
    }

}
