package diagnostics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import vacuum.*;

public class PowerCheck {
	
	//Logs activity to console and logger file 
	private static final String LOGGER_FILE_NAME = "logger.txt";
			
	//Just a basic if statement prompt scanning the vacuum.
	//Do we want this to be a simple check or a process that goes through every move of the vacuum?
	// Made it strings so we can add them to an ArrayList if possible for the Activity Log

	
	//Left over tokens from other idea
	//Basically 0 for good to go, 1 for no charge left, and 2 for complete error
	public static String PowerCheck(Vacuum vacuumSource){
		Float batterylife = vacuumSource.checkBatteryLife();
		String activityHolder;
		//Integer token = 0;
		if (batterylife==100){
			System.out.println( "Battery Fully Charged: "+ batterylife+"%") ;	
			activityHolder= "Battery Fully Charged: "+ batterylife+"%";
			writeToFile(LOGGER_FILE_NAME, activityHolder);
			//token= 0;
		}else if (batterylife==0){
			System.out.println( "Please Charge : Battery Empty: "+ batterylife+"%" );
			activityHolder= "Please Charge : Battery Empty: "+ batterylife+"%" ;
			writeToFile(LOGGER_FILE_NAME, activityHolder);
			//token= 1;
			//Create a recharge token? to prompt returning to recharge base
		}else if (batterylife<0){
			System.out.println( "Error Batterylife at " + batterylife);
			activityHolder= "Error Batterylife at " + batterylife;
			writeToFile(LOGGER_FILE_NAME, activityHolder);
			//token= 2;
			// Do we actually want to add an error throw or anything of the like.
		}else{
			System.out.println("Battery at: "+ batterylife);
			activityHolder="Battery at: "+ batterylife;
			writeToFile(LOGGER_FILE_NAME, activityHolder);
		}
		
		
		// Holding onto return statement if we need it to return a certificate or validation of some sort
		//return token;
		return activityHolder;
		
	}
	private static void writeToFile(String fileName, String msg) {
		FileWriter fw;
		BufferedWriter bw = null;

		try {
			createDirectory();

			//create new file in the tracking folder:
			File outputFile = new File("tracking", fileName);

			if (outputFile.createNewFile()) {
				System.out.println("New file created: " + fileName);
			}

			fw = new FileWriter(outputFile.getPath(), true);
			bw = new BufferedWriter(fw);

			System.out.println(msg);
			bw.write(msg);
			bw.write(System.getProperty("line.separator"));
		} catch (IOException e) {
			System.out.println("Error when attempting to write to file: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (Exception ex) {
				// at least we tried
			}
		}
	}

	private static void createDirectory() {
		//create the "tracking" directory if one does not already exist:
		File trackingDirectory = new File("tracking");

		// if the directory does not exist, create it
		if (!trackingDirectory.exists()) {
			trackingDirectory.mkdir();
			System.out.println("tracking directory created");
		}
	}
}
