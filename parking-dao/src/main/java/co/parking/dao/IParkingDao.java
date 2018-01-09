package co.parking.dao;

import co.parking.enumeration.TypeVehicle;
import co.parking.model.Parking;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParkingDao extends JpaRepository<Parking, Long>  {

  List<Parking> findByExitDate(Date exitDate);

  Parking findFirstByLicensePlateVehicleAndExitDate(String licensePlateVehicle, Date exitDate);

  boolean existsByLicensePlateVehicleAndExitDate(String licensePlateVehicle, Date exitDate);

  long countByTypeVehicleAndExitDate(TypeVehicle typeVehicle, Date exitDate);
}
