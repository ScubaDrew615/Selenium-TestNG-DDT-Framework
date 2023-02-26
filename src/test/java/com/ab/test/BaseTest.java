package com.ab.test;

import com.ab.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected BaseTest() {
    }


    @BeforeMethod
    protected void setup() {
        Driver.initDriver();

    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();

    }


}
