package com.insider.automation.steps;

import com.insider.automation.pageobjects.web.HomePage;
import com.insider.automation.session.DriverHolder;
import com.insider.automation.session.PageObjectHolder;
import framework.driver.config.InsiderDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class Hooks {
    private WebDriver driver;



    @BeforeMethod
    public void setUp(ITestContext context) {

        String browser = context.getCurrentXmlTest().getParameter("browser");
        WebDriverManager.firefoxdriver().setup();
        InsiderDriver.driver = new FirefoxDriver();
        new DriverHolder();
        DriverHolder.getInstance().getDriver().manage().window().maximize();
    }

    @AfterSuite
    public void endUp(){
        DriverHolder.getInstance().getDriver().quit();
    }

}
