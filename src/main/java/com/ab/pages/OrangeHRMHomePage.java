package com.ab.pages;

import org.openqa.selenium.By;

/*
                                            EXAMPLE HOMEPAGE FORMAT
 */
public class OrangeHRMHomePage extends BasePage {

    private final By dropDown = By.cssSelector(".oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon");
    private final By logoutButton = By.xpath("//a[normalize-space()='Abmelden']");

    public OrangeHRMHomePage clickDropdown() {
        click(dropDown, "Dropdown button");
        return this;
    }

    public OrangeHRMAuthPage clickLogout() {
        click(logoutButton, "Logout button");
        return new OrangeHRMAuthPage();
    }

}
