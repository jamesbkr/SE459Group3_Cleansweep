package room;

import static org.junit.Assert.*;
import org.junit.*;

public class RoomStatusTest {
	RoomStatus rs = new RoomStatus(ThingsInRoom.BASE,CleanRoom.CLEAN);
	
	@Test
	public void isCleanTest(){
		assertEquals(CleanRoom.CLEAN,rs.getIsClean());
	}
	
	@Test
	public void typrFloorTest(){
		assertEquals(ThingsInRoom.BASE,rs.getTypeOfFloor());
	}
	
	
	
	
}
