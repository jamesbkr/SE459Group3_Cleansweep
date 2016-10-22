package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import room.CleanRoom;
import room.Point;
import room.Room;
import room.RoomStatus;
import room.ThingsInRoom;
import simulator.RoomSimulator;
import vacuum.*;
import diagnostics.*;
//Main class to test running the vacuum
public class RunVacuum {

	public static void main(String[] args) {
			ArrayList<String> powerLog= new ArrayList<String>();
			ArrayList<String> storageLog= new ArrayList<String>();
			
			RoomSimulator rmSim = new RoomSimulator();
			Scanner scn = new Scanner(System.in);
			int[] i = {10,10};
			HashMap<Point,RoomStatus> room = rmSim.makeRoom(i);
			boolean SS = false;
			int f = 0;
			

			
				do{
						switch(console(scn)){
						
							case 1:
			
								room = rmSim.makeRoom(rmSim.getRoomSize(scn));
								continue;
			
							case 2:
								System.out.println("NOTE: if you haven't build a room yet then the default 10X10 room will be used");
								Vacuum V = new Vacuum("henry",room);
								V.run();							
								continue;
							case 3:
								System.out.println("Good Bye!");
								System.exit(0);
						}

				}while(f==0);
	
	
}
	

	private static int console(Scanner scn){
		boolean SS = false;
		int f = 0;
		do{
			System.out.println("This is the vacuum simulation");
			System.out.println("what would you like to do? please select 1, 2, or 3");
			System.out.println("IF YOU DO NOT GENERATE A ROOM THERE WILL BE A 100X100 ROOM AUTOMATICALLY GENERATED");
			System.out.println("1. create room");
			System.out.println("2. Run simulation");
			System.out.println("3. exit");

			if(scn.hasNextInt()){				
					int j =	scn.nextInt();
				if ((j>0)&&(j<=3)){
					SS =true;
					f = j;
				}else{System.out.println("ENTER EITHER 1, 2, or 3");SS=false;scn.next();}
			}else{System.out.println("PLEASE ENTER AN INTEGER");SS = false;scn.next();}
			

			}while(SS ==false);
		return f;
	}



}