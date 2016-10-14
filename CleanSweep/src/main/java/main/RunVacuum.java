package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import room.Point;
import room.Room;
import room.RoomStatus;
import room.ThingsInRoom;
import vacuum.*;
import diagnostics.*;
//Main class to test running the vacuum
public class RunVacuum {

	public static void main(String[] args) {
			ArrayList<String> powerLog= new ArrayList<String>();
			ArrayList<String> storageLog= new ArrayList<String>();
		
			Vacuum firstVacuum = new Vacuum("henry", new HashMap<Point, RoomStatus>());
			
			System.out.println(firstVacuum.toString());
			
			
			powerLog.add(PowerCheck.PowerCheck(firstVacuum));
			storageLog.add(StorageCheck.Diagnostic(firstVacuum));
			
	}		

}
