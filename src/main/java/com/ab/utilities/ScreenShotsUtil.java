package com.ab.utilities;

import com.ab.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
/**
 * <p>The ScreenShotsUtil class contains a utility method for capturing screenshots in Base64 format.
 * It contains a private constructor to prevent object instantiation and a static method to capture a screenshot in Base64 format.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */
public final class ScreenShotsUtil {

    /**
     * Private constructor to prevent object instantiation
     */
    private ScreenShotsUtil() {
    }

    /**
     * This static method captures a screenshot in Base64 format.
     *
     * @return The screenshot in Base64 format
     */
    public static String getBase64Image() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
