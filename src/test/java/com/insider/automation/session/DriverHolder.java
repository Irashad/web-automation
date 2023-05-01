package com.insider.automation.session;

import framework.driver.config.InsiderDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(timeoutInSeconds));
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
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(timeoutInSeconds));
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
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Waits for an element to be present on the page.
     * @param windowsTabsCount the expected count of windows tabs
     * @param timeoutInSeconds the maximum time to wait for the element in seconds
     * @return  boolean value , true if expected windows tabs count are same, false otherwise
     */
    public boolean waitForNumberofWindowsToBe(int windowsTabsCount, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.numberOfWindowsToBe(windowsTabsCount));
    }

    /**
     * Waits for url contains some string
     * @param partialStringInUrl the expected count of windows tabs
     * @param timeoutInSeconds the maximum time to wait for the element in seconds
     * @return  boolean value , true if expected windows tabs count are same, false otherwise
     */
    public boolean waitForUrlContains(String partialStringInUrl, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.urlContains(partialStringInUrl));
    }

    /**
     * Waits for url contains some string
     * @param locator the By locator for the element
     * @param timeoutInSeconds the maximum time to wait for the element in seconds
     * @return  List of WebElements
     */
    public List<WebElement> numberOfElementsToBeMoreThan(By locator, int numberOfElements, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, numberOfElements));

    }
}

