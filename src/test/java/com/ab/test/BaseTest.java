package com.ab.test;

import com.ab.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

/**
 * A base test class that initializes and quits a WebDriver instance using the Driver utility class.
 * This class can be extended by other test classes to reuse the setup and teardown methods.
 *
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-TestNG-DDT-Framework
 * @since 1.0
 */
public class BaseTest {

    /**
     * Protected constructor to prevent instantiation of this class.
     */
    protected BaseTest() {
    }

    /**
     * Initializes a WebDriver instance using the browser value specified in the input data array.
     * Expects the input data array to contain a Map object with the "browser" key mapping to a String value.
     *
     * @param data an array of Objects representing the test data to be used for setup
     */
    @SuppressWarnings("unchecked")
    @BeforeMethod
    protected void setup(Object[] data) {
        Map<String, String> map = (Map<String, String>) data[0];
        Driver.initDriver(map.get("browser"));
    }

    /**
     * Quits the current WebDriver instance.
     */
    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }

}
