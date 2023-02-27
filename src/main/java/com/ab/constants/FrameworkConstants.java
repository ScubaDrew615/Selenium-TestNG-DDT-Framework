package com.ab.constants;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static final String CONFIGFILEPATH = System.getProperty("user.dir") + "/src/test/resources/config/FrameworkConfigs.properties";
    private static final int EXPLICITWAIT = 10;

    public static String getConfiguration() {
        return CONFIGFILEPATH;

    }

    public static int getExplicitWait() {
        return EXPLICITWAIT;
    }
}
