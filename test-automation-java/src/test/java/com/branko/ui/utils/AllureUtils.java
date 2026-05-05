package com.branko.ui.utils;

import com.branko.ui.driver.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class AllureUtils {
    public static void attachScreenshot(String name) {
        byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
    }

    public static void step(String stepName, Runnable action) {
        Allure.step(stepName, () -> {
            try {
                action.run();
            } catch (Exception e) {
                attachScreenshot("Failure - " + stepName);
                throw e;
            }
        });
    }
}
