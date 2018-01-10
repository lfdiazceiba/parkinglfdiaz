package co.parking.model;

import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import co.parking.enumeration.TypeVehicle;

public class ParkingTest {

  @Test
  public void createParkingObjectTest() {

    String licensePlateVehicle = "AZ-34";
    int displacementVehicle    = 500;
    Date date = Calendar.getInstance().getTime();
    TypeVehicle typeVehicle = TypeVehicle.CAR;

    Parking parking = new Parking(date, licensePlateVehicle, displacementVehicle, typeVehicle);

    assertEquals(licensePlateVehicle, parking.getLicensePlateVehicle());
    assertEquals(displacementVehicle, parking.getDisplacementVehicle());
    assertEquals(typeVehicle, parking.getTypeVehicle());    
  }

  @Test
  public void equalsParkingObjectsTest() {

    String licensePlateVehicle = "AZ-34";
    int displacementVehicle    = 500;
    Date date = Calendar.getInstance().getTime();
    TypeVehicle typeVehicle = TypeVehicle.CAR;

    Parking parking = new Parking(date, licensePlateVehicle, displacementVehicle, typeVehicle);
    Parking otherParking = new Parking(date, licensePlateVehicle, displacementVehicle, typeVehicle);

    assertTrue(parking.equals(otherParking));
  }

  @Test
  public void compareHashcodeParkingObjectTest() {

    String licensePlateVehicle = "AZ-34";
    int displacementVehicle    = 500;
    Date date = Calendar.getInstance().getTime();
    TypeVehicle typeVehicle = TypeVehicle.CAR;

    Parking parking = new Parking(date, licensePlateVehicle, displacementVehicle, typeVehicle);
    Parking otherParking = new Parking(date, licensePlateVehicle, displacementVehicle, typeVehicle);
    
    int hascodeParking      = parking.hashCode();
    int hascodeOtherParking = otherParking.hashCode();
    
    assertTrue(hascodeParking == hascodeOtherParking);

  }
  
  @Test
  public void setParkingTest() {
    long id = 0;
    String licensePlateVehicle = "AZ-34";
    int displacementVehicle    = 500;
    Date initialdate = Calendar.getInstance().getTime();
    Date finaldate = Calendar.getInstance().getTime();
    TypeVehicle typeVehicle = TypeVehicle.CAR;
    int payment = 3000;
    
    Parking parking = new Parking();
    
    parking.setId(id);
    parking.setEntryDate(initialdate);
    parking.setLicensePlateVehicle(licensePlateVehicle);
    parking.setDisplacementVehicle(displacementVehicle);
    parking.setTypeVehicle(typeVehicle);
    parking.setPayment(payment);
    parking.setExitDate(finaldate);
    
    assertEquals(id, parking.getId());
    assertEquals(initialdate, parking.getEntryDate());
    assertEquals(licensePlateVehicle, parking.getLicensePlateVehicle());
    assertEquals(displacementVehicle, parking.getDisplacementVehicle());
    assertEquals(typeVehicle, parking.getTypeVehicle());
    assertEquals(payment, parking.getPayment());
    assertEquals(finaldate, parking.getExitDate());
    
  }

}
