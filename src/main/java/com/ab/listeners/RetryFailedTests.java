package com.ab.listeners;

import com.ab.enums.ConfigProperties;
import com.ab.utilities.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;
    private final int RETRIES = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean value = false;
        try {
            if (PropertiesUtil.getValues(ConfigProperties.RETRY_FAILED_TESTS).equalsIgnoreCase("yes")) {
                value = count < RETRIES;
                count++;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return value;
    }
}
