package com.ab.pages;

import com.ab.enums.WaitStrategy;
import org.openqa.selenium.By;

public class OrangeHRMAuthPage extends BasePage {

    private final By usernameTextbox = By.cssSelector("input[placeholder='Username']");
    private final By passwordTextbox = By.cssSelector("input[placeholder='Password']");
    private final By loginButton = By.cssSelector("button[type='submit']");

    public OrangeHRMAuthPage sendUsername(String username) {
        sendKeys(usernameTextbox, username, WaitStrategy.PRESENCE);
        return this;
    }

    public OrangeHRMAuthPage sendPassword(String password) {
        sendKeys(passwordTextbox, password, WaitStrategy.PRESENCE);
        return this;
    }

    public OrangeHRMHomePage clickLogin() {
        click(loginButton, WaitStrategy.CLICKABLE);
        return new OrangeHRMHomePage();
    }
    public String getTitle(){
        return getPageTitle();
    }
}
