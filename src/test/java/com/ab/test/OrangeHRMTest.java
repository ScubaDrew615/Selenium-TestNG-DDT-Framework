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

}
