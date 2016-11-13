package diagnostics;
import java.util.LinkedList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import room.Point;
import vacuum.*;

public class MoveCheck {
	
	private static final String LOGGER_FILE_NAME = "logger.txt";
	
	public static MoveCheck checkmovement(Vacuum vacuumSource){
		
		Point thecurrentlocation= vacuumSource.getCurrentLocation();
		//Point secondpoint= getNextMove(thecurrentlocation);
		//Need to call a move?
		LinkedList<Point> returnlist= vacuumSource.returnlist();
		Point lastpoint = null;
		if(!returnlist.isEmpty())
			lastpoint= returnlist.getLast();
		
		if (thecurrentlocation == lastpoint){
			String msg = "Error: new location is equal to "+lastpoint;
			System.out.println(msg);
			writeToFile(LOGGER_FILE_NAME, msg);
		}
		else{
			String msg = "New point valid: "+ thecurrentlocation;
			System.out.println(msg);
			writeToFile(LOGGER_FILE_NAME, msg);
		}
				
		return null;
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

