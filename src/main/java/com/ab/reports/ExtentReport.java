package com.ab.reports;

import com.ab.constants.FrameworkConstants;
import com.ab.enums.SuiteType;
import com.ab.utilities.StringsUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * <p>The ExtentReport class is used to initialize and close the ExtentReports instance, create and manage test reports, and add information
 * such as authors and suites to the report. This class uses the ExtentReportManager class to manage ExtentTest objects for each thread.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 * @see ExtentReportManager
 * @see com.aventstack.extentreports.ExtentReports
 * @see com.aventstack.extentreports.ExtentTest
 * @see com.aventstack.extentreports.reporter.ExtentSparkReporter
 */

public final class ExtentReport {

    /**
     * The ExtentReports instance used to generate the test report
     */
    private static ExtentReports reports;

    /**
     * Private constructor to prevent instantiation from outside the class
     */
    private ExtentReport() {
    }

    /**
     * Initializes the ExtentReports instance with the specified configuration settings.
     */
    public static void initReports() {
        if (Objects.isNull(reports)) {
            reports = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportsFilePath());
            reports.attachReporter(spark);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Test Report");
            spark.config().setReportName("Demo Test");
        }
    }

    /**
     * Closes the ExtentReports instance and removes the ExtentTest object for the current thread.
     */
    public static void closeReports()  {
        if (Objects.nonNull(reports)) {
            reports.flush();
        }
        ExtentReportManager.unload();
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportsFilePath()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the ExtentReports instance and removes the ExtentTest object for the current thread.
     */
    public static void createTest(String testCaseName) {
        ExtentReportManager.setExtentTest(reports.createTest(testCaseName));
    }

    /**
     * Adds the specified authors to the current ExtentTest object.
     *
     * @param authors an array of author names
     */
    public static void addAuthors(String[] authors) {
        for (String temp : authors) {
            ExtentReportManager.getExtentTest().assignAuthor(temp);
        }
    }

    /**
     * Adds the specified suite types to the current ExtentTest object.
     *
     * @param suites an array of SuiteType enum values
     * @see com.ab.enums.SuiteType
     * @see com.ab.utilities.StringsUtil#getCleanEnumName(Enum)
     */
    public static void addSuites(SuiteType[] suites) {
        for (SuiteType suite : suites) {
            ExtentReportManager.getExtentTest().assignCategory(StringsUtil.getCleanEnumName(suite));
        }
    }

}
