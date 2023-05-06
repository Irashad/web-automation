package com.insider.automation.steps;

import com.insider.automation.failsafe.RetryAnalyze;
import com.insider.automation.pageobjects.web.JobsPage;
import com.insider.automation.session.DriverHolder;
import framework.enums.Location;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobsSteps extends BaseSteps{

    @Test( groups = "JobSearchEndToEnd",dependsOnMethods = {"com.insider.automation.steps.CareersSteps.careersPageTest" },retryAnalyzer = RetryAnalyze.class)
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
