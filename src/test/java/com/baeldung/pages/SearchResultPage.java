package com.baeldung.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchResultPage {

    private final RemoteWebDriver driver;

    public SearchResultPage (RemoteWebDriver driver) {
        this.driver = driver;
    }

    public void verifySearchResultPageHeader (String productName) {
        String pageHeader = driver.findElement (By.tagName ("h1"))
            .getText ();
        assertEquals (pageHeader, "Search - " + productName);
    }
}