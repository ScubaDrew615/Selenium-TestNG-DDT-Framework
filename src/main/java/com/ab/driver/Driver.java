package com.ab.driver;

import com.ab.enums.ConfigProperties;
import com.ab.exceptions.FrameworkExceptions;
import com.ab.utilities.PropertiesUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Objects;

/**
 * <p>The Driver class provides utility methods to initialize and quit a WebDriver instance.
 * It works in conjunction with the DriverManager class to manage the WebDriver instance in a
 * thread-safe manner.
 * <p>
 *
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 * @see DriverManager
 * @see com.ab.test.BaseTest
 * @since 2020-07-13
 */

public final class Driver {

    /**
     * Private constructor to prevent instantiation of the class*/
    private Driver() {
    }

    /**
     * This method initializes a WebDriver instance based on the specified browser name.
     * If a WebDriver instance already exists, this method does nothing.
     * This method also sets the WebDriver instance in the thread-local storage provided by the DriverManager class.
     *
     * @param browserName the name of the browser for which the WebDriver instance needs to be initialized.
     *                    Currently, the supported browser names are "chrome", "firefox", "edge", "ie", and "safari".
     *                    The browser name is case-insensitive.
     * @throws FrameworkExceptions if an invalid browser name is provided.
     *                    If the browser name is not one of the supported names, an exception is thrown with a message
     *                    that indicates the invalid name.
     *                    For example, if "opera" is provided as the browser name, the exception message would be
     *                    "Invalid browser name: opera".*/
    public static void initDriver(String browserName) {
        if (Objects.isNull(DriverManager.getDriver())) {
            switch (browserName.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    DriverManager.setDriver(new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    DriverManager.setDriver(new FirefoxDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    DriverManager.setDriver(new EdgeDriver());
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    DriverManager.setDriver(new InternetExplorerDriver());
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    DriverManager.setDriver(new SafariDriver());
                    break;
                default:
                    throw new FrameworkExceptions("Invalid browser name: " + browserName);
            }
            DriverManager.getDriver().get(PropertiesUtil.getPropertyValues(ConfigProperties.URL));
        }
    }

    /**
     * This method quits the current WebDriver instance and unloads it from the DriverManager.
     * If there is no active WebDriver instance, this method does nothing.
     * Calling this method ensures that the WebDriver instance is
     * properly cleaned up and resources are released.
     * This method also removes the WebDriver instance from the thread-local storage provided by the DriverManager class.
     */
    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
