package com.insider.automation.steps;

import com.insider.automation.pageobjects.web.HomePage;
import com.insider.automation.session.DriverHolder;
import com.insider.automation.session.PageObjectHolder;
import framework.driver.config.InsiderDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(ITestContext context) {
        String browser = context.getCurrentXmlTest().getParameter("browser");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        InsiderDriver.driver = driver;
        new DriverHolder();
        DriverHolder.getInstance().getDriver().get("https://useinsider.com/");

    }

}
