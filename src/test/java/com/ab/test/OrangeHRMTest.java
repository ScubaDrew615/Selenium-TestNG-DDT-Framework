package com.ab.test;

import com.ab.pages.OrangeHRMAuthPage;
import org.testng.annotations.Test;

import java.util.Map;

public class OrangeHRMTest extends BaseTest {

    @Test
    public void loginLogoutTest(Map<String, String> data) throws Exception {
        new OrangeHRMAuthPage()
                .sendUsername(data.get("username"))
                .sendPassword(data.get("password"))
                .clickLogin()
                .clickDropdown()
                .clickLogout()
                .getTitle();
    }

    @Test
    public void failedLoginLogoutTest(Map<String, String> data) throws Exception {
        new OrangeHRMAuthPage()
                .sendUsername(data.get("username"))
                .sendPassword(data.get("password"))
                .clickLogin()
                .clickDropdown()
                .clickLogout()
                .getTitle();
    }

}
