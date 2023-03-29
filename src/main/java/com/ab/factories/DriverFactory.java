package com.ab.factories;


import com.ab.enums.ConfigProperties;
import com.ab.exceptions.FrameworkExceptions;
import com.ab.utilities.PropertiesUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;


/**
 * <p>The DriverFactory class provides methods to create WebDriver instances for different browsers
 * and different execution modes, such as local or remote.
 * </p>
 *
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-TestNG-DDT-Framework
 * @since 1.0
 */
public class DriverFactory {

    /**
     * Private constructor to prevent instantiation of this class.
     */
    private DriverFactory() {
    }

    /**
     * Returns a WebDriver instance for the specified browser name and execution mode.
     *
     * @param browserName The name of the browser to create a WebDriver instance for.
     * @param version
     * @return A WebDriver instance for the specified browser name and execution mode.
     * @throws MalformedURLException If the URL for the remote WebDriver server is malformed.
     * @throws FrameworkExceptions   If the run mode is not specified in the configuration file, or if the driver creation fails.
     */
    public static WebDriver getDriver(String browserName, String version) throws MalformedURLException {
        String runMode = PropertiesUtil.getPropertyValue(ConfigProperties.RUN_MODE);
        WebDriver driver;
        if (Objects.isNull(runMode)) {
            throw new FrameworkExceptions("Run mode not specified in configuration file");
        }

        if (runMode.equalsIgnoreCase("remote")) {
            driver = createRemoteDriver(browserName, version);
        } else {
            driver = createLocalDriver(browserName);
        }

        if (Objects.isNull(driver)) {
            throw new FrameworkExceptions("Failed to create driver for " + browserName);
        }

        return driver;
    }

    /**
     * Creates a WebDriver instance for the specified browser name and local execution mode.
     *
     * @param browserName The name of the browser to create a WebDriver instance for.
     * @return A WebDriver instance for the specified browser name and local execution mode.
     */
    private static WebDriver createLocalDriver(String browserName) {
        WebDriver driver;
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            default:
                driver = null;
                break;
        }
        return driver;
    }

    /**
     * Creates a WebDriver instance for the specified browser name and remote execution mode.
     *
     * @param browserName The name of the browser to create a WebDriver instance for.
     * @return A WebDriver instance for the specified browser name and remote execution mode.
     * @throws MalformedURLException If the URL for the remote WebDriver server is malformed.
     */
    private static WebDriver createRemoteDriver(String browserName, String version) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browserName);
        capabilities.setVersion(version);
        URL url = new URL("http://127.0.0.1:4444/wd/hub");
        return new RemoteWebDriver(url, capabilities);
    }

}

