package VeridicSolutions.EVChargingStations.stations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EVChargingStationsResource {
     @Autowired
    private EVChargingStationService evChargingStationService;

    @RequestMapping("/show")
    public List<EVChargingStation> showAllStations() {
        return EVChargingStationService.stationList;
    }
    @RequestMapping("/show/{id}")
    public EVChargingStation showAllStationsById(@PathVariable String id){
        return     evChargingStationService.showById(id);
    }

    @RequestMapping(value = "/show",method = RequestMethod.POST)
    public void showAllStations(@PathVariable String id,
                                                   @RequestBody EVChargingStation station) {

                evChargingStationService.addStation(station);

    }
}
