package VeridicSolutions.EVChargingStations.stations;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EVChargingStationsResource {

    @RequestMapping("/show")
    public List<EVChargingStation> showAllStations(){
        return     EVChargingStationService.stationList;
    }
    @RequestMapping("/show/{id}")

    public List<EVChargingStation> showAllStationsById(@PathVariable String id){
        return     EVChargingStationService.showById(id);
    }
}
