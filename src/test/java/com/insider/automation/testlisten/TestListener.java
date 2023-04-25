package com.insider.automation.testlisten;

import com.insider.automation.steps.Hooks;
import framework.driver.config.InsiderDriver;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
public class TestListener implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        Object currentClass = result.getInstance();
        WebDriver driver = ((InsiderDriver) currentClass).getDriver();
        if (driver != null) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot.toPath(), new File("screenshots/" + result.getName() + ".png").toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Reporter.log("<a href='" + screenshot.getAbsolutePath() + "'><img src='" + screenshot.getAbsolutePath() + "' height='100' width='100'/></a>");
        }
    }
}
