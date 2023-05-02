package framework.enums;

import java.util.stream.Stream;

public enum Domain {

    BASE_URL("https://useinsider.com/");

    private String domainUrl;

    Domain(String domainUrl) {
        this.domainUrl = domainUrl;

    }
    public String getDomainUrl(){return domainUrl;}

    public static Domain get(String domainUrl){
        return Stream.of(Domain.values())
                .filter(domainurl -> domainurl.getDomainUrl().equalsIgnoreCase(domainUrl))
                .findFirst()
                .orElseThrow(() -> new ExceptionInInitializerError("Could not find enum for " + domainUrl));
    }
}
