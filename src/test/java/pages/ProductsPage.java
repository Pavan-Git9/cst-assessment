package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;

public class ProductsPage {
    private final By productNames = By.className("inventory_item_name");
    private final By addToCartButtons = By.xpath("//button[contains(text(),'Add to cart')]");
    private final By cartIcon = By.className("shopping_cart_link");
    private final WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));

    public String addFirstMatchingProduct(String keyword) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productNames));
        List<WebElement> products = DriverFactory.getDriver().findElements(productNames);
        List<WebElement> addBtns = DriverFactory.getDriver().findElements(addToCartButtons);

        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            if (name.toLowerCase().contains(keyword.toLowerCase())) {
                addBtns.get(i).click();
                return name;
            }
        }
        return null;
    }

    public void openCart() {
        DriverFactory.getDriver().findElement(cartIcon).click();
    }
}