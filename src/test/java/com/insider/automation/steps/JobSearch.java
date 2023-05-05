package com.insider.automation.steps;

import com.aventstack.extentreports.Status;
import com.insider.automation.pageobjects.web.CareersPage;
import com.insider.automation.pageobjects.web.HomePage;
import com.insider.automation.pageobjects.web.JobsPage;
import com.insider.automation.session.DriverHolder;
import framework.enums.Location;
import org.testng.Assert;
import org.testng.annotations.Test;


public class JobSearch extends BaseSteps {
    @Test(priority = 1)
    public void homePageTest() {
        HomePage homePage = getPages().getHomePage().openLandingPage();
        Assert.assertTrue(homePage.isLoaded());
        helper.getAcceptAllCookies().click();
        homePage.getMoreMenu().click();
        homePage.goToCareersPage();
    }

    @Test(priority = 2,dependsOnMethods = "homePageTest")
    public void careersPageTest() {

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

        getReportLogger().log(Status.INFO,"Selecting  by Select class doesn't working on this element. Using different method");
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
