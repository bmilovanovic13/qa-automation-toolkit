package com.branko.ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static WebDriver createDriver(Browser browser, Boolean headless){
        WebDriver driver;

        switch (browser) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();
                if (headless) {
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                }

                options.addArguments("--incognito");

                driver = new ChromeDriver(options);
            }

            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();

                FirefoxOptions options = new FirefoxOptions();
                if (headless){
                    options.addArguments("--headless");
                    options.addArguments("--width=1920");
                    options.addArguments("--height=1080");
                }
                driver = new FirefoxDriver(options);
            }
            default ->
                throw new IllegalArgumentException("Browser not supported:" + browser);
        }
        return driver;
    }

    public static void initDriver(Browser browser, Boolean headless){
        WebDriver driver = createDriver(browser, headless);

        if (!headless) {
            driver.manage().window().maximize();
        }

        DriverManager.setDriver(driver);
    }
}
