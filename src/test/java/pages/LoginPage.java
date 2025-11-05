package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;

public class LoginPage {
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By productsTitle = By.xpath("//span[text()='Products']");
    private final WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));

    public void open() {
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
    }

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
        DriverFactory.getDriver().findElement(password).sendKeys(pass);
        DriverFactory.getDriver().findElement(loginButton).click();
    }

    public boolean isLoginSuccessful() {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(productsTitle, "Products"));
    }
    
}