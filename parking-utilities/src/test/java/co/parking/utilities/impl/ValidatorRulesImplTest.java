package co.parking.utilities.impl;

import co.parking.enumeration.TypeVehicle;
import co.parking.exception.ParkingException;
import co.parking.model.Parking;
import co.parking.utilities.IValidatorRules;
import co.parking.utilities.configuration.UtilitiesConfiguration;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=UtilitiesConfiguration.class)
public class ValidatorRulesImplTest {

  @Autowired
  private IValidatorRules validatorRules;

  @Test(expected = ParkingException.class)
  public void givenANullObjectWhenCallverifyParkingDataTestThenThowParKingException() {
    validatorRules.verifyParkingData(null);
  }

  @Test(expected = ParkingException.class)
  public void givenAParkingObjectWithoutInformationWhenCallverifyParkingDataTestThenThowParKingException() {
    Parking parking = new Parking();
    validatorRules.verifyParkingData(parking);
  }
  
  @Test(expected = ParkingException.class)
  public void givenAParkingWithoutLicensePlateWhenCallverifyParkingDataTestThenThowParKingException() {
    Parking parking = new Parking(Calendar.getInstance().getTime(), "", 20, TypeVehicle.CAR);
    validatorRules.verifyParkingData(parking);
  }
  
  @Test
  public void givenAParkingObjectWhenCallverifyParkingDataTestThenDoNothing() {
    Parking parking = new Parking(Calendar.getInstance().getTime(), "XZ-45-SE",500,TypeVehicle.CAR);
    validatorRules.verifyParkingData(parking);
  }
  
  @Test(expected = ParkingException.class)
  public void givenNumberCarParkedwhenCallverifyParkingAvailableThenThrowParkingException() {
    validatorRules.verifyParkingAvailable(TypeVehicle.CAR, 20);
  }
  
  @Test
  public void givenNumberCarParkedwhenCallverifyParkingAvailableThenDoNothing() {
    validatorRules.verifyParkingAvailable(TypeVehicle.CAR, 18);
  }
  
  @Test
  public void givenNumberMotorcycleParkedwhenCallverifyParkingAvailableThenDoNothing() {
    validatorRules.verifyParkingAvailable(TypeVehicle.MOTORCYCLE, 4);
  }
  
  @Test(expected = ParkingException.class)
  public void givenNumberMotorcycleParkedwhenCallverifyParkingAvailableThenThrowParkingException() {
    validatorRules.verifyParkingAvailable(TypeVehicle.MOTORCYCLE,10);
  }
  
  @Test(expected = ParkingException.class)
  public void givenALicensePlateParkedWhenCallverifyLicensePlateThenThrowParkingException() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(2017,0, 4);
    Date date = calendar.getTime();
    
    validatorRules.verifyLicensePlate("XZ-45-SE", date, true);
  }
  
  @Test(expected = ParkingException.class)
  public void givenALicensePlateWhenCallverifyLicensePlateThenThrowParkingException() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(2017,0, 4);
    Date date = calendar.getTime();
    
    validatorRules.verifyLicensePlate("AXZ-45-SE", date, false);
  }
  
  @Test
  public void whenCallverifyLicensePlateThenThrowParkingException() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(2017,0, 4);
    Date date = calendar.getTime();
    
    validatorRules.verifyLicensePlate("DXZ-45-SE", date, false);
  } 
}
