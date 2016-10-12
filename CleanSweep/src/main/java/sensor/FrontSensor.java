package sensor;

import room.ThingsInRoom;


//Front sensor 
public class FrontSensor implements Sensor {

	
	
// Sense classs with fake return for the sensor data	
	public ThingsInRoom sense() {
		// TODO Auto-generated method stub
		return ThingsInRoom.LOWPILE;
	}

}
