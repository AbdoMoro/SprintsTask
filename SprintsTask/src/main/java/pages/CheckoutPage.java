package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    public NavigationBar navigationBar;
    By phoneTextBox = By.id("litecheckout_phone");
    By addressTextBox = By.id("litecheckout_s_address");
    By acceptTermsCheckBox = By.xpath("//*[contains(@id, \"id_accept_terms\")]");
    By placeOrderButton = By.id("litecheckout_place_order");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        navigationBar = new NavigationBar(driver);
    }

    public void setPhoneTextBox(String phone) {
        driver.findElement(phoneTextBox).sendKeys(phone);
    }

    public void setAddressTextBox(String address) {
        Utils.scrollTillVisible(driver, addressTextBox);
        driver.findElement(addressTextBox).sendKeys(address);
    }

    public void clickAcceptTermsCheckBox(){
        Utils.wait(driver, 1).until(ExpectedConditions.elementToBeClickable(acceptTermsCheckBox));
        driver.findElement(acceptTermsCheckBox).click();
    }

    public VerificationPage clickPlaceOrderButton(){
        driver.findElement(placeOrderButton).click();
        //while(driver.getCurrentUrl() != "https://egyptlaptop.com/index.php?dispatch=otp_verify_register.verify_user");
        return new VerificationPage(driver);
    }
}
