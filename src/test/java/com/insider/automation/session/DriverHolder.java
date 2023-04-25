package com.insider.automation.session;

import framework.driver.config.InsiderDriver;
import org.openqa.selenium.WebDriver;

public class DriverHolder {
    public DriverHolder() {

    }
    public static final WebDriver driver = InsiderDriver.getInstance().getDriver();
    private static class LazyHolder {
        static final DriverHolder INSTANCE = new DriverHolder();
    }
    public static DriverHolder getInstance() {
        return DriverHolder.LazyHolder.INSTANCE;
    }
    public WebDriver getDriver() {
        return driver;
    }

}

