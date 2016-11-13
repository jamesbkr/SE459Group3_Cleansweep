package vacuum;

import static org.junit.Assert.*;

import org.junit.*;

import room.Point;
import room.ThingsInRoom;

import java.util.ArrayList;
import java.util.LinkedList;

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
		assertEquals(100,v.checkBatteryLife().doubleValue(),0);
		v.batteryLife -= 1;
		assertEquals(99,v.checkBatteryLife().doubleValue(),0);
		
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

	@Test
	public void goBackToBaseTest() {
		v.returnlist = new LinkedList<>();
		v.returnlist.add(new Point(0,0));
		v.goBackToBase();
		assertEquals(v.returnlist.size(), 0);
	}

	@Test
	public void batteryRequiredForBareFloorTest() {
		float batteryRequired = v.getBatteryRequiredForFloorType(ThingsInRoom.BAREFLOOR);
		assertEquals(batteryRequired,1,0);
	}

	@Test
	public void batteryRequiredForLowPile() {
		float batteryRequired = v.getBatteryRequiredForFloorType(ThingsInRoom.LOWPILE);
		assertEquals(batteryRequired,2,0);
	}
	@Test
	public void batteryRequiredForHighPile() {
		float batteryRequired = v.getBatteryRequiredForFloorType(ThingsInRoom.HIGHPILE);
		assertEquals(batteryRequired,3,0);
	}
	@Test
	public void batteryRequiredForBase() {
		float batteryRequired = v.getBatteryRequiredForFloorType(ThingsInRoom.BASE);
		assertEquals(batteryRequired,0,0);
	}
}
