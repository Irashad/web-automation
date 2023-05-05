package com.insider.automation.steps;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.insider.automation.pageobjects.web.CareersPage;
import com.insider.automation.pageobjects.web.HomePage;
import com.insider.automation.pageobjects.web.JobsPage;
import com.insider.automation.reporter.ExtentReportListener;
import com.insider.automation.session.DriverHolder;
import framework.enums.Location;
import org.testng.Assert;
import org.testng.annotations.Test;


public class JobSearch extends BaseSteps {
    @Test(priority = 1)
    public void homePageTest() {
        ExtentTest test = ExtentReportListener.getExtentTestInstance();
        test.log(Status.INFO,"Home page test has been started");

        HomePage homePage = getPages().getHomePage().openLandingPage();
        Assert.assertTrue(homePage.isLoaded());
        helper.getAcceptAllCookies().click();
        homePage.getMoreMenu().click();
        homePage.goToCareersPage();
    }

    @Test(priority = 2,dependsOnMethods = "homePageTest")
    public void careersPageTest() {
        ExtentTest test = ExtentReportListener.getExtentTestInstance();
        test.log(Status.INFO,"Careers page test has been started");

        CareersPage careersPage = getPages().getCareersPage();
        Assert.assertTrue(careersPage.isLoaded());

        int lifeAtInsiderBlockElementSize = careersPage.getSizeOfLifeAtInsiderBlock();
        Assert.assertTrue(helper.sizeIsBiggerThanZero(lifeAtInsiderBlockElementSize));

        int locationsBlockElementSize = careersPage.getSizeOfLocationsBlock();
        Assert.assertTrue(helper.sizeIsBiggerThanZero(locationsBlockElementSize));

        int teamsBlockElementSize = careersPage.getSizeOfTeamsBlock();
        Assert.assertTrue(helper.sizeIsBiggerThanZero(teamsBlockElementSize));

        careersPage.seeAllTeams();

    }

    @Test(priority = 3,dependsOnMethods = "careersPageTest" )
    public void jobsPageTest() {
        JobsPage jobsPage = getPages().getCareersPage().goToQaJobTitle();
        jobsPage.getSeeAllQaJob().click();
        Assert.assertTrue(jobsPage.isFilterByLocationOptionsLoaded(), "options for location filter didn't loaded with in 20 seconds");
        jobsPage.getFilterByLocationContainer().click();
        jobsPage.chooseLocation(Location.TR);

        // Click 'apply now'  and verify new tab opened with expected pre-url
        String mainWindowHandle = DriverHolder.getInstance().getDriver().getWindowHandle();
        jobsPage.clickApllyButtonWithJS();
        Assert.assertTrue(DriverHolder.getInstance().waitForNumberofWindowsToBe(2, 8));
        helper.switchWindowNextTab(mainWindowHandle);
        Assert.assertTrue(DriverHolder.getInstance().waitForUrlContains("jobs.lever.co/useinsider", 10));

    }

}
