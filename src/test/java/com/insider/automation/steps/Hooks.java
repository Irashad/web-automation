package com.insider.automation.steps;

import com.insider.automation.session.DriverHolder;
import framework.Browsers;
import framework.driver.config.InsiderDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class Hooks {
    private WebDriver driver;

    private void setBrowser() {
        String envBrowser = System.getenv("browser");

        switch (Browsers.get(envBrowser)) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                InsiderDriver.driver = new ChromeDriver(options);
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                InsiderDriver.driver = new FirefoxDriver();
                break;
        }
    }

    @BeforeMethod
    public void setUp() {
        setBrowser();
        new DriverHolder();
        DriverHolder.getInstance().getDriver().manage().window().maximize();
    }

    @AfterSuite
    public void endUp() {
        //   DriverHolder.getInstance().getDriver().quit();
    }

}
