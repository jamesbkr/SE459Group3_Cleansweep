package sensor;

import room.ThingsInRoom;


// Back Sensor 
public class BackSensor implements Sensor {

// Sense classs with fake return for the sensor data	
	public ThingsInRoom sense() {
		// TODO Auto-generated method stub
		return ThingsInRoom.BAREFLOOR;
	}

}
