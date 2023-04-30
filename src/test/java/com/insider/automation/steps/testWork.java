package com.insider.automation.steps;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.insider.automation.session.DriverHolder;
import com.insider.automation.session.PageObjectHolder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class testWork  extends Hooks{

//    @Test()
//    public void testit() throws IOException {
//        Reporter.log("Salam");
//
//
//        Assert.fail();
//        PageObjectHolder.getPages().getHomePage().isLoaded();
//        //File screenshot = ((TakesScreenshot) DriverHolder.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
//        //Path screenshotPath = Paths.get("screenshot.png");
//        //Files.copy(screenshot.toPath(), screenshotPath);
//    }
    public static String captureScreenshot(String screenshotName) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) DriverHolder.getInstance().getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = "/Users/rashadnasirli/Documents/Insider/web-automation/" + screenshotName + ".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
        return dest;
    }

}
