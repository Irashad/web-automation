package com.insider.automation.steps;

import com.insider.automation.session.DriverHolder;
import framework.Browsers;
import framework.driver.config.InsiderDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Hooks {

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


    @BeforeSuite
    public void setUp() {
        setBrowser();
        new DriverHolder();
        DriverHolder.getInstance().getDriver().manage().window().maximize();

    }

    @AfterSuite
    public void endUp() {
        DriverHolder.getInstance().getDriver().quit();
    }

}
