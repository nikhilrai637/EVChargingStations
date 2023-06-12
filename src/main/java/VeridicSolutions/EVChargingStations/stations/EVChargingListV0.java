package VeridicSolutions.EVChargingStations.stations;
import org.springframework.hateoas.RepresentationModel;
import java.util.List;
public class EVChargingListV0 extends RepresentationModel<EVChargingListV0> {
    public EVChargingListV0(List<EVChargingStation> EVChargingList) {
        this.EVChargingList = EVChargingList;
    }

    private List<EVChargingStation> EVChargingList;

    public List<EVChargingStation> getEVChargingList() {
        return EVChargingList;
    }

    public void setEVChargingList(List<EVChargingStation> EVChargingList) {
        this.EVChargingList = EVChargingList;
    }
}
