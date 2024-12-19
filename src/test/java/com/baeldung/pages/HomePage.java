package com.baeldung.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePage {

    private RemoteWebDriver driver;

    public HomePage (final RemoteWebDriver driver) {
        this.driver = driver;
    }

    public SearchResultPage searchProduct(String productName) {
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys(productName);
        WebElement searchBtn = driver.findElement(By.cssSelector("button.type-text"));
        searchBtn.click();
        return new SearchResultPage (driver);
    }

}