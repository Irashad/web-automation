package framework.locators;

import org.openqa.selenium.By;

/**
 * @author Joao Jesus on 29/06/2018
 *
 * Abstracts By.partialLinkText and adds ability to concatenate selectors
 */

public class ByPartialLinkText extends BaseLocator {

    ByPartialLinkText(String expression) {
        super(expression);
    }

    @Override
    public By get() {
        return By.partialLinkText(expression());
    }

    @Override
    public ByCssSelector toCss() {
        throw new RuntimeException("No css selector available for ByPartialLinkText locator");
    }

    public ByXPath toXpath() {
        return new ByXPath("//*[contains(text(),'" + expression() + "')]");
    }

    @Override
    public ILocator append(final String css, final String xpath) {
        return appendCss(css);
    }
}
