package com.insider.automation.pageobjects.web;

import com.insider.automation.session.DriverHolder;
import framework.Location;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class JobsPage {
    private final WebDriver driver;

    public JobsPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By applyNowButton = By.cssSelector("section#career-position-list a");
    //private final By locationFilter = By.xpath("//label[text()='Location']/following-sibling::div//input[@type='search']");
  //  private final By departmentFilter = By.xpath("//label[text()='Department']/following-sibling::div//button");
   // private final By departmentOption = By.xpath("//label[text()='Department']/following-sibling::div//a[text()='Quality Assurance']");
    private final By seeAllQAJob = By.linkText("See all QA jobs");
    private final By filterByLocationContainer = By.id("select2-filter-by-location-container");
    private final By filterByLocationOptions = By.cssSelector("#filter-by-location option");

    public boolean isLoaded() {
        return driver.getTitle().contains("Join Us");
    }

    public WebElement getFilterByLocationContainer()
    {
      return DriverHolder.getInstance().waitForElementClickable(filterByLocationContainer,10);
    }

    public List<WebElement> filterByLocation() {
        return DriverHolder.getInstance().numberOfElementsToBeMoreThan(filterByLocationOptions, 4, 20);
    }

    public boolean isFilterByLocationOptionsLoaded() {
        return filterByLocation().size() > 0;
    }

    public void chooseLocation(Location locationEnum){
        WebElement istanbul = DriverHolder.getInstance().getDriver().findElement(By.cssSelector("ul[id='select2-filter-by-location-results'] li[id*='"+locationEnum.getCity()+", "+locationEnum.getCountry()+"']"));
        Actions actions = new Actions(DriverHolder.getInstance().getDriver());
        actions.moveToElement(istanbul).click().perform();
    }


//    public void filterByDepartment() {
//        WebElement departmentFilterButton = driver.findElement(departmentFilter);
//        departmentFilterButton.click();
//
//        WebElement departmentOptionLink = driver.findElement(departmentOption);
//        departmentOptionLink.click();
//    }

    public WebElement getSeeAllQaJob() {
        return DriverHolder.getInstance().waitForElementClickable(seeAllQAJob, 10);
    }

    public WebElement getApplyNowButton() {
        return DriverHolder.getInstance().waitForElementClickable(applyNowButton, 10);
    }

}
