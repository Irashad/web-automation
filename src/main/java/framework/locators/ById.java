package framework.locators;

import org.openqa.selenium.By;

/**
 * @author Joao Jesus on 29/06/2018
 *
 * Abstracts By.id and adds ability to concatenate selectors and/or convert to xpath
 */

public class ById extends BaseLocator {

    ById(String expression) {
        super(expression);
    }

    @Override
    public By get() {
        return By.id(expression());
    }

    @Override
    public ByCssSelector toCss() {
        return new ByCssSelector("#" + expression());
    }

    @Override
    public ByXPath toXpath() {
        return new ByXPath("//*[@id='" + expression() + "']");
    }

    @Override
    public ILocator append(final String css, final String xpath) {
        return appendCss(css);
    }
}
