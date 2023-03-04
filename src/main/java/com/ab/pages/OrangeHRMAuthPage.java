package com.ab.pages;

import com.ab.reports.ExtentReportLogger;
import org.openqa.selenium.By;

public class OrangeHRMAuthPage extends BasePage {

    private final By usernameTextbox = By.cssSelector("input[placeholder='Username']");
    private final By passwordTextbox = By.cssSelector("input[placeholder='Password']");
    private final By loginButton = By.cssSelector("button[type='submit']");

    public OrangeHRMAuthPage sendUsername(String username) throws Exception {
        sendKeys(usernameTextbox, username, "Username");
        return this;
    }

    public OrangeHRMAuthPage sendPassword(String password) throws Exception {
        sendKeys(passwordTextbox, password, "Password");
        return this;
    }

    public OrangeHRMHomePage clickLogin() {
        click(loginButton, "Login button");
        return new OrangeHRMHomePage();
    }
    public String getTitle(){
        ExtentReportLogger.pass("Title received");
        return getPageTitle();

    }
}
