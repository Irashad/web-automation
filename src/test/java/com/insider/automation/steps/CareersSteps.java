package com.insider.automation.steps;

import com.insider.automation.failsafe.RetryAnalyze;
import com.insider.automation.pageobjects.web.CareersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CareersSteps extends BaseSteps {
    @Test(groups = "JobSearchEndToEnd", dependsOnMethods ={"com.insider.automation.steps.HomeSteps.homePageTest" },retryAnalyzer = RetryAnalyze.class)
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

}
