package com.ab.pages;

import com.ab.driver.DriverManager;
import com.ab.enums.WaitStrategy;
import com.ab.factories.ExplicitWaitFactory;
import com.ab.reports.ExtentLogger;
import org.openqa.selenium.By;

public class BasePage {

    protected void click(By locator, WaitStrategy strategy, String elementName) {
        ExplicitWaitFactory.explicitlyWait(WaitStrategy.CLICKABLE, locator).click();
        ExtentLogger.pass(elementName + " is clicked");


    }

    protected void sendKeys(By locator, String value, WaitStrategy strategy, String elementName) throws Exception {
        ExplicitWaitFactory.explicitlyWait(WaitStrategy.PRESENCE, locator)
                .sendKeys(value);
        ExtentLogger.pass("(" + value + ") is entered successfully into \"" + elementName + "\"");


    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }


}
