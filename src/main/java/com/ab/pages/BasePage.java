package com.ab.pages;

import com.ab.driver.DriverManager;
import com.ab.enums.WaitStrategy;
import com.ab.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;

public class BasePage {

    protected void click(By locator, WaitStrategy strategy) {
        ExplicitWaitFactory.explicitlyWait(WaitStrategy.CLICKABLE, locator).click();


    }

    protected void sendKeys(By locator, String value, WaitStrategy strategy) {
        ExplicitWaitFactory.explicitlyWait(WaitStrategy.PRESENCE, locator).sendKeys(value);

    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }


}
