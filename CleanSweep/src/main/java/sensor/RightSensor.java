package sensor;

import room.ThingsInRoom;

//Right sensor
public class RightSensor implements Sensor {

// Sense classs with fake return for the sensor data		
	public ThingsInRoom sense() {
		// TODO Auto-generated method stub
		return ThingsInRoom.HIGHPILE;
	}

}
