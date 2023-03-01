package com.ab.utilities;

import com.ab.constants.FrameworkConstants;
import com.ab.enums.ConfigProperties;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import static com.ab.utilities.StringsUtil.getCleanEnumName;

public final class PropertiesUtil {
    private PropertiesUtil() {
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

    public static String getValues(ConfigProperties key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(getCleanEnumName(key)))) {
            throw new Exception("Property name '" + Objects.requireNonNull(key).name() + "' is not found. Please check FrameworkConfigs.properties.");
        }
        return CONFIGMAP.get(getCleanEnumName(key));
    }


}
