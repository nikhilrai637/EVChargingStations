package VeridicSolutions.EVChargingStations.stations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.security.SecureRandom;
import java.util.List;


@RestController
public class EVChargingStationsResource {
    @Autowired
    private EVChargingStationService evChargingStationService;

    @RequestMapping("/show")
    public List<EVChargingStation> showAllStations() {
        System.out.println("Show Method is called");
        return EVChargingStationService.stationList;
    }
    @RequestMapping("/show/{id}")
    public EVChargingStation showAllStationsById(@PathVariable String id){
        return     evChargingStationService.showById(id);
    }
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public void insertStation(  @RequestBody EVChargingStation station) {
        SecureRandom secureRandom = new SecureRandom();
        String station_id = secureRandom.generateSeed(32).toString();
        evChargingStationService.addStation(station);
    }

    @RequestMapping(value = "/{id}/edit",method = RequestMethod.PUT)
    public void editStations( @PathVariable String id, @RequestBody EVChargingStation station) {
            evChargingStationService.editStation(id,station);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void deleteStations( @PathVariable String id) {
            evChargingStationService.deleteStation(id);
    }
}
