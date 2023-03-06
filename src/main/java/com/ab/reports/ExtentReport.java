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

public final class ExtentReport {
    private ExtentReport() {
    }

    private static ExtentReports reports;

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

    public static void createTest(String testCaseName) {
        ExtentReportManager.setExtentTest(reports.createTest(testCaseName));
    }

    public static void addAuthors(String[] authors) {
        for (String temp : authors) {
            ExtentReportManager.getExtentTest().assignAuthor(temp);
        }
    }

    public static void addSuites(SuiteType[] suites) {
        for (SuiteType suite : suites) {
            ExtentReportManager.getExtentTest().assignCategory(StringsUtil.getCleanEnumName(suite));
        }
    }

}
