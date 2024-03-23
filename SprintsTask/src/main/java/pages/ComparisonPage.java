package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ComparisonPage {
    WebDriver driver;
    public NavigationBar navigationBar;
    By comparedProduct = By.xpath("//*[@class = \"ty-compare-products__name\"]");
    By comparisonRow = By.xpath("//tr[@class=\"ty-compare-feature__row\"]");
    By comparisonColumn = By.xpath("//*[contains(@class, \"ty-compare-feature_item_size\")]");
    By similarOnlyButton = By.xpath("//a[text() = \"Similar only\"]");

    public ComparisonPage(WebDriver driver) {
        this.driver = driver;
        navigationBar = new NavigationBar(driver);
    }

    public List<String> getComparedProductsTitles(){
        return driver.findElements(comparedProduct).stream().map(element -> element.getText()).collect(Collectors.toList());
    }

    public void clickSimilarOnlyButton(){
        driver.findElement(similarOnlyButton).click();
    }

    public boolean allIsSimilar(){
        List<WebElement> rows = driver.findElements(comparisonRow);
        if (rows.size() == 0)
            return true;
        for (WebElement row: rows) {
            List<WebElement> cols = row.findElements(comparisonColumn);
            String text = cols.get(0).getText();
            for(int i = 1; i<cols.size();i++){
                if(cols.get(i).getText() != text)
                    return false;
            }
        }
        return true;
    }
}
