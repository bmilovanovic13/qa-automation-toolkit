package com.branko.ui.pom.practicesoftwaretesting;

import com.branko.shared.Config;
import com.branko.ui.base.BasePage;
import com.branko.ui.driver.DriverManager;
import org.openqa.selenium.By;

public class ProductsPage extends BasePage {

    public static ProductsPage open(){
        DriverManager.getDriver().get(Config.get("baseUrlPracticeTesting"));
        return new ProductsPage();
    }

    public ProductDetailsPage selectProduct(String productName){
        click(By.xpath(String.format("//img[@alt='%s']", productName)),"Product name");
        return new ProductDetailsPage();
    }
}
