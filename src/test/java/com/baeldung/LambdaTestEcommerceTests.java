package com.baeldung;

import com.baeldung.pages.HomePage;
import com.baeldung.pages.SearchResultPage;
import org.testng.annotations.Test;

public class LambdaTestEcommerceTests extends BaseTest {
    @Test
    public void whenUserSearchesForAProduct_ThenSearchResultsShouldBeDisplayed () {
        String productName = "iPhone";

        driver.get ("https://ecommerce-playground.lambdatest.io/");
        HomePage homePage = new HomePage (driver);
        SearchResultPage searchResultPage = homePage.searchProduct (productName);
        searchResultPage.verifySearchResultPageHeader (productName);
        this.status = "passed";
    }
}
