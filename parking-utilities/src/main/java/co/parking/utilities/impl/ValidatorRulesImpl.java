package co.parking.utilities.impl;

import co.parking.enumeration.TypeVehicle;
import co.parking.exception.ParkingException;
import co.parking.model.Parking;
import co.parking.utilities.IValidatorRules;
import java.util.Calendar;
import java.util.Date;

public class ValidatorRulesImpl implements IValidatorRules {

  public static final char LETTER_LICENSE_PLATE = 'A';

  public static final String NO_PARKING_FOR_CAR =
      "No hay estacionamiento disponible para el parqueo de carros";

  public static final String NO_PARKING_FOR_MOTORCYCLE =
      "No hay estacionamiento disponible para el parqueo de motos";

  public static final String NO_EXIST_INFORMATION = "No existe informaci�n del parqueo";

  public static final String INCOMPLETE_INFROMATION = "Informaci�n incompleta del parqueo";

  public static final String NO_PARKING_VEHICLES =
      "Los vehiculos con placas que comiencen con la letra A solo pueden parquearse los dias Domingo y Lunes";

  public static final String NO_PARKING_WITH_SAME_LICENSE_PLATE =
      "Existe un vehiculo parqueado con dicha placa, no es posible parquear vehiculos con la misma placa";

  public static final int NUMBER_CAR_PARKING = 20;

  public static final int NUMBER_MOTORCYCLE_PARKING = 10;

  @Override
  public void verifyParkingData(Parking parking) {

    if (parking == null) {
      throw new ParkingException(NO_EXIST_INFORMATION);
    }

    if (parking.getEntryDate() == null || parking.getLicensePlateVehicle() == null
        || parking.getTypeVehicle() == null || parking.getDisplacementVehicle() <= 0) {
      throw new ParkingException(INCOMPLETE_INFROMATION);
    }

    if(parking.getLicensePlateVehicle().isEmpty()) {
      throw new ParkingException(INCOMPLETE_INFROMATION);
    }
  }

  @Override
  public void verifyLicensePlate(String licensePlateVehicle, Date date, boolean isParked) {

    if (isParked) {
      throw new ParkingException(NO_PARKING_WITH_SAME_LICENSE_PLATE);
    }

    char letter = licensePlateVehicle.charAt(0);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    if (letter == LETTER_LICENSE_PLATE && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY
        && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
      throw new ParkingException(NO_PARKING_VEHICLES);
    }
  }

  @Override
  public void verifyParkingAvailable(TypeVehicle typeVehicle, int numberParkedVehicle) {

    if (typeVehicle == TypeVehicle.CAR && numberParkedVehicle >= NUMBER_CAR_PARKING) {
      throw new ParkingException(NO_PARKING_FOR_CAR);
    } else if (typeVehicle == TypeVehicle.MOTORCYCLE
        && numberParkedVehicle >= NUMBER_MOTORCYCLE_PARKING) {
      throw new ParkingException(NO_PARKING_FOR_MOTORCYCLE);
    }
  }
}
