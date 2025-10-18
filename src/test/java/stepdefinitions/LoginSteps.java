package stepdefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
// import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginSteps {
    // @Before
    // public void setup() {
    //     WebDriverManager.chromedriver().setup();
    // }
    
    WebDriver driver;
    LoginPage loginPage;

     @Given("user is on login page")
    public void user_is_on_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @Then("user should see products page")
    public void user_should_see_products_page() {
        assertTrue(loginPage.isOnProductsPage());
        driver.quit();
    }
}
