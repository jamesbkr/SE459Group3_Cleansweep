package vacuum;

import static org.junit.Assert.*;

import org.junit.*;

import room.Point;

public class VacuumTest {

	Vacuum v = new Vacuum("harry");
	
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
	public void stringTest(){
		assertEquals("HELLO FROM harry",v.toString());
	}
	
}
