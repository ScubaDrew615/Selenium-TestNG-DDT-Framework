package com.ab.pages;

import com.ab.driver.DriverManager;
import com.ab.enums.WaitStrategy;
import com.ab.factories.ExplicitWaitFactory;
import com.ab.reports.ExtentReportLogger;
import org.openqa.selenium.By;

public class BasePage {

    protected void click(By locator, String elementName) {
        ExplicitWaitFactory.explicitlyWait(WaitStrategy.CLICKABLE, locator).click();
        ExtentReportLogger.pass(elementName + " is clicked");


    }

    protected void sendKeys(By locator, String value, String elementName)  {
        ExplicitWaitFactory.explicitlyWait(WaitStrategy.PRESENCE, locator)
                .sendKeys(value);
        ExtentReportLogger.pass("(" + value + ") is entered successfully into \"" + elementName + "\"");


    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }


}
