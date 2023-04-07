package com.ab.constants;

import com.ab.enums.ConfigProperties;
import com.ab.reports.ExtentReport;
import com.ab.utilities.DateUtil;
import com.ab.utilities.PropertiesUtil;

/**
 * A class that provides constants and methods related to the test framework.
 *
 * <p>
 * This class contains various constants related to the test framework, such as file paths, sheet names, and wait times.
 * It also includes a method to create the path of the Extent reports file based on the configuration.
 * </p>
 * @author Andrew Bakheet
 * @version   1.0
 * @project Selenium-Framework
 * @see PropertiesUtil
 * @see com.ab.factories.ExplicitWaitFactory
 * @see com.ab.listeners.MethodInterceptor
 * @see ExtentReport
 * @see com.ab.utilities.DataProviderUtil
 * @see com.ab.utilities.ExcelUtil
 * */

public final class FrameworkConstants {

    /**
     * The path of the resources folder in the project directory.
     */
    private static final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/test/resources";
    /**
     * The path of the framework configuration file.
     */
    private static final String CONFIG_FILE_PATH = RESOURCES_PATH + "/config/FrameworkConfigs.properties";
    /**
     * The path of the folder where Extent reports are generated.
     */
    private static final String EXTENT_REPORTS_FOLDER_PATH = System.getProperty("user.dir") + "/extent-test-output/";
    /**
     * The name of the Excel sheet containing test data.
     */
    private static final String EXCEL_PATH = RESOURCES_PATH + "/excel/testdata.xlsx";
    /**
     * The name of the Excel sheet containing test run manager data.
     */
    private static final String EXCEL_DATA_SHEET = "DATA";
    /**
     * The default explicit wait time in seconds.
     */
    private static final String EXCEL_RUN_MANAGER = "RUNMANAGER";
    /**
     * The path of the Extent reports file.
     */
    private static final int EXPLICIT_WAIT = 10;
    /**
     * The path of the Excel file containing test data.
     */
    private static String extentReportsFilePath = "";

    /**
     * Private constructor to prevent instantiation from outside the class.
     */
    private FrameworkConstants() {
    }

    /**
     * Gets the name of the Excel sheet containing test data.
     *
     * @return the name of the Excel sheet containing test data.
     */
    public static String getExcelDataSheet() {
        return EXCEL_DATA_SHEET;
    }

    /**
     * Gets the name of the Excel sheet containing test run manager data.
     *
     * @return the name of the Excel sheet containing test run manager data.
     */
    public static String getExcelRunManager() {
        return EXCEL_RUN_MANAGER;
    }

    /**
     * Gets the path of the Excel file containing test data.
     *
     * @return the path of the Excel file containing test data.
     */
    public static String getExcelPath() {
        return EXCEL_PATH;
    }

    /**
     * Gets the path of the framework configuration file.
     *
     * @return the path of the framework configuration file.
     */
    public static String getConfiguration() {
        return CONFIG_FILE_PATH;
    }

    /**
     * Gets the default explicit wait time in seconds.
     *
     * @return the default explicit wait time in seconds.
     */
    public static int getExplicitWait() {
        return EXPLICIT_WAIT;
    }

    /**
     * Gets the path of the Extent reports file.
     *
     * <p>
     * If the path has not been created yet, this method calls the {@code createReportPath} method to create it.
     * </p>
     *
     * @return the path of the Extent reports file.
     */
    public static String getExtentReportsFilePath() {
        if (extentReportsFilePath.isEmpty()) {
            extentReportsFilePath = createReportPath();
        }
        return extentReportsFilePath;
    }

    /**
     * Creates the path of the Extent reports file based on the configuration.
     * <p>
     * If the {@code OVER_RIDE_REPORTS} property in the configuration file is set to "no",
     * the path will include a subdirectory with the current date and time, in human-readable format.
     * Otherwise, the path will include only the file name.
     * </p>
     * @return the path of the Extent reports file.*/
    private static String createReportPath() {
        if (PropertiesUtil.getPropertyValue(ConfigProperties.OVER_RIDE_REPORTS).equalsIgnoreCase("no")) {
            return EXTENT_REPORTS_FOLDER_PATH + DateUtil.humanTime() + "/index.html";
        } else {
            return EXTENT_REPORTS_FOLDER_PATH + "/index.html";
        }
    }
}
