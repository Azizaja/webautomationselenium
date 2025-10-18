package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartBtn;

    @FindBy(className = "shopping_cart_link")
    WebElement cartLink;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart() {
        addToCartBtn.click();
    }

    public void goToCart() {
        cartLink.click();
    }
}
