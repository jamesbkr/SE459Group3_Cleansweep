package diagnostics;
import sensor.*;
import vacuum.*;
public class SensorCheck {
	//Since sensors aren't completely built don't know exactly how were going to check them
	public Sensor[] SensorCheck(Vacuum vacuumSource){
		
		Sensor[] sensorCheck= vacuumSource.checkSensor();
		
		
		// Filler for sensor check
		return null;
	}
	
}
