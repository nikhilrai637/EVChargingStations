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

        repository.save(new EVChargingStation("45","Indian Oil"
                            ,"$45","TV ad","Timarpur"));
        repository.save(new EVChargingStation("46","Hindustan Oil"
                ,"$32","Hindustan Petroleum","Bhajanpura"));
        repository.save(new EVChargingStation("1","Green Zone",
                "$132","Pic1","Vancouver,Austin TX"));
        repository.save(new EVChargingStation("2","Green Zone",
                "$132","Pic1","Vancouver,Austin TX"));
        repository.save(new EVChargingStation("3","Green Zone",
                "$132","Pic1","Vancouver,Austin TX"));
        repository.save(new EVChargingStation("4","Green Zone",
                "$132","Pic1","Vancouver,Austin TX"));
        repository.save(new EVChargingStation("5","Green Zone",
                "$132","Pic1","Vancouver,Austin TX"));
        
    }
}
