package com.ab.factories;

import com.ab.constants.FrameworkConstants;
import com.ab.driver.DriverManager;
import com.ab.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * <p>The ExplicitWaitFactory class is used to create explicit waits for elements in a test automation framework.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */
public final class ExplicitWaitFactory {

    private ExplicitWaitFactory() {
    }

    /**
     * Returns the element after an explicit wait.
     *
     * @param strategy the wait strategy to use
     * @param locator  the locator of the element to wait for
     * @return the element after an explicit wait
     */
    public static WebElement explicitlyWait(WaitStrategy strategy, By locator) {
        WebElement element = null;
        if (strategy == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } else if (strategy == WaitStrategy.VISIBLE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } else if (strategy == WaitStrategy.PRESENCE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        } else if (strategy == WaitStrategy.NONE) {
            element = DriverManager.getDriver().findElement(locator);
        }
        return element;
    }

}
