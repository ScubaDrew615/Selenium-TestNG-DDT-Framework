package com.ab.reports;

import com.ab.enums.ConfigProperties;
import com.ab.utilities.PropertiesUtil;
import com.aventstack.extentreports.MediaEntityBuilder;

import static com.ab.utilities.ScreenShotsUtil.getBase64Image;

public final class ExtentReportLogger {

    private ExtentReportLogger() {
    }

    public static void pass(String message) {
        ExtentReportManager.getExtentTest().pass(message);
    }

    public static void fail(String message) {
        ExtentReportManager.getExtentTest().fail(message);
    }

    public static void skip(String message) {
        ExtentReportManager.getExtentTest().skip(message);
    }

    public static void pass(String message, boolean needScreenShot) throws Exception {
        if (PropertiesUtil.getPropertieValues(ConfigProperties.PASSED_STEPS_SCREENSHOTS).equalsIgnoreCase("yes")
                && needScreenShot) {
            ExtentReportManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        } else {
            pass(message);
        }
    }

    public static void fail(String message, boolean needScreenShot) throws Exception {
        if (PropertiesUtil.getPropertieValues(ConfigProperties.FAILED_STEPS_SCREENSHOTS).equalsIgnoreCase("yes")
                && needScreenShot) {
            ExtentReportManager.getExtentTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        } else {
            fail(message);
        }
    }

    public static void skip(String message, boolean needScreenShot) throws Exception {
        if (PropertiesUtil.getPropertieValues(ConfigProperties.SKIPPED_STEPS_SCREENSHOTS).equalsIgnoreCase("yes")
                && needScreenShot) {
            ExtentReportManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        } else {
            skip(message);
        }
    }



}
