package framework.locators;

import org.openqa.selenium.By;

/**
 * @author Joao Jesus on 29/06/2018
 *
 * Abstracts By.name and adds ability to concatenate selectors and/or convert to cssSelector or xpath
 */

public class ByName extends BaseLocator {

    ByName(String expression) {
        super(expression);
    }

    @Override
    public By get() {
        return By.name(expression());
    }

    @Override
    public ByCssSelector toCss() {
        return new ByCssSelector("[name='" + expression() + "']");
    }

    @Override
    public ByXPath toXpath() {
        return new ByXPath("//*[@name='" + expression() + "']");
    }

    @Override
    public ILocator append(final String css, final String xpath) {
        return appendCss(css);
    }
}
