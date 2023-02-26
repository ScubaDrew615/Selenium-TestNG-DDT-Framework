package com.ab.test;

import com.ab.driver.DriverManager;
import com.ab.utilities.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class HomepageTest extends BaseTest {
    private HomepageTest() {
    }

    @Test
    public void test3() throws Exception {

        DriverManager.getDriver().get(PropertiesReader.getHashMapValues("url"));
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Andrew Bakheet", Keys.ENTER);

    }
}
