package sensor;

import room.Room;

//factory for building different sensors.
public class SensorFactory {
	public Sensor buildRightSensor(Room r){
		
		return new RightSensor(r);
	};
	
	public Sensor buildLeftSensor(Room r ){
		return new LeftSensor(r);
	}
	
	public Sensor buildBackSensor(Room r){
		
		return new BackSensor(r);
	};
	
	public Sensor buildFrontSensor(Room r){
		return new FrontSensor(r);
	}
	
}
