package com.ab.constants;

import com.ab.enums.ConfigProperties;
import com.ab.utilities.DateUtil;
import com.ab.utilities.PropertiesUtil;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/FrameworkConfigs.properties";
    private static final String EXTENTREPORTSFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
    private static String extentreportsfilepath = "";
    private static final String EXCELPATH = RESOURCESPATH + "/excel/testdata.xlsx";
    private static final String EXCELDATASHEET = "DATA";
    private static final String EXCELRUNMANAGER = "RUNMANAGER";
    private static final int EXPLICITWAIT = 1;

    public static String getExcelDataSheet() {
        return EXCELDATASHEET;
    }

    public static String getExcelRunManager() {
        return EXCELRUNMANAGER;
    }

    public static String getExcelPath() {
        return EXCELPATH;

    }

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
        if (PropertiesUtil.getValues(ConfigProperties.OVER_RIDE_REPORTS).equalsIgnoreCase("no")) {
            return EXTENTREPORTSFOLDERPATH + DateUtil.humanTime() + "/index.html";
        } else {
            return EXTENTREPORTSFOLDERPATH + "/index.html";
        }
    }
}
