package com.ab.constants;

import com.ab.enums.ConfigProperties;
import com.ab.utilities.DateUtil;
import com.ab.utilities.PropertiesUtil;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CONFIG_FILE_PATH = RESOURCES_PATH + "/config/FrameworkConfigs.properties";
    private static final String EXTENT_REPORTS_FOLDER_PATH = System.getProperty("user.dir") + "/extent-test-output/";
    private static String extentReportsFilePath = "";
    private static final String EXCEL_PATH = RESOURCES_PATH + "/excel/testdata1.xlsx";
    private static final String EXCEL_DATA_SHEET = "DATA";
    private static final String EXCEL_RUN_MANAGER = "RUNMANAGER";
    private static final int EXPLICIT_WAIT = 1;

    public static String getExcelDataSheet() {
        return EXCEL_DATA_SHEET;
    }

    public static String getExcelRunManager() {
        return EXCEL_RUN_MANAGER;
    }

    public static String getExcelPath() {
        return EXCEL_PATH;

    }

    public static String getConfiguration() {
        return CONFIG_FILE_PATH;

    }

    public static int getExplicitWait() {
        return EXPLICIT_WAIT;
    }

    public static String getExtentReportsFilePath() {
        if (extentReportsFilePath.isEmpty()) {
            extentReportsFilePath = createReportPath();
        }
        return extentReportsFilePath;
    }

    private static String createReportPath() {
        if (PropertiesUtil.getPropertyValues(ConfigProperties.OVER_RIDE_REPORTS).equalsIgnoreCase("no")) {
            return EXTENT_REPORTS_FOLDER_PATH + DateUtil.humanTime() + "/index.html";
        } else {
            return EXTENT_REPORTS_FOLDER_PATH + "/index.html";
        }
    }
}
