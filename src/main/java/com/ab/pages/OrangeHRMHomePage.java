package com.ab.pages;

import com.ab.enums.WaitStrategy;
import org.openqa.selenium.By;

public class OrangeHRMHomePage extends BasePage {

    private final By dropDown = By.cssSelector(".oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon");
    private final By logoutButton = By.xpath("//a[normalize-space()='Logout']");

    public OrangeHRMHomePage clickDropdown() {
        click(dropDown, WaitStrategy.CLICKABLE, "Dropdown button");
        return this;
    }

    public OrangeHRMAuthPage clickLogout() {
        click(dropDown, WaitStrategy.CLICKABLE, "Logout button");
        return new OrangeHRMAuthPage();
    }

}
