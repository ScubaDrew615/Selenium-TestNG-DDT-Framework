package com.ab.driver;

import org.openqa.selenium.WebDriver;

/**
 * <p>The DriverManager class provides a thread-safe way to manage WebDriver instances in a test automation framework.
 * It uses thread-local storage to store the WebDriver instances for each thread separately.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 * @see Driver
 */

public final class DriverManager {

    /**
     * Thread-local storage for storing WebDriver instances for each thread separately.
     */
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    /**
     * Private constructor to prevent instantiation of the class
     */
    private DriverManager() {
    }

    /**
     * This method returns the WebDriver instance from the thread-local storage for the current thread.
     *
     * @return the WebDriver instance from the thread-local storage for the current thread, or null if no WebDriver instance is set
     */
    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    /**
     * This method sets the specified WebDriver instance in the thread-local storage for the current thread.
     *
     * @param driver the WebDriver instance to be set in the thread-local storage
     */
    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    /**
     * This method removes the WebDriver instance from the thread-local storage for the current thread.
     * It is recommended to call this method after quitting the WebDriver instance to ensure that the thread-local storage
     * is cleaned up properly.
     */
    public static void unload() {
        driverThreadLocal.remove();
    }
}
