package co.parking.utilities.impl;

import static org.junit.Assert.assertEquals;

import co.parking.enumeration.TypeVehicle;
import co.parking.model.ParkingTime;
import co.parking.utilities.ICalculatorPayment;
import co.parking.utilities.configuration.UtilitiesConfiguration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=UtilitiesConfiguration.class)
public class CalculatorPaymentImplTest {
  
  @Autowired	
  private ICalculatorPayment calculatorPayment;
  
  
  @Test
  public void givenACarAndDisplacementAndParkingTimeWhenCallCalcPaymentVehicleThenReturnPayment() {
    
    ParkingTime parkingTime = new ParkingTime(1,4,30);
    
    int payment = calculatorPayment.calcPaymentVehicle(TypeVehicle.CAR,500,parkingTime);
    
    assertEquals(13000,payment);
    
  }
  
  @Test
  public void givenACarAndDisplacementAndParkingTimeWithHoursGreaterThan8WhenCallCalcPaymentVehicleThenReturnPayment() {
    
    ParkingTime parkingTime = new ParkingTime(1,9,0);
    
    int payment = calculatorPayment.calcPaymentVehicle(TypeVehicle.CAR,500,parkingTime);
    
    assertEquals(16000,payment);
    
  }
  
  @Test
  public void givenAMotorcycleAndDisplacementAndParkingTimeWhenCallCalcPaymentVehicleThenReturnPayment() {
    
    ParkingTime parkingTime = new ParkingTime(1,4,0);
    
    int payment = calculatorPayment.calcPaymentVehicle(TypeVehicle.MOTORCYCLE,500,parkingTime);
    assertEquals(6000,payment);
    
  }
  
  @Test
  public void givenAMotorcycleAndDisplacementGreaterThan500AndParkingTimeWhenCallCalcPaymentVehicleThenReturnPayment() {
    
    ParkingTime parkingTime = new ParkingTime(1,4,30);
    
    int payment = calculatorPayment.calcPaymentVehicle(TypeVehicle.MOTORCYCLE,600,parkingTime);
    assertEquals(8500,payment);
    
  }

}
