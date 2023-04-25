package framework.locators;

import org.openqa.selenium.By;

/**
 * @author Joao Jesus on 29/06/2018
 *
 * Implementation of ILocator contract
 * All locator strategies will inherit both locator strategies conversions (xpath/css)
 * mainly useful when concatenating using different types
 */

public abstract class BaseLocator implements ILocator {
    private final String expression;

    protected BaseLocator(String expression) {
        this.expression = expression;
    }

    protected String expression() {
        return expression;
    }

    public abstract By get();
    public abstract ByCssSelector toCss();
    public abstract ByXPath toXpath();

    @Override
    public ILocator appendCss(String css) {
        return new ByCssSelector(toCss() + css);
    }

    @Override
    public ILocator appendXpath(String xpath) {
        return new ByXPath(toXpath() + xpath);
    }

    @Override
    public ILocator appendXpath(String xpath, int index) {
        return new ByXPath("(" + toXpath() + xpath + ")[" + index + "]");
    }

    @Override
    public ILocator appendIndex(int index) {
        return new ByXPath("(" + toXpath() + ")[" + index + "]");
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ILocator && obj.toString().equals(toString());
    }

    @Override
    public String toString() {
        return expression;
    }
}
