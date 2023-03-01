package com.ab.constants;

import com.ab.enums.ConfigProperties;
import com.ab.enums.DateFormats;
import com.ab.utilities.DateUtil;
import com.ab.utilities.PropertiesUtil;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static final String CONFIGFILEPATH = System.getProperty("user.dir") + "/src/test/resources/config/FrameworkConfigs.properties";
    private static final String EXTENTREPORTSFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
    private static String extentreportsfilepath = "";
    private static final int EXPLICITWAIT = 1;


    public static String getConfiguration() {
        return CONFIGFILEPATH;

    }

    public static int getExplicitWait() {
        return EXPLICITWAIT;
    }

    public static String getExtentReportsFilePath() throws Exception {
        if (extentreportsfilepath.isEmpty()) {
            extentreportsfilepath = createReportPath();
        }
        return extentreportsfilepath;
    }

    private static String createReportPath() throws Exception {
        if (PropertiesUtil.getValues(ConfigProperties.OVERRIDE_REPORTS).equalsIgnoreCase("no")) {
            return EXTENTREPORTSFOLDERPATH + humanTime() + "/index.html";
        } else {
            return EXTENTREPORTSFOLDERPATH + "/index.html";
        }
    }
    private static String humanTime(){
        return DateUtil.convertUnixTime(System.currentTimeMillis(), DateFormats.LONG12H);
    }
}
