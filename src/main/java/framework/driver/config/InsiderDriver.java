package framework.driver.config;

import framework.enums.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Optional;

public class InsiderDriver {
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

    public void setBrowser() {
      String envBrowser =   Optional.ofNullable(System.getenv("browser")).orElse("chrome");

        switch (Browsers.get(envBrowser)) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                InsiderDriver.driver = new ChromeDriver(options);
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                InsiderDriver.driver = new FirefoxDriver();
                break;
        }
    }

}
