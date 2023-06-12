package VeridicSolutions.EVChargingStations.stations.springdatajpa;

import VeridicSolutions.EVChargingStations.stations.EVChargingStation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataJpaRepository extends JpaRepository<EVChargingStation,String> {

}
