package diagnostics;
import static org.junit.Assert.*;
import org.junit.*;
import vacuum.Vacuum;
import diagnostics.StorageCheck;

public class StorageCheckTest {
	
	Vacuum v = new Vacuum("harry");
	Vacuum v2= new Vacuum("harry2");
	
	public void testStorageCheck(){
		int holder=v.checkBatteryLife();
		String testholder1= StorageCheck.Diagnostic(v);
		String testholder2= StorageCheck.Diagnostic(v2);
		
		assertEquals(testholder1,testholder2);
	}
}
