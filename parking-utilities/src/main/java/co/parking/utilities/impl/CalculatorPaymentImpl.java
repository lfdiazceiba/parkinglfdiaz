package co.parking.utilities.impl;

import co.parking.enumeration.TypeVehicle;
import co.parking.model.ParkingTime;
import co.parking.utilities.ICalculatorPayment;

public class CalculatorPaymentImpl implements ICalculatorPayment {

  public static final  int CAR_DAY_RATE                   = 8000;
  public static final  int CAR_HOUR_RATE                  = 1000;
  public static final  int MOTORCYCLE_DAY_RATE            = 4000;
  public static final  int MOTORCYCLE_HOUR_RATE           = 500;
  public static final  int MOTORCYCLE_DISPLACEMENT_RATE   = 2000;
  
  public static final  int  START_HOUR_FOR_DAY_RATE                = 9;
  public static final  int  LIMIT_MOTORCYCLE_DISPLACEMENT_FOR_RATE = 500;

  @Override
  public int calcPaymentVehicle(TypeVehicle typeVehicle, int displacementVehicle,
      ParkingTime parkingTime) {
    
    int payment = 0;
    
    if (typeVehicle == TypeVehicle.CAR) {
      payment = calcPayment(parkingTime,CAR_DAY_RATE,CAR_HOUR_RATE);
    } else if (typeVehicle == TypeVehicle.MOTORCYCLE) {
      payment = calcPayment(parkingTime,MOTORCYCLE_DAY_RATE,MOTORCYCLE_HOUR_RATE);
      
      if (displacementVehicle > LIMIT_MOTORCYCLE_DISPLACEMENT_FOR_RATE) {
        payment += MOTORCYCLE_DISPLACEMENT_RATE;
      }
    }
    
    return payment;
  }
  
  private int calcPayment(ParkingTime parkingTime,int dayRate, int hourRate) {
    
    int payment = parkingTime.getDays() * dayRate;

    if (parkingTime.getMinutes() != 0) {
      parkingTime.setHours(parkingTime.getHours() + 1);
    }

    if (parkingTime.getHours() >= START_HOUR_FOR_DAY_RATE) {
      payment += dayRate;
    } else {
      payment += hourRate * parkingTime.getHours();
    }
    
    return payment;
  }

}

