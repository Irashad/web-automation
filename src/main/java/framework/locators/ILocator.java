package framework.locators;

import org.openqa.selenium.By;

/**
 * @author Joao Jesus on 29/06/2018
 *
 * Interface to define contract between all different Locators
 */

public interface ILocator {
    By get();
    ByCssSelector toCss();
    ByXPath toXpath();
    ILocator appendCss(String css);
    ILocator appendXpath(String xpath);
    ILocator appendXpath(String xpath, int index);
    ILocator appendIndex(int index);
    ILocator append(String css, String xpath);
}
