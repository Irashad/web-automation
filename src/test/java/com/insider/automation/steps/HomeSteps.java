package com.insider.automation.steps;

import com.insider.automation.failsafe.RetryAnalyze;
import com.insider.automation.pageobjects.web.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomeSteps extends BaseSteps{

    @Test(groups = "JobSearchEndToEnd",retryAnalyzer = RetryAnalyze.class )
    public void homePageTest() {
        HomePage homePage = getPages().getHomePage().openLandingPage();
        Assert.assertTrue(homePage.isLoaded());
        helper.getAcceptAllCookies().click();
        homePage.getMoreMenu().click();
        homePage.goToCareersPage();
    }

}
