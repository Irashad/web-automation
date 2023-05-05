package com.insider.automation.reporter;

import com.insider.automation.session.DriverHolder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Screenshot {
    public static String capture(String testName) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        Path screenshotPath = Paths.get("screenshots", testName + "_" + timeStamp + ".png");
        Files.createDirectories(screenshotPath.getParent());

        File screenshotFile = ((TakesScreenshot) DriverHolder.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshotFile.toPath(), screenshotPath);

        return screenshotPath.toString();
    }
}
