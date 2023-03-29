package com.ab.test;
/*
                                            EXAMPLE TEST FORMAT
 */
import com.ab.annotations.FrameworkAnnotation;
import com.ab.enums.SuiteType;
import com.ab.pages.OrangeHRMAuthPage;
import org.testng.annotations.Test;

import java.util.Map;

public class OrangeHRMTest extends BaseTest {

    @FrameworkAnnotation(author = {"Andrew", "Stephen"},
            suites = {SuiteType.REGRESSION, SuiteType.MINI_REGRESSION})
    @Test
    public void loginLogoutTest(Map<String, String> data)  {
        new OrangeHRMAuthPage()
                .sendUsername(data.get("username"))
                .sendPassword(data.get("password"))
                .clickLogin()
                .clickDropdown()
                .clickLogout()
                .getTitle();
    }

    @FrameworkAnnotation(author = {"Andrew", "Stephen"},
            suites = {SuiteType.REGRESSION, SuiteType.SMOKE})
    @Test
    public void failedLoginLogoutTest(Map<String, String> data) {
        new OrangeHRMAuthPage()
                .sendUsername(data.get("username"))
                .sendPassword(data.get("password"))
                .clickLogin()
                .clickDropdown()
                .clickLogout()
                .getTitle();
    }

}
