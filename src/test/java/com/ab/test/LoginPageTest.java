package com.ab.test;

import com.ab.driver.DriverManager;
import com.ab.utilities.PropertiesReader;
import org.testng.annotations.Test;

public final class LoginPageTest extends BaseTest {

    private LoginPageTest() {
    }

//    @Test
//    public void test1() throws Exception {
//        DriverManager.getDriver().get(PropertiesReader.getHashTableValues("url"));
//        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Andrew Bakheet", Keys.ENTER);
//    }

    @Test
    public void test2() throws Exception {
        DriverManager.getDriver().get(PropertiesReader.getHashTableValues("url"));

    }

}
