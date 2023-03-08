package com.ab.test;

import com.ab.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

/**
 * <p>The BaseTest class is the base class for all test classes in the framework.
 * It contains a constructor, a setup method, and a teardown method.
 * </p>
 * @author
 * @version 1.0
 * @project
 */
public class BaseTest {
    protected BaseTest() {
    }

    @SuppressWarnings("unchecked")
    @BeforeMethod
    protected void setup(Object[] data) {
        Map<String,String> map = (Map<String,String>) data[0];
        Driver.initDriver(map.get("browser"));

    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();

    }

}
