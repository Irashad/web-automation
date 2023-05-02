package com.insider.automation.utils;

import com.insider.automation.session.DriverHolder;
import org.openqa.selenium.*;

import java.util.Set;

public class Helper {
    private final By acceptAllCookies = By.cssSelector("a#wt-cli-accept-all-btn");

    public void acceptAllCookies() {
        //add all cookies
        Set<Cookie> cookies = DriverHolder.getInstance().getDriver().manage().getCookies();
        for (Cookie cookie : cookies) {
            DriverHolder.getInstance().getDriver().manage().addCookie(cookie);
        }
        DriverHolder.getInstance().getDriver().navigate().refresh();
        //add all cookies
    }

    public WebElement getAcceptAllCookies() {
        return DriverHolder.getInstance().getDriver().findElement(acceptAllCookies);
    }

    public boolean sizeIsBiggerThanZero(int size) {
        return size > 0;
    }

    public void scrollInView(WebElement element, boolean shouldAlignToTop) {
        ((JavascriptExecutor) DriverHolder.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(" + shouldAlignToTop + ")", new Object[]{element});
    }

    public void scrollDown() {
        ((JavascriptExecutor) DriverHolder.getInstance().getDriver()).executeScript("scrollBy(0, 714);");
    }

    public void mouseHoverEvent(WebElement webElement) {
        ((JavascriptExecutor) DriverHolder.getInstance().getDriver()).executeScript("arguments[0].dispatchEvent(new Event('mouseover'));", webElement);
    }

    public void clickWithJs(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) DriverHolder.getInstance().getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public WebDriver executeJavaScript(String jScript, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverHolder.getInstance().getDriver();
        js.executeScript(jScript, element);
        return DriverHolder.getInstance().getDriver();
    }

    public void switchWindowNextTab(String mainWindowHandle) {

        Set<String> windowHandles = DriverHolder.getInstance().getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                DriverHolder.getInstance().getDriver().switchTo().window(handle);
                break;
            }
        }
    }
}
