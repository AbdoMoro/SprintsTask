package search;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class searchTests extends BaseTests {
    @Test
    public void searchItem(){
        String searchString = "msi";
        homePage.navigationBar.setSearchBox(searchString);
        var productList = homePage.navigationBar.clickSearchButton();
        Assert.assertTrue(productList.resultsContainSearchWord(searchString));
    }
}

