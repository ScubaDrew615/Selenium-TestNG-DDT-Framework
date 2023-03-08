package com.ab.utilities;

import com.ab.constants.FrameworkConstants;
import com.ab.enums.ConfigProperties;
import com.ab.exceptions.PropertyNotFoundException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * <p>The PropertiesUtil class contains utility methods for working with properties files.
 * It contains a private constructor to prevent object instantiation and a static initializer block to load the properties file and populate a map with its contents.
 * It also contains a method to retrieve the value of a property given its key.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */
public final class PropertiesUtil {

    /**
     * Private constructor to prevent object instantiation
     */
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
            System.exit(0);
        }
    }

    /**
     * This method retrieves the value of a property given its key.
     * If the key or its corresponding value is null, a PropertyNotFoundException is thrown.
     *
     * @param key The key of the property whose value is to be retrieved
     * @return The value of the property with the specified key
     * @throws PropertyNotFoundException If the key or its corresponding value is null
     */
    public static String getPropertyValues(ConfigProperties key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key))) {
            if (Objects.nonNull(key)) {
                throw new PropertyNotFoundException("Property name '" + key.name() + "' is not found. Please check FrameworkConfigs.properties.");
            }
        }
        return CONFIGMAP.get(key);
    }
}
