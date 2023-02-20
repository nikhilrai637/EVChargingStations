package VeridicSolutions.EVChargingStations.stations;

import java.util.ArrayList;
import java.util.List;


public class EVChargingStationService {
    public static List<EVChargingStation> stationList = new ArrayList<>();

     static {
         stationList.add(new EVChargingStation("1","Green Zone",
                 "$132","Pic1","Vancouver,Austin TX"));
         stationList.add(new EVChargingStation("2","Green Zone",
                 "$132","Pic1","Vancouver,Austin TX"));
         stationList.add(new EVChargingStation("3","Green Zone",
                 "$132","Pic1","Vancouver,Austin TX"));
         stationList.add(new EVChargingStation("4","Green Zone",
                 "$132","Pic1","Vancouver,Austin TX"));
         stationList.add(new EVChargingStation("5","Green Zone",
                 "$132","Pic1","Vancouver,Austin TX"));
     }



    public static EVChargingStation showById(String id){
        List<EVChargingStation> stationByid =    stationList.stream().filter(station -> station.getStation_id().compareToIgnoreCase(id) == 1);

     }
}
