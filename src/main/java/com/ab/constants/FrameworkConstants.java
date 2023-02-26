package com.ab.constants;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static final String CONFIGFILEPATH = System.getProperty("user.dir") + "/src/test/resources/config/FrameworkConfigs.properties";

    public static String getConfiguration() {
    return CONFIGFILEPATH;

    }
}
