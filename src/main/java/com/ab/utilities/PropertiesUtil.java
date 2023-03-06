package com.ab.utilities;

import com.ab.constants.FrameworkConstants;
import com.ab.enums.ConfigProperties;
import com.ab.exceptions.PropertyFileLoadException;
import com.ab.exceptions.PropertyNotFoundException;

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
            throw new PropertyFileLoadException("Error while loading properties file.");
        }
    }

    public static String getPropertyValues(ConfigProperties key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key))) {
            if (Objects.nonNull(key)) {
                throw new PropertyNotFoundException("Property name '" + key.name() + "' is not found. Please check FrameworkConfigs.properties.");
            }
        }
        return CONFIGMAP.get(key);
    }
}
