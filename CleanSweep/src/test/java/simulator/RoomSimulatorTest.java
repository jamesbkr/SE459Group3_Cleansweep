package simulator;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.*;

import room.*;
import simulator.RoomSimulator;
public class RoomSimulatorTest {
	Room r = new Room();
	Point p = new Point(0,1);
	int[] i= {10,10};
	RoomSimulator rmSim = new RoomSimulator();
	
	
	@Test
	public void RoomSimulatorTest(){
		HashMap<Point,RoomStatus> room = rmSim.makeRoom(i);
		assertTrue(room.size()>i.length);
	}

	
}
