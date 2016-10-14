package diagnostics;
import vacuum.*;
public class StorageCheck {
	//Just a basic if statement prompt scanning the vacuum.
	//Do we want this to be a simple check or a process that goes through every move of the vacuum?
	//If so I think we can add a token here just for passing sake either an int or something for the all clear
	// Also Activity Log framework, just ArrayList for now.
	
	//Left over tokens from other idea
	//Basically 0 for good to go, 1 for empty me, and 2 for complete error
	public static String Diagnostic(Vacuum vacuumSource){
		int storage = vacuumSource.checkStorage();
		String activityHolder;
		if (storage==50){
			System.out.println( "Storage Capacity Left: "+ storage) ;
			activityHolder= "Storage Capacity Left: "+ storage;
		}else if (storage==0){
			System.out.println( "Empty Me!" );
			activityHolder= "Empty Me!" ;
			//Simple prompt tie into halting
			//token= 1;
		}else if (storage<0){
			System.out.println( "Error storage at " + storage);
			activityHolder= "Error storage at " + storage;
			//Do we actually want to add an error throw?
			//token = 2
		}else{
			System.out.println("Capacity left: "+ storage);
			activityHolder= "Capacity left: "+ storage;
			//token = 0;
		}
		//return token;
		return activityHolder;
	}

}
