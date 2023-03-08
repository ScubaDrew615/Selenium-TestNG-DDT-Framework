package com.ab.listeners;

import com.ab.annotations.FrameworkAnnotation;
import com.ab.listeners.reports.ExtentReport;
import com.ab.listeners.reports.ExtentReportLogger;
import com.ab.utilities.StringsUtil;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * <p>The ListenersClass class implements ITestListener and ISuiteListener to listen to events in a test automation framework.
 * It creates, adds authors and suites to tests, and logs results to the Extent report.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */
public class ListenersClass implements ITestListener, ISuiteListener {

    /**
     * Initializes the Extent report before the suite starts.
     *
     * @param suite the TestNG suite to start
     */
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    /**
     * Closes the Extent report after the suite finishes.
     *
     * @param suite the TestNG suite to finish
     */
    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.closeReports();
    }

    /**
     * Creates a new Extent test and adds authors and suites to the test before the test starts.
     *
     * @param result the TestNG result of the test to start
     */
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getDescription());
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotation.class).author());
        ExtentReport.addSuites(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotation.class).suites());
    }

    /**
     * Logs a passed result to the Extent report after the test succeeds.
     *
     * @param result the TestNG result of the test that succeeded
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        ExtentReportLogger.pass(StringsUtil.addSpacesAndCapitalize(methodName), true);
    }

    /**
     * Logs a failed result to the Extent report after the test fails.
     *
     * @param result the TestNG result of the test that failed
     */
    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        ExtentReportLogger.fail(StringsUtil.addSpacesAndCapitalize(methodName), true);
        ExtentReportLogger.fail(result.getThrowable().getMessage());
    }

    /**
     * Logs a skipped result to the Extent report after the test is skipped.
     *
     * @param result the TestNG result of the test that was skipped
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        ExtentReportLogger.skip(StringsUtil.addSpacesAndCapitalize(methodName), true);
    }

}
