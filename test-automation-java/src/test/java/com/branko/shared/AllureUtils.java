package com.branko.shared;

import com.branko.ui.driver.DriverManager;
import com.google.gson.GsonBuilder;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.util.function.Supplier;

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
                try {
                    attachScreenshot("Failure - " + stepName);
                } catch (Exception ignored) {
                }
                throw e;
            }
        });
    }

    public static <T> T step(String stepName, Supplier<T> action) {
        return Allure.step(stepName, () -> {
            try {
                return action.get();
            } catch (Exception e) {
                try {
                    attachScreenshot("Failure - " + stepName);
                } catch (Exception ignored) {
                }
                throw e;
            }
        });
    }

    public static void attachJson(String name, Object json) {

        String content;

        if (json instanceof String) {
            content = json.toString();
        } else {
            content = new GsonBuilder()
                    .setPrettyPrinting()
                    .create()
                    .toJson(json);
        }

        content = maskSensitiveData(content);

        Allure.addAttachment(
                name,
                "application/json",
                content,
                ".json"
        );
    }

    private static String maskSensitiveData(String content) {

        String[] sensitiveFields = {
                "password",
                "access_token",
        };

        for (String field : sensitiveFields) {

            content = content.replaceAll(
                    "(\"" + field + "\"\\s*:\\s*\")(.*?)(\")",
                    "$1****$3"
            );
        }
        return content;
    }
}
