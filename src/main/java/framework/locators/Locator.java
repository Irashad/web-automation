package framework.locators;

/**
 * @author Joao Jesus on 29/06/2018
 *
 * Class container of all possible Locator strategies
 * All objects returned extend from BaseLocator which contains default contract implementation
 */

public class Locator {

    // Standard locators
    public static ILocator className(String className) {
        return new ByClassName(className);
    }

    public static ILocator cssSelector(String css) {
        return new ByCssSelector(css);
    }

    public static ILocator id(String id) {
        return new ById(id);
    }

    public static ILocator name(String name) {
        return new ByName(name);
    }

    public static ILocator linkText(String linkText) {
        return new ByLinkText(linkText);
    }

    public static ILocator partialLinkText(String partialLinkText) {
        return new ByPartialLinkText(partialLinkText);
    }

    public static ILocator xPath(String xpath) {
        return new ByXPath(xpath);
    }

    public static String hasClass(String className) {
        return "contains(concat(' ',normalize-space(@class),' '),' " + className + " ')";
    }
}
