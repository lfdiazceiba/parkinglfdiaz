package co.parking.api.impl;

import co.parking.api.IParkingApi;
import co.parking.model.Parking;
import co.parking.service.IvigilantService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkingApiImpl implements IParkingApi {

  @Autowired
  private IvigilantService vigilantService;

  @Override
  public List<Parking> getParkings() {

    return vigilantService.checkParkedVehicle();
  }

  @Override
  public void registerParking(Parking parking) {
    vigilantService.lendParking(parking);

  }

  @Override
  public Parking billParking(String licensePlate) {


    return vigilantService.billParkedVehicle(licensePlate);
  }
}
