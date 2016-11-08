package vacuum;

import static org.junit.Assert.*;

import org.junit.*;

import room.Point;

public class VacuumTest {

	Vacuum v = new Vacuum("harry");
	Point p = new Point(0,0);
	@Test 
	public void cuurrentLocation(){
		assertEquals(p,v.getCurrentLocation());	
	}
	
/*	@Test
	public void testReturn(){
		
		assertEquals(p,v.returnToBase());
	}
	*/
	@Test
	public void testShutdown(){
		
		assertEquals(p,v.shutDown(p));
	}
	
	
	
	@Test 
	public void storageCheck(){
		assertEquals(100,v.checkBatteryLife());
		v.batteryLife -= 1;
		assertEquals(99,v.checkBatteryLife());
		
	}
	
	@Test
	public void batteryCheck(){
		assertEquals(50,v.checkStorage());
		v.storage -= 1;
		assertEquals(49,v.checkStorage());
	}
	@Test
	public void checkLocation(){
		assertEquals(new Point(0,0),v.getCurrentLocation());
		
	}
	
	@Test
	public void checkSensorCheck(){
		
		assertTrue(v.sensorArray == v.checkSensor());
		
	}
	
	@Test 
	public void stringTest(){
		assertEquals("HELLO FROM harry",v.toString());
	}
	
}
