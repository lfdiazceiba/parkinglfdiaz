package co.parking.service.impl;

import static org.junit.Assert.*;

import static org.mockito.Mockito.when;

import co.parking.dao.IParkingDao;
import co.parking.enumeration.TypeVehicle;
import co.parking.model.Parking;
import co.parking.service.IvigilantService;
import co.parking.service.configuration.ServicesConfiguration;
import co.parking.utilities.IManagerTime;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServicesConfiguration.class)
@DataJpaTest
public class VigilantServiceImplTest {

  @Autowired
  private IParkingDao parkingDao;

  @SpyBean
  private IManagerTime managerTime;
  
  @Autowired
  private IvigilantService vigilantService;

  @Test
  public void whenCallcheckParkedVehicleThenReturnListParkedVehicle() {

    Parking parkingExpected =
        new Parking(Calendar.getInstance().getTime(), "X-DER-45", 500, TypeVehicle.CAR);
    parkingDao.save(parkingExpected);

    List<Parking> parkings = vigilantService.checkParkedVehicle();

    assertEquals(parkingExpected, parkings.get(0));
  }

  @Test
  public void whenCallLendParkingThenParkAVehicle() {

    Parking parkingExpected =
        new Parking(Calendar.getInstance().getTime(), "X-DER-45", 500, TypeVehicle.CAR);

    vigilantService.lendParking(parkingExpected);

    Parking parking = parkingDao
        .findFirstByLicensePlateVehicleAndExitDate(parkingExpected.getLicensePlateVehicle(), null);

    assertEquals(parkingExpected, parking); 
  }

  @Test
  public void whenCallBillParkedVehicleThenInvoiceAParkedVehicle() {

    Calendar calendar = Calendar.getInstance();
    calendar.set(2018,0,4,13,26);
    Date initialDate = calendar.getTime();
    calendar.set(2018,0,5,17,45);
    Date finalDate = calendar.getTime();
    
    Parking parking =
        new Parking(initialDate, "X-DER-45", 500, TypeVehicle.CAR);
    
    parkingDao.save(parking);
    
    when(managerTime.currentDate()).thenReturn(finalDate);

    Parking parkingWithPayment =
        vigilantService.billParkedVehicle(parking.getLicensePlateVehicle());
    
    assertEquals(13000,parkingWithPayment.getPayment());

  }
}
