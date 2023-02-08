package VeridicSolutions.EVChargingStations.stations;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EVChargingStationsResource {

    @RequestMapping("/show")
    public EVChargingStation showAllStations(){
        return  new EVChargingStation("1","Green Zone",
                        "$132","Pic1","Vancouver,Austin TX");
    }
}
