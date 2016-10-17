package sensor;

import static org.junit.Assert.*;
import org.junit.*;

import room.ThingsInRoom;
import vacuum.Vacuum;


public class SensorTest {
	Vacuum v = new Vacuum("henry");
	
	@Test
	public void testSensors(){
		for(Sensor s : v.sensorArray){
			assertEquals(ThingsInRoom.BAREFLOOR,s.sense());
		}
		
		
	}
	
	
	
}