package VeridicSolutions.EVChargingStations.stations;

import VeridicSolutions.EVChargingStations.stations.springdatajpa.SpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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

    public  EVChargingStation showById(String id){

        EVChargingStation evChargingStation = stationList.stream()
                .filter(station -> station.getStation_id().equalsIgnoreCase(id))
                .findFirst()
                .get();
        return evChargingStation;
    }

    public void addStation(EVChargingStation station) {
         stationList.add(station);
    }

    public void editStation(String id, EVChargingStation station) {
        deleteStation(id);
        stationList.add(station);
    }

    public void deleteStation(String id) {
        stationList.removeIf(s -> s.getStation_id().equalsIgnoreCase(id));
    }

    public static class EVChargingStationCommnadLineRunner implements CommandLineRunner {
        @Autowired
        private SpringDataJpaRepository repository;
        @Override
        public void run(String... args) throws Exception {
            repository.save(new EVChargingStation("1","Indian Oil"
                                            ,"100rs","Indian Oil Add"
                    ,"Kasshmere Gate"));


        }
    }
}
