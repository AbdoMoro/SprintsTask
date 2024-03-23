package placeOrder;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class placeOrderTests extends BaseTests {
    @Test
    public void placeOrderUnsubscribedUser(){
        String searchString = "msi";
        homePage.navigationBar.setSearchBox(searchString);
        var productsPage = homePage.navigationBar.clickSearchButton();
        var itemPage = productsPage.clickFirstProductCard();
        itemPage.clickAddToCartbutton();
        var checkoutPage = itemPage.clickPopupCheckoutButton();
        checkoutPage.setPhoneTextBox("01122334455");
        checkoutPage.setAddressTextBox("Cairo");
        checkoutPage.clickAcceptTermsCheckBox();
        var verificationPage = checkoutPage.clickPlaceOrderButton();
        Assert.assertEquals(verificationPage.getHeaderText(), "OTP Verification");
    }
}
