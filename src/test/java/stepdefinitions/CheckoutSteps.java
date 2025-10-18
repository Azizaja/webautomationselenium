package stepdefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import utils.ConfigReader;

public class CheckoutSteps {
WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Given("user is logged in")
    public void user_is_logged_in() {
        // WebDriverManager.chromedriver().setup();
        // If WebDriverManager is not on the classpath, ensure chromedriver is available on the system PATH
        // or set the webdriver.chrome.driver system property to the chromedriver binary location.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("BASE_URL"));
        loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.get("USERNAME"), ConfigReader.get("PASSWORD"));

        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @When("user adds a product to the cart")
    public void user_adds_a_product_to_the_cart() {
        productPage.addProductToCart();
        productPage.goToCart();
    }

    @When("proceeds to checkout")
    public void proceeds_to_checkout() {
        cartPage.clickCheckout();
    }

    @When("enters valid shipping information")
    public void enters_valid_shipping_information() {
        checkoutPage.enterShippingInfo("Aziz", "Setiawan", "12345");
    }

    @When("completes the purchase")
    public void completes_the_purchase() {
        checkoutPage.finishCheckout();
    }

    @Then("user should see confirmation message")
    public void user_should_see_confirmation_message() {
        assertTrue(checkoutPage.isOrderConfirmed());
        driver.quit();
    }
}
