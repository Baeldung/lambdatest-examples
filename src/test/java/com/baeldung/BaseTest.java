package com.baeldung;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected RemoteWebDriver driver;
    protected   String          status = "failed";

    @BeforeTest
    public void setup() {
        String userName = System.getenv("LT_USERNAME") == null ? "LT_USERNAME" : System.getenv("LT_USERNAME");
        String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "LT_ACCESS_KEY" : System.getenv("LT_ACCESS_KEY");
        String gridUrl = "@hub.lambdatest.com/wd/hub";
        try {
            this.driver = new RemoteWebDriver(new URL ("http://" + userName + ":" + accessKey + gridUrl), getChromeOptions());
        } catch (MalformedURLException e) {
            System.out.println("Could not start the remote session on LambdaTest cloud grid");
        }
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public ChromeOptions getChromeOptions() {
        var browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("project", "LambdaTest e-commerce website automation");
        ltOptions.put("build", "LambdaTest e-commerceV1.0.0");
        ltOptions.put("name", "Homepage search product test");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");

        browserOptions.setCapability("LT:Options", ltOptions);

        return browserOptions;
    }

    @AfterTest
    public void tearDown() {
        this.driver.executeScript("lambda-status=" + this.status);
        this.driver.quit();
    }
}
