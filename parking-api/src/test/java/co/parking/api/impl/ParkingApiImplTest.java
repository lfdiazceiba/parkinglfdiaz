package co.parking.api.impl;

import static org.junit.Assert.assertTrue;

import co.parking.dao.IParkingDao;
import co.parking.enumeration.TypeVehicle;
import co.parking.model.Parking;

import java.util.Calendar;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class ParkingApiImplTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private IParkingDao parkingDao;

  @Test
  public void whenCallGetParkingsThenReturnHttpStatusOk() {

    ResponseEntity<List> entity = restTemplate.getForEntity("/parking/all", List.class);

    assertTrue(entity.getStatusCode().equals(HttpStatus.OK));
  }

  @Test
  public void whenCallGetRegisterParkingThenHttpStatusNoContent() {

    Parking parking =
        new Parking(Calendar.getInstance().getTime(), "X-DER-45", 500, TypeVehicle.CAR);
    HttpEntity<Parking> httpParking = new HttpEntity<Parking>(parking);

    ResponseEntity<Void> entity =
        restTemplate.postForEntity("/parking/register", httpParking, Void.class);

    assertTrue(entity.getStatusCode().equals(HttpStatus.NO_CONTENT));
  }
  
  @Test
  public void whenCallGetRegisterParkingThenHttpStatusBadRequest() {

    Parking parking =
        new Parking(Calendar.getInstance().getTime(), null, 500, TypeVehicle.CAR);
    HttpEntity<Parking> httpParking = new HttpEntity<Parking>(parking);

    ResponseEntity<Void> entity =
        restTemplate.postForEntity("/parking/register", httpParking, Void.class);

    assertTrue(entity.getStatusCode().equals(HttpStatus.BAD_REQUEST));
  }

  @Test
  public void whenCallGetBillParkingThenHttpStatusNoContent() {

    Parking parking =
        new Parking(Calendar.getInstance().getTime(), "Z-DER-45", 500, TypeVehicle.CAR);
    parkingDao.save(parking);

    HttpEntity<String> httpString = new HttpEntity<String>("Z-DER-45");

    ResponseEntity<Parking> entity =
        restTemplate.exchange("/parking/bill", HttpMethod.PUT, httpString, Parking.class);

    assertTrue(entity.getStatusCode().equals(HttpStatus.OK));
  }

}
