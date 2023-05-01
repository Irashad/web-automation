package com.insider.automation.steps;

import com.insider.automation.pageobjects.web.CareersPage;
import com.insider.automation.pageobjects.web.HomePage;
import com.insider.automation.pageobjects.web.JobsPage;
import com.insider.automation.session.DriverHolder;
import com.insider.automation.session.PageObjectHolder;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.Set;


public class HomePageSteps extends BaseSteps {
    @Test(priority = 1)
    public void HomePageTest(ITestContext iTestContext) throws InterruptedException {
         // test 1 validate home page loaded
        HomePage homePage = PageObjectHolder.getPages().getHomePage().openLandingPage();
        Assert.assertTrue(homePage.isLoaded());
        helper.getAcceptAllCookies().click();

        // test 2.2 validate careers page opening when clicking
        PageObjectHolder.getPages().getHomePage().getMoreMenu().click();
        CareersPage careersPage = PageObjectHolder.getPages().getHomePage().goToCareersPage();
        Assert.assertTrue(careersPage.isLoaded());

        // test 2.3 validate life insider block is opened
        int lifeAtInsiderElementListSize = PageObjectHolder.getPages().getCareersPage().getSizeOfLifeAtInsiderBlock();
        Assert.assertTrue(helper.sizeIsBiggerThanZero(lifeAtInsiderElementListSize));

        // test 2.4 validate locations block is opened
        int locationsElementListSize = PageObjectHolder.getPages().getCareersPage().getSizeOfLocationsBlock();
        Assert.assertTrue(helper.sizeIsBiggerThanZero(locationsElementListSize));

        // test 2.5 validate teams block is opened
        int teamsElementListSize = PageObjectHolder.getPages().getCareersPage().getSizeOfTeamsBlock();
        Assert.assertTrue(helper.sizeIsBiggerThanZero(teamsElementListSize));

        // test 3 click see all jobs
        helper.scrollInView(careersPage.getSeeAllTeams(), false);
        helper.clickWithJs(PageObjectHolder.getPages().getCareersPage().getSeeAllTeams());


        // test 4 click QA Assurance:
        helper.scrollInView(PageObjectHolder.getPages().getCareersPage().qaJobTitle(), true);
        helper.clickWithJs(PageObjectHolder.getPages().getCareersPage().qaJobTitle());


        // test 5 QA page. click see all qa job
        PageObjectHolder.getPages().getJobsPage().getSeeAllQaJob().click();


        //test 6
        // TODO: wait condition yaz -
        //  gozlesin butun optionlar yuklensin. optionlarin yuklenmesi vaxt alir.



        /**
         * Selecting by Select class doesn't working in Firefox - needs more investigation - hence used different approach to support both firefox chrome:
         *
         * WebElement selectElement = DriverHolder.getInstance().waitForElementPresent(By.name("filter-by-location"), 10);
         * selectElement.click();
         * Select select = new Select(selectElement);
         * select.selectByVisibleText("Istanbul, Turkey");
         *
         * */
        //Thread.sleep(12000);
        WebDriverWait waitslects = new WebDriverWait(DriverHolder.getInstance().getDriver(),15);
        waitslects.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("#filter-by-location option"),4));
        int re = DriverHolder.getInstance().getDriver().findElements(By.cssSelector("#filter-by-location option")).size();
        System.out.println("url  elementler sayi selectde bu qederdir "+re);

        WebElement selectElement = DriverHolder.getInstance().waitForElementClickable(By.id("select2-filter-by-location-container"), 10);
        selectElement.click();
        WebElement istanbul = DriverHolder.getInstance().getDriver().findElement(By.cssSelector("li[id*='Istanbul']"));
        Actions actions = new Actions(DriverHolder.getInstance().getDriver());
        actions.moveToElement(istanbul).click().build().perform();


        //test 7
        // WebElement filterByDepartmentElement = DriverHolder.getInstance().waitForElementClickable(By.id("filter-by-department"),10);
        // Select filterByDepartment = new Select(filterByDepartmentElement);
        // FilterByDepartment.deselectAll();

        //test 8 click apply now
        //
        String mainWindowHandle = DriverHolder.getInstance().getDriver().getWindowHandle();

        //
        helper.scrollDown();
        JobsPage jobsPage = PageObjectHolder.getPages().getJobsPage();
        helper.clickWithJs(jobsPage.getApplyNowButton());

        //
        WebDriverWait wait = new WebDriverWait(DriverHolder.getInstance().getDriver(), 10);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        //

        //
        Set<String> windowHandles = DriverHolder.getInstance().getDriver().getWindowHandles();
        // Loop through the window handles and switch to the new one
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                DriverHolder.getInstance().getDriver().switchTo().window(handle);
                String anotherWindow = DriverHolder.getInstance().getDriver().getWindowHandle();
                break;
            }
        }
        WebDriverWait wait1 = new WebDriverWait(DriverHolder.getInstance().getDriver(),10);

        wait1.until(ExpectedConditions.urlContains("jobs.lever.co/useinsider"));
        String actualUrl = DriverHolder.getInstance().getDriver().getCurrentUrl();
        System.out.println("url contains : "+actualUrl);
        //
    }

}
