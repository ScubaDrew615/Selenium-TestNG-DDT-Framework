package com.ab.test;

import com.ab.pages.OrangeHRMAuthPage;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest{

    @Test
    public void loginLogoutTest(){
        new OrangeHRMAuthPage().sendUsername("Admin").sendPassword("admin123").clickLogin()
                .clickDropdown().clickLogout()
                .getTitle();
    }

}
