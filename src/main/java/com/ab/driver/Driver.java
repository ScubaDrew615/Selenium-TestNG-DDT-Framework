package com.ab.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public final class Driver {

    private Driver() {
    }

    public static void initDriver() {
        if (Objects.isNull(DriverManager.getDriver())) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            DriverManager.setDriver(driver);
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
