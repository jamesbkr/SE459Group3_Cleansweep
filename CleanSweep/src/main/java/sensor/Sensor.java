package sensor;

import room.Point;
import room.Room;
import room.ThingsInRoom;

public class Sensor {
	Room room;
	
	public Sensor(Room r){
		room = r;
		
	}
	
	public ThingsInRoom sense(Point p){
		
		return room.getRoom().get(p).getTypeOfFloor();
		
	};
	}
	
	

