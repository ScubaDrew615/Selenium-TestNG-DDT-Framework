package com.ab.listeners;

import com.ab.enums.ConfigProperties;
import com.ab.utilities.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean value = false;
        if (PropertiesUtil.getPropertyValues(ConfigProperties.RETRY_FAILED_TESTS).equalsIgnoreCase("yes")) {
            int retries = 1;
            value = count < retries;
            count++;
        }
        return value;
    }
}
