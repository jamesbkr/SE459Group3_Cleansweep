package diagnostics;
import vacuum.*;
public class StorageCheck {
	
	
	//Just a basic if statement prompt scanning the vacuum.
	//Do we want this to be a simple check or a process that goes through every move of the vacuum?
	//If so I think we can add a token here just for passing sake either an int or something for the all clear
	//Basically 0 for good to go, 1 for empty me, and 2 for complete error
	public static StorageCheck Diagnostic(Vacuum vacuumSource){
		int storage = vacuumSource.checkStorage();
		//int token = 0;
		if (storage==50){
			
			System.out.println( "Storage Capacity Left: "+ storage) ;		
			//token = 0;
		}else if (storage==0){
			
			System.out.println( "Empty Me!" );
			//Simple prompt tie into halting
			//token= 1;
		}else if (storage<0){
			System.out.println( "Error storage at " + storage);
			//Do we actually want to add an error throw?
			//token = 2
		}else{
			System.out.println("Capacity left: "+ storage);
			//token = 0;
		}
	
		
		return null;
	}

}
