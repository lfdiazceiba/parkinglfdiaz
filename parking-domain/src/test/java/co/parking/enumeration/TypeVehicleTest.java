package co.parking.enumeration;

import static org.junit.Assert.*;

import org.junit.Test;

public class TypeVehicleTest {

	@Test
	public void CreateTypeVehicleTest() {
		TypeVehicle typeVehicle = TypeVehicle.CAR;
		
		assertEquals(TypeVehicle.CAR,typeVehicle);
	}
}
