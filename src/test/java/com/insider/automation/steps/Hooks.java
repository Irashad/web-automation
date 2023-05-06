package com.insider.automation.steps;

import com.insider.automation.session.DriverHolder;
import framework.driver.config.InsiderDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Hooks {

    @BeforeSuite(groups = "Setup")
    public void setUp() {
        InsiderDriver.getInstance().setBrowser();
        DriverHolder.getInstance().getDriver().manage().window().maximize();
    }

    @AfterSuite(groups = "Setup")
    public void endUp(){
        DriverHolder.getInstance().getDriver().quit();
    }

}
