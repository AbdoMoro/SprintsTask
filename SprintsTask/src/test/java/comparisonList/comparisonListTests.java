package comparisonList;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class comparisonListTests extends BaseTests {
    @Test
    public void check(){
        String searchString = "msi";
        homePage.navigationBar.setSearchBox(searchString);
        var productsPage = homePage.navigationBar.clickSearchButton();
        String product1 = productsPage.clickAddToCompareListButton(1);
        String product2 = productsPage.clickAddToCompareListButton(2);
        var comparisonPage = productsPage.navigationBar.clickComparisonButton();
        List<String> addedProducts = comparisonPage.getComparedProductsTitles();
        Assert.assertTrue(addedProducts.contains(product1));
        Assert.assertTrue(addedProducts.contains(product2));
        comparisonPage.clickSimilarOnlyButton();
        Assert.assertTrue(comparisonPage.allIsSimilar());

    }
}
