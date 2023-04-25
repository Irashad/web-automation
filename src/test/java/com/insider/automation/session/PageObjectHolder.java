package com.insider.automation.session;

import com.insider.automation.pageobjects.web.CareersPage;
import org.openqa.selenium.WebDriver;

public class PageObjectHolder {
    private final WebDriver driver;

    public PageObjectHolder() {
        driver = DriverHolder.getInstance().getDriver();
    }
    private static class LazyHolder {
        static final PageObjectHolder INSTANCE = new PageObjectHolder();
    }

    public static PageObjectHolder getPages() {
        return PageObjectHolder.LazyHolder.INSTANCE;
    }






    private CareersPage careersLandingPage;

    public CareersPage getCareersLandingPage() {
        if (careersLandingPage == null) {
            careersLandingPage = new CareersPage(driver);
        }
        return careersLandingPage;
    }

}
