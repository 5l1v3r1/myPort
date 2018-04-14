package myport.sharkletvecihi.com.myport.Models;

/**
 * Created by Admin on 4/14/2018.
 */

public class flight {

    String airlineName;
    String flightNumber;
    String airlineIata;
    String stad;
    String destinationEn;

    public flight(String airlineName, String flightNumber, String airlineIata, String stad, String destinationEn) {
        this.airlineName = airlineName;
        this.flightNumber = flightNumber;
        this.airlineIata = airlineIata;
        this.stad = stad;
        this.destinationEn = destinationEn;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirlineIata() {
        return airlineIata;
    }

    public String getStad() {
        return stad;
    }

    public String getDestinationEn() {
        return destinationEn;
    }
}
