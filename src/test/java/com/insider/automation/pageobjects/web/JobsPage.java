package com.insider.automation.pageobjects.web;

import com.insider.automation.session.DriverHolder;
import com.insider.automation.utils.Helper;
import framework.enums.Location;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class JobsPage {
    private final WebDriver driver;
    private Helper helper;

    public JobsPage(WebDriver driver) {
        this.driver = driver;
        helper = new Helper();
    }

    private final By applyNowButton = By.cssSelector("section#career-position-list a");
    private final By seeAllQAJob = By.linkText("See all QA jobs");
    private final By filterByLocationContainer = By.id("select2-filter-by-location-container");
    private final By filterByLocationOptions = By.cssSelector("#filter-by-location option");

    public WebElement getFilterByLocationContainer() {
        return DriverHolder.getInstance().waitForElementClickable(filterByLocationContainer, 10);
    }

    public List<WebElement> filterByLocation() {
        return DriverHolder.getInstance().numberOfElementsToBeMoreThan(filterByLocationOptions, 4, 20);
    }

    public boolean isFilterByLocationOptionsLoaded() {
        return filterByLocation().size() > 0;
    }

    public void chooseLocation(Location locationEnum) {
        WebElement istanbul = DriverHolder.getInstance().getDriver().findElement(By.cssSelector("ul[id='select2-filter-by-location-results'] li[id*='" + locationEnum.getCity() + ", " + locationEnum.getCountry() + "']"));
        Actions actions = new Actions(DriverHolder.getInstance().getDriver());
        actions.moveToElement(istanbul).click().perform();
    }

    public WebElement getSeeAllQaJob() {
        return DriverHolder.getInstance().waitForElementClickable(seeAllQAJob, 10);
    }

    public WebElement getApplyNowButton() {
        return DriverHolder.getInstance().waitForElementClickable(applyNowButton, 10);
    }
    public void clickApllyButtonWithJS(){
        helper.scrollDown();
        helper.clickWithJs(getApplyNowButton());
    }

}
