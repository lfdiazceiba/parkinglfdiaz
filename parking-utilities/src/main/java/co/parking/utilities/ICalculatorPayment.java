package co.parking.utilities;

import co.parking.enumeration.TypeVehicle;
import co.parking.model.ParkingTime;

public interface ICalculatorPayment {

  public int calcPaymentVehicle(TypeVehicle typeVehicle, int displacementVehicle,
      ParkingTime parkingTime);
}
