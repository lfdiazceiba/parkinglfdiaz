package co.parking.utilities;

import co.parking.enumeration.TypeVehicle;

import co.parking.model.Parking;

import java.util.Date;

public interface IValidatorRules {

  public void verifyParkingData(Parking parking);

  public void verifyLicensePlate(String licensePlateVehicle,Date date, boolean isParked);

  public void verifyParkingAvailable(TypeVehicle typeVehicle, int numberParkedVehicle);
}
