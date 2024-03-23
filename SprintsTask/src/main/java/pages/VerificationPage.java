package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerificationPage {
    WebDriver driver;
    public NavigationBar navigationBar;
    By pageHeader = By.xpath("//h1[contains(text(), \"OTP\")]");

    public VerificationPage(WebDriver driver) {
        this.driver = driver;
        navigationBar = new NavigationBar(driver);
    }

    public String getHeaderText(){
        return driver.findElement(pageHeader).getText();
    }
}
