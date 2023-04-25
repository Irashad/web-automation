package framework.locators;

import org.openqa.selenium.By;

/**
 * @author Joao Jesus on 29/06/2018
 *
 * Abstracts By.linkText and adds ability to concatenate selectors
 */

public class ByLinkText extends BaseLocator {

    ByLinkText(String expression) {
        super(expression);
    }

    @Override
    public By get() {
        return By.linkText(expression());
    }

    @Override
    public ByCssSelector toCss() {
        throw new RuntimeException("No css selector available for ByLinkText locator");
    }

    @Override
    public ByXPath toXpath() {
        return new ByXPath("//*[text()='" + expression() + "']");
    }

    @Override
    public ILocator append(final String css, final String xpath) {
        return appendCss(css);
    }
}
