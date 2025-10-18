package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(id = "postal-code")
    WebElement postalCodeInput;

    @FindBy(id = "continue")
    WebElement continueBtn;

    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(css = ".complete-header")
    WebElement confirmationMessage;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterShippingInfo(String firstName, String lastName, String postalCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);
        continueBtn.click();
    }

    public void finishCheckout() {
        finishBtn.click();
    }

    public boolean isOrderConfirmed() {
        return confirmationMessage.getText().equals("Thank you for your order!");
    }

}
