package VeridicSolutions.EVChargingStations.stations.springdatajpa;

import VeridicSolutions.EVChargingStations.stations.EVChargingStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataJpaRepository extends JpaRepository<EVChargingStation,String> {

}
