package com.ab.listeners.reports;

import com.ab.enums.ConfigProperties;
import com.ab.utilities.PropertiesUtil;
import com.aventstack.extentreports.MediaEntityBuilder;

import static com.ab.utilities.ScreenShotsUtil.getBase64Image;

/**
 * <p>The ExtentReportLogger class provides methods to log test step results to an ExtentTest object in the test report. The class
 * uses the ExtentReportManager class to manage ExtentTest objects for each thread.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 * @see ExtentReportManager
 * @see com.ab.enums.ConfigProperties
 * @see com.ab.utilities.PropertiesUtil
 * @see com.ab.utilities.ScreenShotsUtil
 * @see com.aventstack.extentreports.MediaEntityBuilder
 */
public final class ExtentReportLogger {

    /**
     * Private constructor to prevent instantiation from outside the class
     */
    private ExtentReportLogger() {
    }

    /**
     * Logs a passed test step with the specified message to the current ExtentTest object.
     *
     * @param message the message to log
     */
    public static void pass(String message) {
        ExtentReportManager.getExtentTest().pass(message);
    }

    /**
     * Logs a failed test step with the specified message to the current ExtentTest object.
     *
     * @param message the message to log
     */
    public static void fail(String message) {
        ExtentReportManager.getExtentTest().fail(message);
    }

    /**
     * Logs a skipped test step with the specified message to the current ExtentTest object.
     *
     * @param message the message to log
     */
    public static void skip(String message) {
        ExtentReportManager.getExtentTest().skip(message);
    }

    /**
     * Logs a passed test step with the specified message and screenshot to the current ExtentTest object.
     * The screenshot is taken using the getBase64Image method of the ScreenShotsUtil class and is added to the report
     * only if the PASSED_STEPS_SCREENSHOTS property is set to "yes" in the configuration properties file.
     *
     * @param message the message to log
     * @param needScreenShot a flag indicating whether a screenshot should be taken
     */
    public static void pass(String message, boolean needScreenShot) {
        if (PropertiesUtil.getPropertyValues(ConfigProperties.PASSED_STEPS_SCREENSHOTS).equalsIgnoreCase("yes")
                && needScreenShot) {
            ExtentReportManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        } else {
            pass(message);
        }
    }

    /**
     * Logs a failed test step with the specified message and screenshot to the current ExtentTest object.
     * The screenshot is taken using the getBase64Image method of the ScreenShotsUtil class and is added to the report
     * only if the FAILED_STEPS_SCREENSHOTS property is set to "yes" in the configuration properties file.
     *
     * @param message the message to log
     * @param needScreenShot a flag indicating whether a screenshot should be taken
     */
    public static void fail(String message, boolean needScreenShot) {
        if (PropertiesUtil.getPropertyValues(ConfigProperties.FAILED_STEPS_SCREENSHOTS).equalsIgnoreCase("yes")
                && needScreenShot) {
            ExtentReportManager.getExtentTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        } else {
            fail(message);
        }
    }

    /**
     * Logs a skipped test step with the specified message and screenshot to the current ExtentTest object.
     * The screenshot is taken using the getBase64Image method of the ScreenShotsUtil class and is added to the report
     * only if the SKIPPED_STEPS_SCREENSHOTS property is set to "yes" in the configuration properties file.
     *
     * @param message the message to log
     * @param needScreenShot a flag indicating whether a screenshot should be taken
     */
    public static void skip(String message, boolean needScreenShot) {
        if (PropertiesUtil.getPropertyValues(ConfigProperties.SKIPPED_STEPS_SCREENSHOTS).equalsIgnoreCase("yes")
                && needScreenShot) {
            ExtentReportManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        } else {
            skip(message);
        }
    }


}
