package com.insider.automation.steps;

import com.insider.automation.session.DriverHolder;
import framework.driver.config.InsiderDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Hooks {

    @BeforeSuite
    public void setUp() {
        InsiderDriver.getInstance().setBrowser();
        DriverHolder.getInstance().getDriver().manage().window().maximize();
    }

    @AfterSuite
    public void endUp() {
        DriverHolder.getInstance().getDriver().quit();
    }

}
