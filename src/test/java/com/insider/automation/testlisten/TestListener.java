package com.insider.automation.testlisten;

import com.insider.automation.session.DriverHolder;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import java.nio.file.Files;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        File screenshot = ((TakesScreenshot) DriverHolder.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        Path screenshotPath = Paths.get("screenshot.png");
        try {
            Files.copy(screenshot.toPath(), screenshotPath);
             Reporter.log("<a href='" + "/Users/rashadnasirli/Documents/Insider/web-automation/screenshot.png" + "'> <img src='" + "/Users/rashadnasirli/Documents/Insider/web-automation/screenshot.png" + "' height='100' width='100'/> </a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
