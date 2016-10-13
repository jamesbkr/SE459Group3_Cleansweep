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
		
			Vacuum firstVacuum = new Vacuum("henry", new HashMap<Point, RoomStatus>());
			
			
			System.out.println(firstVacuum.toString());
			
			PowerCheck.Diagnostic(firstVacuum);
			StorageCheck.Diagnostic(firstVacuum);
			
	}		

}
