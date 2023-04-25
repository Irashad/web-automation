package framework.driver.config;

import org.openqa.selenium.WebDriver;

public class InsiderDriver  {
    public static WebDriver driver;
    private static class LazyHolder {
        static final InsiderDriver INSTANCE = new InsiderDriver();
    }
    public static InsiderDriver getInstance() {
        return InsiderDriver.LazyHolder.INSTANCE;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
