package com.branko.ui.pom;

import com.branko.ui.base.BasePage;
import com.branko.ui.utils.Assertions;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class CheckoutOverviewPage extends BasePage {

    private static final By PAGE_TITLE = By.cssSelector("[data-test='title']");
    private By ITEM_NAME(String itemName){
        return By.xpath(String.format(
                "//*[@data-test='inventory-item-name' and normalize-space()='%s']",
                itemName
        ));
    }

    private By ORDER_INFO_VALUE(String orderInfo) {
        return By.cssSelector(String.format("[data-test='%s-value']",orderInfo));
    }
    private static final By FINISH_BUTTON = By.cssSelector("[data-test='finish']");

    private static final By TOTAL = By.cssSelector("[data-test='total-label']");
    private static final String PAYMENT_INFO = "payment-info";
    private static final String SHIPPING_INFO = "shipping-info";

    public CheckoutOverviewPage verifyUserIsOnCheckoutStepTwoPage(){
        Assertions.verifyElementIsDisplayed(PAGE_TITLE,"Checkout overview");
        Assertions.verifyTextIsEqual(PAGE_TITLE, "Checkout: Overview");
        return this;
    }
    public CheckoutOverviewPage verifyProduct(String itemName){
        Assertions.verifyElementIsDisplayed(ITEM_NAME(itemName),"Product name:" + itemName);
        return this;
    }
    public CheckoutOverviewPage verifyOrderDetails(String paymentType, String shippingType, String total){
        SoftAssert softAssert = new SoftAssert();
        Assertions.verifyTextContains(ORDER_INFO_VALUE(PAYMENT_INFO), paymentType, softAssert);
        Assertions.verifyTextContains(ORDER_INFO_VALUE(SHIPPING_INFO), shippingType, softAssert);
        Assertions.verifyTextContains(TOTAL, total, softAssert);
        softAssert.assertAll();
        return this;
    }
    public CheckoutCompletePage completeOrder(){
        click(FINISH_BUTTON,"Finish button");
        return new CheckoutCompletePage();
    }
}
