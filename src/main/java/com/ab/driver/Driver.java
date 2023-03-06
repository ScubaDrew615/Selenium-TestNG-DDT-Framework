package com.ab.driver;

import com.ab.enums.ConfigProperties;
import com.ab.utilities.PropertiesUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Objects;

public final class Driver {
    private Driver() {}

    public static void initDriver(String browserName) throws Exception {
        if (Objects.isNull(DriverManager.getDriver())) {
            switch(browserName.toLowerCase()) {
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
                    throw new IllegalArgumentException("Invalid browser name: " + browserName);
            }
            DriverManager.getDriver().get(PropertiesUtil.getPropertieValues(ConfigProperties.URL));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
