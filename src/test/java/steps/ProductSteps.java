package steps;

import org.testng.Assert;

import base.DriverFactory;
import base.WaitHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductSteps {

    private String addedProduct;

    @Given("I open the SauceDemo app")
    public void i_open_the_sauce_demo_app() {
        new LoginPage().open();
        WaitHelper.waitForPageToLoad(DriverFactory.getDriver());
    }

    @When("I login with {string} and {string}")
    public void i_login_with_and(String user, String pass) {
        LoginPage login = new LoginPage();
        login.login(user, pass);
        Assert.assertTrue(login.isLoginSuccessful(), "Login failed!");
    }

    @When("I search and add a product that matches the keyword")
    public void i_search_and_add_a_product_that_matches_the_keyword() {
        String keyword = System.getProperty("productName", "Sauce");
        ProductsPage products = new ProductsPage();
        addedProduct = products.addFirstMatchingProduct(keyword);
        if (addedProduct == null) {
            System.out.println("Product not available");
            DriverFactory.getDriver().quit();
            Assert.fail("No product matched keyword: " + keyword);
        }
        products.openCart();
    }

    @Then("I should see the product in the cart and print its name")
    public void i_should_see_the_product_in_the_cart_and_print_its_name() {
        CartPage cart = new CartPage();
        Assert.assertTrue(cart.hasProduct(addedProduct), "Product not found in cart!");
        String name = cart.getFirstItemName();
        System.out.println("Product in cart: " + name);
    }
}