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
    @Autowired
    public SpringDataJpaRepository repository;

    public   List<EVChargingStation> showAll() {
      return   repository.findAll();
    }

    public  EVChargingStation showById(String id){
//        EVChargingStation evChargingStation = stationList.stream()
//                .filter(station -> station.getStation_id().equalsIgnoreCase(id))
//                .findFirst()
//                .get();
//        return evChargingStation;
        System.out.println("We are using show by Id");
        return repository.findById(id).get();
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
}
