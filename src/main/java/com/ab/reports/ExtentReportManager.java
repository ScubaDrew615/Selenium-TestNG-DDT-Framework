package com.ab.reports;

import com.aventstack.extentreports.ExtentTest;


public class ExtentReportManager {
    private ExtentReportManager() {
    }

    private static final ThreadLocal<ExtentTest> extentTestTL = new ThreadLocal<>();

    static ExtentTest getExtentTest() {
        return extentTestTL.get();
    }

    static void setExtentTest(ExtentTest test) {
        extentTestTL.set(test);
    }

    static void unload() {
        extentTestTL.remove();
    }


}
