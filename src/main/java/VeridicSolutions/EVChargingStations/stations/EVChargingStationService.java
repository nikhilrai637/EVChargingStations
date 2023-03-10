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
        return repository.findById(id).get();
    }

    public void addStation(EVChargingStation station) {
        repository.save(station);
    }

    public void editStation(String id, EVChargingStation station) {
        repository.deleteById(id);
        repository.save(station);
    }

    public void deleteStation(String id) {
        repository.deleteById(id);
    }
}
