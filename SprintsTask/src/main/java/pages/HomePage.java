package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    public NavigationBar navigationBar;
    By productCards = By.className("product-title");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        navigationBar = new NavigationBar(driver);
    }

    public ItemPage clickFirstProductCard(){
        driver.findElement(productCards).click();
        return new ItemPage(driver);
    }


}
