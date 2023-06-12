package VeridicSolutions.EVChargingStations.stations;

import VeridicSolutions.EVChargingStations.stations.springdatajpa.SpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EVChargingStationService {
    public static List<EVChargingStation> stationList = new ArrayList<>();
    @Autowired
    public SpringDataJpaRepository repository;

    public   List<EVChargingStation> showAll() {
     return   repository.findAll(Sort.by( Sort.Direction.ASC, "stationAddress"));
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

    public List<EVChargingStation> findStationsWithSorting(String field){

        return     repository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public   Page<EVChargingStation> findPaginatedStations(int offSet   ,int pageSize) {
        Page<EVChargingStation> pageStation = repository.findAll(PageRequest.of(offSet, pageSize));
        return pageStation;
    }

    public   Page<EVChargingStation> findPaginatedStationsWithSorting(int offSet,int pageSize,String field,Sort.Direction sort) {
        PageRequest pageRequest =   PageRequest.of(offSet,pageSize,Sort.by(sort,field));
        Page<EVChargingStation> pageStation = repository.findAll(pageRequest);
        return pageStation;
    }
}
