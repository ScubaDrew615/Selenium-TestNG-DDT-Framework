package com.ab.listeners;

import com.ab.reports.ExtentLogger;
import com.ab.reports.ExtentReport;
import com.ab.utilities.StringsUtil;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        try {
            ExtentReport.initReports();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.closeReports();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        ExtentReport.createTest(StringsUtil.addSpacesAndCapitalize(methodName));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        ExtentLogger.pass(StringsUtil.addSpacesAndCapitalize(methodName));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        ExtentLogger.fail(StringsUtil.addSpacesAndCapitalize(methodName));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        ExtentLogger.skip(StringsUtil.addSpacesAndCapitalize(methodName));
    }

}
