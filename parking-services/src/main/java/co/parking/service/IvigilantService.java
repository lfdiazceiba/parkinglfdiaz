package co.parking.service;

import co.parking.model.Parking;

import java.util.List;

public interface IvigilantService {

  public void lendParking(Parking parking);

  public Parking billParkedVehicle(String licensePlate);

  public List<Parking> checkParkedVehicle();
}
