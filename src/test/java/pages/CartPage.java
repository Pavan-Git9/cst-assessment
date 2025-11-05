package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;
public class CartPage {
    private final By cartItemName = By.className("inventory_item_name");
    private final WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
    public String getFirstItemName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemName)).getText();
    }
    public boolean hasProduct(String expected) {
        String actual = getFirstItemName();
        return actual.equalsIgnoreCase(expected);
    }
}