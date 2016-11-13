package diagnostics;
import vacuum.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class StorageCheck {
	
	//Logs activity to console and logger file 
	private static final String LOGGER_FILE_NAME = "logger.txt";
	
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
			activityHolder= "Storage Capacity Left: "+ storage;
			System.out.println(activityHolder);
			writeToFile(LOGGER_FILE_NAME, activityHolder);
		}else if (storage==0){
			activityHolder= "Empty Me!" ;
			System.out.println(activityHolder);
			writeToFile(LOGGER_FILE_NAME, activityHolder);
			//Simple prompt tie into halting
			//token= 1;
		}else if (storage<0){
			activityHolder= "Error storage at " + storage;
			System.out.println(activityHolder);
			writeToFile(LOGGER_FILE_NAME, activityHolder);
			//Do we actually want to add an error throw?
			//token = 2
		}else{
			activityHolder= "Capacity left: "+ storage;
			System.out.println(activityHolder);
			writeToFile(LOGGER_FILE_NAME, activityHolder);
			//token = 0;
		}
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
