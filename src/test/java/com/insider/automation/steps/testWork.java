package com.insider.automation.steps;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.insider.automation.session.DriverHolder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;


public class testWork  extends Hooks{

    @Test()
    public void testit() throws IOException {

        File screenshot = ((TakesScreenshot) DriverHolder.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        Path screenshotPath = Paths.get("screenshot.png");
        Files.copy(screenshot.toPath(), screenshotPath);

    }
}
