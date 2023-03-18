package com.ab.driver;

import com.ab.enums.ConfigProperties;
import com.ab.exceptions.BrowserLaunchException;
import com.ab.factories.DriverFactory;
import com.ab.utilities.PropertiesUtil;

import java.net.MalformedURLException;
import java.util.Objects;

/**
 * <p>A utility class for initializing and quitting a WebDriver instance using the DriverFactory and DriverManager classes.
 * This class cannot be instantiated and contains only static methods.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 * @see DriverManager
 * @see com.ab.test.BaseTest
 */

public final class Driver {

    /**
     * Private constructor to prevent instantiation of the class*/
    private Driver() {
    }

    /**
     * Initializes a WebDriver instance using the DriverFactory and DriverManager classes.
     * If a WebDriver instance does not exist, a new one is created and assigned to the DriverManager.
     *
     * @param browserName a String representing the name of the browser to create a WebDriver instance for
     * @param version
     * @throws BrowserLaunchException if an error occurs while initializing the WebDriver instance
     */
    public static void initDriver(String browserName, String version) {
        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browserName, version));
            } catch (MalformedURLException e) {
                throw new BrowserLaunchException("Please check the browser capabilities");
            }
            DriverManager.getDriver().get(PropertiesUtil.getPropertyValue(ConfigProperties.URL));
        }
    }

    /**
     * Quits the current WebDriver instance and unloads it from the DriverManager.
     */
    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
