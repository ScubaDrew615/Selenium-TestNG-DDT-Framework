package com.ab.test;

import com.ab.pages.OrangeHRMAuthPage;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest{

    @Test
    public void loginLogoutTest() throws Exception {
        new OrangeHRMAuthPage().sendUsername("Admin").sendPassword("admin123").clickLogin()
                .clickDropdown().clickLogout()
                .getTitle();
    }
    @Test
    public void failedLoginLogoutTest() throws Exception {
        new OrangeHRMAuthPage().sendUsername("Admin").sendPassword("admin13").clickLogin()
                .clickDropdown().clickLogout()
                .getTitle();
    }

}
