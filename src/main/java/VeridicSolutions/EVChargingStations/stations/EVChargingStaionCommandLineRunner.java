package VeridicSolutions.EVChargingStations.stations;

import VeridicSolutions.EVChargingStations.stations.springdatajpa.SpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EVChargingStaionCommandLineRunner implements CommandLineRunner {
    @Autowired
    private SpringDataJpaRepository repository;
    @Override
    public void run(String... args) throws Exception {

        repository.save(new EVChargingStation("1","Indian Oil"
                            ,"$45","TV ad","Timarpur"));
        repository.save(new EVChargingStation("2","Hindustan Oil"
                ,"$32","Hindustan Petroleum","Bhajanpura"));
        repository.save(new EVChargingStation("3","Green Zone",
                "$45","Pic1","Minnepolis"));
        repository.save(new EVChargingStation("4","Area 51",
                "$60","Pic20","San diego"));
        repository.save(new EVChargingStation("5","Indiana",
                "$75","Pic25","Washington DC"));
        repository.save(new EVChargingStation("6","Truck Station",
                "$90","Pic30","Vegas"));
        repository.save(new EVChargingStation("7","The Chargers",
                "$105","Pic35","London"));
        repository.save(new EVChargingStation("8","EV Plugin Charge",
                "$120","Pic40","2nd Floor, 39, Shahpur Jat, New Delhi, Delhi 110049"));
        repository.save(new EVChargingStation("9","Shri Subhash E Rikshaw Charging Point",
                "$135","Pic45"," Uttam Nagar, Hastsal, Delhi, 110059"));
        repository.save(new EVChargingStation("10","EVI Technologies",
                "$150","Pic50","11, Electropreneur Park, G/116, Benito Juarez Marg, Sector 3, Block G, South Moti Bagh, New Delhi, Delhi 110021"));

    }
}
