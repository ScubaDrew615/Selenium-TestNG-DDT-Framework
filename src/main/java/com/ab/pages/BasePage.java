package com.ab.pages;

import com.ab.driver.DriverManager;
import com.ab.enums.WaitStrategy;
import com.ab.factories.ExplicitWaitFactory;
import com.ab.listeners.reports.ExtentReportLogger;
import org.openqa.selenium.By;

/**
 * <p>The BasePage class is the parent class of all the page classes.
 * It contains the common page actions that are used across all pages.
 * This class uses ExplicitWaitFactory class to wait for elements and ExtentReportLogger class to log the actions in the extent report.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */
public class BasePage {

    /**
     * This method clicks on the element specified by the locator.
     * It logs the action in the extent report using ExtentReportLogger class.
     *
     * @param locator The locator of the element to be clicked
     * @param elementName The name of the element to be clicked (used in the extent report)
     */
    protected void click(By locator, String elementName) {
        ExplicitWaitFactory.explicitlyWait(WaitStrategy.CLICKABLE, locator).click();
        ExtentReportLogger.pass(elementName + " is clicked");
    }

    /**
     * This method enters the specified value into the element specified by the locator.
     * It logs the action in the extent report using ExtentReportLogger class.
     *
     * @param locator The locator of the element to which the value is to be entered
     * @param value The value to be entered into the element
     * @param elementName The name of the element into which the value is to be entered (used in the extent report)
     */
    protected void sendKeys(By locator, String value, String elementName)  {
        ExplicitWaitFactory.explicitlyWait(WaitStrategy.PRESENCE, locator)
                .sendKeys(value);
        ExtentReportLogger.pass("(" + value + ") is entered successfully into \"" + elementName + "\"");
    }

    /**
     * This method returns the title of the current web page.
     *
     * @return The title of the current web page
     */
    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

}
