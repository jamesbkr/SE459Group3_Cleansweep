package diagnostics;
import vacuum.*;

public class PowerCheck {
	
	//Just a basic if statement prompt scanning the vacuum.
	//Do we want this to be a simple check or a process that goes through every move of the vacuum?
	//If so I think we can add a token here just for passing sake either an int or something for the all clear
	//Basically 0 for good to go, 1 for empty me, and 2 for complete error
	public static PowerCheck Diagnostic(Vacuum vacuumSource){
		int batterylife = vacuumSource.checkBatteryLife();
		//int token = 0;
		if (batterylife==100){
			System.out.println( "Battery Fully Charged: "+ batterylife+"%") ;	
			//token= 0;
		}else if (batterylife==0){
			System.out.println( "Please Charge : Battery Empty: "+ batterylife+"%" );
			//token=1;
			//Create a recharge token? to prompt returning to recharge base
		}else if (batterylife<0){
			System.out.println( "Error Batterylife at " + batterylife);
			//token=2;
			// Do we actually want to add an error throw or anything of the like.
		}else{
			System.out.println("Battery at: "+ batterylife);
			//token=0;
		}
		
		// Holding onto return statement if we need it to return a certificate or validation of some sort
		return null;
		
	}
}
