package com.insider.automation.session;

import framework.driver.config.InsiderDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    /**
     * Waits for an element to be visible on the page.
     *
     * @param locator the By locator for the element
     * @param timeoutInSeconds the maximum time to wait for the element in seconds
     * @return the WebElement when it is visible
     */
    public WebElement waitForElementVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for an element to be clickable on the page.
     *
     * @param locator the By locator for the element
     * @param timeoutInSeconds the maximum time to wait for the element in seconds
     * @return the WebElement when it is clickable
     */
    public WebElement waitForElementClickable(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    /**
     * Waits for an element to be present on the page.
     *
     * @param locator the By locator for the element
     * @param timeoutInSeconds the maximum time to wait for the element in seconds
     * @return the WebElement when it is present
     */
    public WebElement waitForElementPresent(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}

