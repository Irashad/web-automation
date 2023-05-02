package com.insider.automation.steps;

import com.insider.automation.pageobjects.web.CareersPage;
import com.insider.automation.pageobjects.web.HomePage;
import com.insider.automation.pageobjects.web.JobsPage;
import com.insider.automation.session.DriverHolder;
import framework.enums.Location;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageSteps extends BaseSteps {
    @Test(priority = 1)
    public void HomePageTest() {

        // test 1 validate home page loaded
        HomePage homePage = getPages().getHomePage().openLandingPage();
        Assert.assertTrue(homePage.isLoaded());
        helper.getAcceptAllCookies().click();

        // test 2.2 validate careers page opening when clicking
        homePage.getMoreMenu().click();
        CareersPage careersPage = getPages().getHomePage().goToCareersPage();
        Assert.assertTrue(careersPage.isLoaded());

        // test 2.3 validate life insider block is opened
        int lifeAtInsiderElementListSize = careersPage.getSizeOfLifeAtInsiderBlock();
        Assert.assertTrue(helper.sizeIsBiggerThanZero(lifeAtInsiderElementListSize));

        // test 2.4 validate locations block is opened
        int locationsElementListSize = careersPage.getSizeOfLocationsBlock();
        Assert.assertTrue(helper.sizeIsBiggerThanZero(locationsElementListSize));

        // test 2.5 validate teams block is opened
        int teamsElementListSize = careersPage.getSizeOfTeamsBlock();
        Assert.assertTrue(helper.sizeIsBiggerThanZero(teamsElementListSize));

        // test 3 click see all jobs
        helper.scrollInView(careersPage.getSeeAllTeams(), false);
        helper.clickWithJs(careersPage.getSeeAllTeams());

        // test 4 click QA Assurance:
        helper.scrollInView(careersPage.qaJobTitle(), true);
        helper.clickWithJs(careersPage.qaJobTitle());

        // test 5 QA page. click see all qa job
        JobsPage jobsPage = getPages().getJobsPage();
        jobsPage.getSeeAllQaJob().click();

        //test 6 filter by location
        /**
         * Selecting by Select class doesn't working in Firefox - needs more investigation - hence used different approach to support both firefox chrome:
         * WebElement selectElement = DriverHolder.getInstance().waitForElementPresent(By.name("filter-by-location"), 10);
         * selectElement.click();
         * Select select = new Select(selectElement);
         * select.selectByVisibleText("Istanbul, Turkey");
         * */

        Assert.assertTrue(jobsPage.isFilterByLocationOptionsLoaded(), "options for location filter didn't loaded with in 20 seconds");
        jobsPage.getFilterByLocationContainer().click();
        jobsPage.chooseLocation(Location.TR);


        //test 8 click apply now  and verify new tab opened with expected pre url
        String mainWindowHandle = DriverHolder.getInstance().getDriver().getWindowHandle();
        helper.scrollDown();
        helper.clickWithJs(jobsPage.getApplyNowButton());
        Assert.assertTrue(DriverHolder.getInstance().waitForNumberofWindowsToBe(2, 8));
        helper.switchWindowNextTab(mainWindowHandle);

        //Assert we are redirected to jobs.lever.co website
        Assert.assertTrue(DriverHolder.getInstance().waitForUrlContains("jobs.lever.co/useinsider", 10));
    }

}
