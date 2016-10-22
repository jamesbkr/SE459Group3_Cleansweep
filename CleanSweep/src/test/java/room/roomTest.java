package room;
import static org.junit.Assert.*;
import org.junit.*;
public class roomTest {
	
	Room r = new Room();
	Point p = new Point(0,0);
	RoomStatus rs = new RoomStatus(ThingsInRoom.BASE,CleanRoom.CLEAN);
	
	@Test
	public void updateRoomTest(){
		r.updateLocation(p,rs);	
		assertTrue(r.getRoom().keySet().size() == 1);
	}
	
	
	@Test
	public void getRoomTest(){
		Room g = r;
		
		assertEquals(g.getRoom(),r.getRoom());
		
	}
	
	@Test
	public void checkPointTest(){
		r.updateLocation(p, rs);
		assertEquals(CleanRoom.CLEAN, r.checkPoint(p));
		
	}
	
	@Test
	public void checkthingTest(){
		r.updateLocation(p,rs);
		assertEquals(ThingsInRoom.BASE, r.checkTypeOfFloor(p));
		
	}
	
	
	

}
