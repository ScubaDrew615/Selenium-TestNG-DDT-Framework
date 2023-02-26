package com.ab.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager() {
    }

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void unload() {
        driverThreadLocal.remove();
    }
}
