package framework.locators;

import org.openqa.selenium.By;

import static framework.locators.Locator.hasClass;

/**
 * @author Joao Jesus on 29/06/2018
 *
 * Abstracts By.className and adds ability to concatenate locators
 * and convert to cssSelector and xpath
 */

public class ByClassName extends BaseLocator {

    ByClassName(String expression) {
        super(expression);
    }

    @Override
    public By get() {
        return By.className(expression());
    }

    @Override
    public ByCssSelector toCss() {
        return new ByCssSelector("." + expression());
    }

    @Override
    public ByXPath toXpath() {
        return new ByXPath("//*[" + hasClass(expression()) + "]");
    }

    @Override
    public ILocator append(final String css, final String xpath) {
        return appendCss(css);
    }
}
