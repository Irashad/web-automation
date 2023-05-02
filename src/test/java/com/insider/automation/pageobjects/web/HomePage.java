package com.insider.automation.pageobjects.web;

import framework.enums.Domain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By moreMenuLink = By.xpath("//a[@id='mega-menu-1']/span[contains(text(), 'More')]");

    private final By careersLink = By.cssSelector("a[href='https://useinsider.com/careers/']");

    public boolean isLoaded() {
        return driver.getTitle().contains("Insider");
    }

    public WebElement getMoreMenu() {
        return driver.findElement(moreMenuLink);
    }

    public CareersPage goToCareersPage() {
        WebElement careers = driver.findElement(careersLink);
        careers.click();
        return new CareersPage(driver);
    }

    public HomePage openLandingPage() {
        driver.get(Domain.BASE_URL.getDomainUrl());
        return new HomePage(driver);
    }
}
