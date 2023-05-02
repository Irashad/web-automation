package framework.enums;

import java.util.stream.Stream;

public enum Browsers {
    CHROME("chrome"),
    FIREFOX("firefox");

    private String browserName;

    Browsers(String browserName) {
        this.browserName = browserName;

    }
    public String getBrowserName(){return browserName;}

    public static Browsers get(String browserName){
        return Stream.of(Browsers.values())
                .filter(browsers -> browsers.getBrowserName().equalsIgnoreCase(browserName))
                .findFirst()
                .orElseThrow(() -> new ExceptionInInitializerError("Could not find enum for " + browserName));
    }
}
