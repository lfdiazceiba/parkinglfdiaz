package co.parking.utilities.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import co.parking.model.ParkingTime;
import co.parking.utilities.IManagerTime;
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
public class ManagerTimeImplTest {
  
  @Autowired
  private IManagerTime managerTime;
   

  @Test
  public void wheCallCurrenDateThenReturnADateObject() {

    Date actualDate = managerTime.currentDate();

    assertNotNull(actualDate);
  }
  
  @Test
  public void whenCallCalcRangeTimeThenCalculateRangeTime() {
    
    Calendar calendar = Calendar.getInstance();
    calendar.set(2018,0,4,13,26);
    Date initialDate = calendar.getTime();
    calendar.set(2018,0,5,17,45);
    Date finalDate = calendar.getTime();
    ParkingTime parkingTimeExpcted = new ParkingTime(1, 4, 19);
    
    ParkingTime parkingTime = managerTime.calcRangeTime(initialDate, finalDate);
    
    assertEquals(parkingTimeExpcted, parkingTime);
    
  }
}
