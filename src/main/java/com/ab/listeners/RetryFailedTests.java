package com.ab.listeners;

import com.ab.enums.ConfigProperties;
import com.ab.utilities.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * <p>The RetryFailedTests class is used to retry failed tests based on the value of the "retry_failed_tests" property in the configuration file.
 * It implements the IRetryAnalyzer interface provided by TestNG.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */
public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;

    /**
     * This method retries a failed test based on the value of the "retry_failed_tests" property in the configuration file.
     *
     * @param iTestResult The result of the test method that failed
     * @return true if the test should be retried, false otherwise
     */
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
