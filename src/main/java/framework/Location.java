package framework;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

public enum Location {
    TR( "Turkey", "Istanbul"),
    AZ("Azerbaijan","Baku"),
    UK("Ukraine","Kyiv"),
    FR("France", "Paris");


    private String country;
    private String city;
    Location(String country, String city) {
        this.country = country;
        this.city = city;
    }
    public String getCity(){return city;}

    public String getCountry() {
        return country;
    }

    public static Location get(String country){
        return Stream.of(Location.values())
                .filter(location -> location.getCountry().equalsIgnoreCase(country))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Could not find enum for " + country));
    }
}
