package com.insider.automation.pageobjects.web;

import com.insider.automation.session.DriverHolder;
import com.insider.automation.utils.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage {
    private final WebDriver driver;
    private Helper helper;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new Helper();
    }

    private final By locationsBlock = By.cssSelector("#location-slider [class='glide__slides']");
    private final By teamsBlock = By.cssSelector("#career-find-our-calling div[class*='career-load-more']");
    private final By lifeAtInsiderBlock = By.cssSelector("div[data-id='c06d1ec'] [class='swiper-wrapper']");
    private final By seeAllTeamsLink = By.cssSelector("a[href='javascript:void(0)']");
    private final By QAJobTitle = By.xpath("//a/h3[text()='Quality Assurance']");

    public boolean isLoaded() {
        return driver.getTitle().contains("Careers");
    }

    public WebElement getLifeAtInsiderBlock() {
        return driver.findElement(lifeAtInsiderBlock);
    }

    public int getSizeOfLifeAtInsiderBlock() {
        return getLifeAtInsiderBlock().findElements(By.cssSelector(" [data-swiper-slide-index]")).size();
    }

    public WebElement getLocationsBlock() {
        return driver.findElement(locationsBlock);
    }

    public int getSizeOfLocationsBlock() {
        return getLocationsBlock().findElements(By.cssSelector(" li")).size();
    }


    public WebElement getTeamsBlock() {
        return driver.findElement(teamsBlock);
    }

    public int getSizeOfTeamsBlock() {
        return getTeamsBlock().findElements(By.cssSelector(" div[class^='job-item']")).size();
    }

    public WebElement getSeeAllTeams() {
        return driver.findElement(seeAllTeamsLink);
    }

    public WebElement qaJobTitle() {
        return DriverHolder.getInstance().waitForElementClickable(QAJobTitle, 10);
    }

    public JobsPage goToQaJobTitle(){
        helper.scrollInView(qaJobTitle(), true);
        helper.clickWithJs(qaJobTitle());
      return new JobsPage(driver);
    }

    public void seeAllTeams(){
        helper.scrollInView(getSeeAllTeams(), false);
        helper.clickWithJs(getSeeAllTeams());
    }
}
