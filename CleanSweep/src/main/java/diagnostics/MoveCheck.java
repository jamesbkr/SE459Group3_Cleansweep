package diagnostics;
import java.util.LinkedList;

import room.Point;
import vacuum.*;

public class MoveCheck {
	public MoveCheck checkmovement(Vacuum vacuumSource){
		
		Point thecurrentlocation= vacuumSource.getCurrentLocation();
		//Point secondpoint= getNextMove(thecurrentlocation);
		//Need to call a move?
		LinkedList<Point> returnlist= vacuumSource.returnlist();
		Point lastpoint= returnlist.getLast();
		
		if (thecurrentlocation == lastpoint){
			System.out.println("Error: new location is equal to "+lastpoint);
		}
		else{
			System.out.println("New point valid: "+ thecurrentlocation);
		}
				
		return null;
	}

}
