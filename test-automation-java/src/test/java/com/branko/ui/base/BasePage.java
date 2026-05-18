package com.branko.ui.base;

import com.branko.ui.enums.WaitStrategy;
import com.branko.shared.AllureUtils;
import com.branko.ui.utils.ExplicitWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    public void click(By locator, String elementName) {
        AllureUtils.step(("Click on " + elementName), () -> {
            ExplicitWait.perform(WaitStrategy.CLICKABLE, locator).click();
        });
    }
    public void type(By locator, String text, String elementName) {
        typeInternal(locator, text, elementName, false);
    }

    public void typeSecure(By locator, String text, String elementName) {
        typeInternal(locator, text, elementName, true);
    }

    private void typeInternal(By locator, String text, String elementName, boolean mask) {
        String valueForLog = mask ? "****" : text;

        AllureUtils.step(
                String.format("Type '%s' into %s", valueForLog, elementName),
                () -> {
                    WebElement element = ExplicitWait.perform(WaitStrategy.VISIBLE, locator);
                    element.clear();
                    element.sendKeys(text);
                }
        );
    }
}
