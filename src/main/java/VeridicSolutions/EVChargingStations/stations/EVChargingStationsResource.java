package VeridicSolutions.EVChargingStations.stations;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EVChargingStationsResource {

    @RequestMapping("/show")
    public String showAllStations(){
        return "We will add all beans here!";
    }
}
