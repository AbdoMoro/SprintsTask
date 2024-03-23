package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage {
    WebDriver driver;
    public NavigationBar navigationBar;
    By addToCartbutton = By.xpath("//button[contains(@id, \"button_cart\")]");
    By popupCheckoutButton = By.xpath("//div[@class = \"ty-float-right\"]/a[contains(@href, \"checkout\")]");

    public ItemPage(WebDriver driver) {
        this.driver = driver;
        navigationBar = new NavigationBar(driver);
    }

    public void clickAddToCartbutton(){
        driver.findElement(addToCartbutton).click();
    }

    public CheckoutPage clickPopupCheckoutButton(){
        driver.findElement(popupCheckoutButton).click();
        return new CheckoutPage(driver);
    }


}
