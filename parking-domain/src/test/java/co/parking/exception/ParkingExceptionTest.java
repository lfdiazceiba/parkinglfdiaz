package co.parking.exception;

import org.junit.Test;

public class ParkingExceptionTest {

	@Test(expected = ParkingException.class)
	public void throwParkingExceptionObjectTest() {
		throw new ParkingException("message expected");
	}
}
