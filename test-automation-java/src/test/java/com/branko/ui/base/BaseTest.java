package com.branko.ui.base;

import com.branko.ui.config.Config;
import com.branko.ui.driver.Browser;
import com.branko.ui.driver.DriverFactory;
import com.branko.ui.driver.DriverManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        boolean headless = Config.getBoolean("headless");
        Browser browser = Browser.valueOf(Config.get("browser").toUpperCase());
        DriverFactory.initDriver(browser, headless);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        DriverManager.quitDriver();
    }
}
