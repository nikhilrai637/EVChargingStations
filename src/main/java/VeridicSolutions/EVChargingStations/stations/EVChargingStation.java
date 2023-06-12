package VeridicSolutions.EVChargingStations.stations;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "Station")
public class EVChargingStation {

   @Id
    private String stationId;



    private String stationName;
    private String stationPricing;
    private String stationImage;
    private String stationAddress;

    public EVChargingStation(){};
    public EVChargingStation(String stationId, String stationName,
                             String stationPricing, String stationImage,
                             String stationAddress) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.stationPricing = stationPricing;
        this.stationImage = stationImage;
        this.stationAddress = stationAddress;
    }

    public String getStation_id() {
        return stationId;
    }

    public void setStation_id(String stationId) {
        this.stationId = stationId;
    }

    public String getstationName() {
        return stationName;
    }

    public void setstationName(String stationName) {
        this.stationName = stationName;
    }
    public String getStation_pricing() {
        return stationPricing;
    }

    public void setStation_pricing(String stationPricing) {
        this.stationPricing = stationPricing;
    }

    public String getStation_image() {
        return stationImage;
    }

    public void setStation_image(String stationImage) {
        this.stationImage = stationImage;
    }

    public String getStation_address() {
        return stationAddress;
    }

    public void setStation_address(String stationAddress) {
        this.stationAddress = stationAddress;
    }


    @Override
    public String toString() {
        return "EVChargingStation{" +
                "stationId='" + stationId + '\'' +
                ", stationName='" + stationName + '\'' +
                ", stationPricing='" + stationPricing + '\'' +
                ", stationImage='" + stationImage + '\'' +
                ", stationAddress='" + stationAddress + '\'' +
                '}';
    }


}
