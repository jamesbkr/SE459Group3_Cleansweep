package diagnostics;

import static org.junit.Assert.*;

import org.junit.*;

import vacuum.Vacuum;
import diagnostics.PowerCheck;

public class PowerCheckTest {

	
	Vacuum v = new Vacuum("harry");
	Vacuum v2= new Vacuum("harry2");
	
	public void testPowerCheck(){
		Float holder=v.checkBatteryLife();
		String testholder1= PowerCheck.PowerCheck(v);
		String testholder2= PowerCheck.PowerCheck(v2);
		
		assertEquals(testholder1,testholder2);
	}
}
