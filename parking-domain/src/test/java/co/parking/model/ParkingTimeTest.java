package co.parking.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParkingTimeTest {

	@Test
	public void createParkingTimeObjectTest() {
		
		int days    = 3;
		int hours   = 4;
		int minutes = 30;
		
		ParkingTime parkingTime = new ParkingTime(days, hours, minutes);
		
		assertEquals(days, parkingTime.getDays());
		assertEquals(hours, parkingTime.getHours());
		assertEquals(minutes, parkingTime.getMinutes());	
	}
	
	@Test
	public void compareParkingTimeObjectsTest() {
		
		int days    = 3;
		int hours   = 4;
		int minutes = 30;
		
		ParkingTime parkingTime = new ParkingTime(days, hours, minutes);
		ParkingTime otherParkingTime = new ParkingTime(days, hours, minutes);
		
		assertTrue(parkingTime.equals(otherParkingTime));	
	}

}
