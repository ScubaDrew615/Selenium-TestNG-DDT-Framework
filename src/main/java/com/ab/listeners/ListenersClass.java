package com.ab.listeners;

import com.ab.annotations.FrameworkAnnotation;
import com.ab.reports.ExtentReportLogger;
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
        ExtentReport.createTest(result.getMethod().getDescription());
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotation.class).author());
        ExtentReport.addSuites(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotation.class).suites());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        try {
            ExtentReportLogger.pass(StringsUtil.addSpacesAndCapitalize(methodName),true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        try {
            ExtentReportLogger.fail(StringsUtil.addSpacesAndCapitalize(methodName),true);
            ExtentReportLogger.fail(result.getThrowable().getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        try {
            ExtentReportLogger.skip(StringsUtil.addSpacesAndCapitalize(methodName), true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
