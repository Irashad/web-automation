package framework.locators;

import org.openqa.selenium.By;

import static org.joox.selector.CSS2XPath.css2xpath;

/**
 * @author Joao Jesus on 29/06/2018
 *
 * Abstracts By.cssSelector and adds ability to concatenate cssSelectors and/or
 * convert to xpath
 */

public class ByCssSelector extends BaseLocator {

    ByCssSelector(String expression) {
        super(expression);
    }

    @Override
    public By get() {
        return By.cssSelector(expression());
    }

    @Override
    public ByCssSelector toCss() {
        return this;
    }

    @Override
    public ByXPath toXpath() {
        try {
            return new ByXPath(css2xpath(expression()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Could not return a valid xpath for the css selector specified");
    }

    @Override
    public ILocator append(final String css, final String xpath) {
        return appendCss(css);
    }
}
