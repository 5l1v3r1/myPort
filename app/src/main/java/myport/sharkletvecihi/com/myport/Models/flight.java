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



    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setAirlineIata(String airlineIata) {
        this.airlineIata = airlineIata;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public void setDestinationEn(String destinationEn) {
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
