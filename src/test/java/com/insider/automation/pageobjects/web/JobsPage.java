package com.insider.automation.pageobjects.web;

import com.insider.automation.session.DriverHolder;
import framework.driver.config.InsiderDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JobsPage {
    private final WebDriver driver;
    public JobsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By applyNowButton = By.cssSelector("section#career-position-list a");
    private final By locationFilter = By.xpath("//label[text()='Location']/following-sibling::div//input[@type='search']");

    private final By departmentFilter = By.xpath("//label[text()='Department']/following-sibling::div//button");
    private final By departmentOption = By.xpath("//label[text()='Department']/following-sibling::div//a[text()='Quality Assurance']");
    private final By seeAllQAJob = By.linkText("See all QA jobs");
    public boolean isLoaded() {
        return driver.getTitle().contains("Join Us");
    }


    public void filterByLocation(String location) {
        WebElement locationFilterInput = driver.findElement(locationFilter);
        locationFilterInput.sendKeys(location);
    }

    public void filterByDepartment() {
         WebElement departmentFilterButton = driver.findElement(departmentFilter);
        departmentFilterButton.click();

        WebElement departmentOptionLink = driver.findElement(departmentOption);
        departmentOptionLink.click();
    }

    public WebElement getSeeAllQaJob(){
        return DriverHolder.getInstance().waitForElementClickable(seeAllQAJob,10);
    }

    public WebElement getApplyNowButton()
    {
       return DriverHolder.getInstance().waitForElementClickable(applyNowButton,10);
    }

}
