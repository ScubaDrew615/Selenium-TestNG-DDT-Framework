package com.ab.reports;

import com.aventstack.extentreports.ExtentTest;


/**
 * <p>The ExtentReportManager class is used to manage ExtentTest objects for each thread in a test automation framework. Each thread
 * should have its own instance of an ExtentTest object to log information during test execution. This class uses a ThreadLocal
 * variable to ensure that each thread has its own instance of an ExtentTest object.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 * @see com.aventstack.extentreports.ExtentTest
 */
public class ExtentReportManager {

    /**
     * ThreadLocal variable to ensure that each thread has its own instance of an ExtentTest object
     */
    private static final ThreadLocal<ExtentTest> extentTestTL = new ThreadLocal<>();

    /**
     * Private constructor to prevent instantiation from outside the class
     */
    private ExtentReportManager() {
    }

    /**
     * Gets the ExtentTest object for the current thread.
     *
     * @return the ExtentTest object for the current thread
     */
    static ExtentTest getExtentTest() {
        return extentTestTL.get();
    }

    /**
     * Sets the ExtentTest object for the current thread.
     *
     * @param test the ExtentTest object for the current thread
     */
    static void setExtentTest(ExtentTest test) {
        extentTestTL.set(test);
    }

    /**
     * Removes the ExtentTest object for the current thread.
     */
    static void unload() {
        extentTestTL.remove();
    }
}

