package com.insider.automation.session;

import com.insider.automation.pageobjects.web.CareersPage;
import com.insider.automation.pageobjects.web.HomePage;
import com.insider.automation.pageobjects.web.JobsPage;
import org.openqa.selenium.WebDriver;

public class PageObjectHolder {
    private final WebDriver driver;

    public PageObjectHolder() {
        driver = DriverHolder.getInstance().getDriver();
    }

    private static class LazyHolder {
        static final PageObjectHolder INSTANCE = new PageObjectHolder();
    }

    public static PageObjectHolder getInstance() {
        return PageObjectHolder.LazyHolder.INSTANCE;
    }

    CareersPage careersPage;
    HomePage homePage;
    JobsPage jobsPage;

    public CareersPage getCareersPage() {
        if (careersPage == null) {
            careersPage = new CareersPage(driver);
        }
        return careersPage;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public JobsPage getJobsPage() {
        if (jobsPage == null) {
            jobsPage = new JobsPage(driver);
        }
        return jobsPage;
    }

}
