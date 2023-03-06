package com.ab.utilities;

import com.ab.constants.FrameworkConstants;
import com.ab.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertiesUtil {
    private PropertiesUtil() {
    }

    private static final Properties property = new Properties();
    private static final Map<ConfigProperties, String> CONFIGMAP = new HashMap<>();

    static {
        try (FileInputStream inputStream = new FileInputStream(FrameworkConstants.getConfiguration())) {
            property.load(inputStream);
            for (ConfigProperties key : ConfigProperties.values()) {
                CONFIGMAP.put(key, property.getProperty(key.name().toLowerCase()).trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertieValues(ConfigProperties key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key))) {
            if (Objects.nonNull(key)) {
                throw new Exception("Property name '" + key.name() + "' is not found. Please check FrameworkConfigs.properties.");
            }
        }
        return CONFIGMAP.get(key);
    }
}
