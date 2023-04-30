package com.insider.automation.pageobjects.components.base;

import com.insider.automation.session.DriverHolder;
import framework.locators.ILocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseElement {
    private WebDriver driver;
    private final ILocator locator;
    private WebElement cachedElement;

    public BaseElement(ILocator locator) {
        this.locator = locator;
        this.driver = DriverHolder.getInstance().getDriver();
    }
    public ILocator getLocator() {
        return locator;
    }
    public WebElement webElement() {
        return driver.findElement(locator.get());
    }

}
