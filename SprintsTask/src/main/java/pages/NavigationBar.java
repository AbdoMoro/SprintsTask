package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Utils;

public class NavigationBar {
    WebDriver driver;
    By searchBox = By.xpath("//input[@id=\"search_input\"]");
    By searchButton = By.xpath("//button[contains(@class, \"search\")]");
    By comparisonButton = By.xpath("//*[contains(@id, \"compared_products\")]/a");

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }

    public void setSearchBox(String searchWord) {
        driver.findElement(searchBox).sendKeys(searchWord);
    }

    public ProductsPage clickSearchButton(){
        driver.findElement(searchButton).click();
        return new ProductsPage(driver);
    }

    public ComparisonPage clickComparisonButton(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Utils.wait(driver, 2).until(ExpectedConditions.elementToBeClickable(comparisonButton));
        driver.findElement(comparisonButton).click();
        return new ComparisonPage(driver);
    }
}
