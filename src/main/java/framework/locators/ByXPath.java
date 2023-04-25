package framework.locators;

import org.openqa.selenium.By;

/**
 * @author Joao Jesus on 29/06/2018
 *
 * Abstracts By.xpath and adds ability to concatenate selectors
 */

public class ByXPath extends BaseLocator {

    ByXPath(String expression) {
        super(expression);
    }

    @Override
    public By get() {
        return By.xpath(expression());
    }

    @Override
    public ByCssSelector toCss() {
        throw new RuntimeException("No css selector available for ByXPath locator");
    }

    @Override
    public ByXPath toXpath() {
        return this;
    }

    @Override
    public ILocator append(final String css, final String xpath) {
        return appendXpath(xpath);
    }
}
