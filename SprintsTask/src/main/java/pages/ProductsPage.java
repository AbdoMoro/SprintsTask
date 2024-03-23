package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Utils;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage {
    WebDriver driver;
    public NavigationBar navigationBar;
    String nthProductCard = "//*[@class = \"ty-column4\"][%d]";
    By productTitle = By.className("product-title");
    By addToCompareListButton = By.xpath("//a[contains(@title, \"comparison list\")]");


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        navigationBar = new NavigationBar(driver);
    }

    public ItemPage clickFirstProductCard(){
        driver.findElement(productTitle).click();
        return new ItemPage(driver);
    }

    List<String> getResultsTitles(){
        return driver.findElements(productTitle).stream().map(element -> element.getText().toLowerCase()).collect(Collectors.toList());
    }

    public boolean resultsContainSearchWord(String searchWord){
        List<String> results = getResultsTitles();
        for (String str : results){
            if(str.contains(searchWord))
                return true;
        }
        return false;
    }

    public String clickAddToCompareListButton(int index){
        By productCard = By.xpath(String.format(nthProductCard, index));
        WebElement element = driver.findElement(productCard);
//        if(!element.isDisplayed()){
//            Utils.scrollTillVisible(driver, productCard);
//        }
        Utils.wait(driver, 1).until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        element.findElement(addToCompareListButton).click();
        return element.findElement(productTitle).getText();
    }
}
