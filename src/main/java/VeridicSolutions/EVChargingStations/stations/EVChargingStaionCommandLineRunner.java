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

        List<EVChargingStation> allById = repository.findAllById(List.of("46", "45"));
        allById.stream().forEach(station -> System.out.println(station));

    }
}
