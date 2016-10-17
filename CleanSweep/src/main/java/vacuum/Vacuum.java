package vacuum;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import room.Point;

/*
 * 
 * VACUUM CLASS
 * The vacuum is aware of the room it is in and positions on all 4 sides of it.  
 * 
 * 
 */


import room.Room;
import room.RoomStatus;
import room.ThingsInRoom;
import sensor.Sensor;
import sensor.SensorFactory;

public class Vacuum {
	
	//General variables for the vacuum
	int storage = 50;
	int batteryLife = 100;
	String name;
	
	//The room that is being searched
	Room room;
	Room CleanedRoom;
	Point currentLocation;
	
	
	
	//Setup the things that the Rumba is aware of in the room.
	ThingsInRoom front = ThingsInRoom.NOTHING;
	ThingsInRoom back = ThingsInRoom.NOTHING;
	ThingsInRoom left = ThingsInRoom.NOTHING;
	ThingsInRoom right = ThingsInRoom.NOTHING;
	ThingsInRoom[] thingsArray = {right,left,back,front};
	
	ThingsInRoom center = ThingsInRoom.BASE;

	//Sensors and Sensor Array to add more sensors just add them to array
	Sensor rightSensor;
	Sensor leftSensor;
	Sensor backSensor;
	Sensor frontSensor;	
	public Sensor[] sensorArray ;
	
	//Sensor Factory to build sensors
	SensorFactory sensorBuilder; 
	
	//constructor
	public Vacuum(String name,  HashMap<Point,RoomStatus> room){
		this.name = name;
		this.room = new Room(room);
		
		currentLocation = new Point(0,0);
		this.room.updateLocation(currentLocation, new RoomStatus(ThingsInRoom.BASE,ThingsInRoom.CLEAN));
		
		
		sensorBuilder = new SensorFactory();
		rightSensor = sensorBuilder.buildFrontSensor();
		leftSensor = sensorBuilder.buildLeftSensor();
		backSensor = sensorBuilder.buildBackSensor();
		frontSensor = sensorBuilder.buildFrontSensor();	
	}
	
	//constructor
	public Vacuum(String name){
		this.name = name;
		this.room = new Room();
		currentLocation = new Point(0,0);
		room.updateLocation(currentLocation, new RoomStatus(ThingsInRoom.BASE,ThingsInRoom.CLEAN));
		
		
/*		for(Point p : room.getRoom().keySet()){
			room.updateLocation(p, new RoomStatus(ThingsInRoom.NOTHING, ThingsInRoom.DIRTY));		
		}
*/		
		
		sensorBuilder = new SensorFactory();
		rightSensor = sensorBuilder.buildFrontSensor();
		leftSensor = sensorBuilder.buildLeftSensor();
		backSensor = sensorBuilder.buildBackSensor();
		frontSensor = sensorBuilder.buildFrontSensor();	
		this.sensorArray =new Sensor[] 	{rightSensor, 
		                              leftSensor , 
		                              backSensor, 
		                              frontSensor} ;
	}
	
	
	
	
	
	//how to run the vacuum.
	public void run(){
		this.move();
	}
	
	public Point getCurrentLocation(){
		return this.currentLocation;
	}
	
	//Function to check the amount that is in the vacuum.
	public int checkStorage(){
		return this.storage;
	}
	// Function to check amount of batterlife in the vacuum
	public int checkBatteryLife(){
		return this.batteryLife;
	}
	// Function to check Sensor Array
	public Sensor[] checkSensor(){
		return this.sensorArray;
	}
	
	// Move the vacuum
	//this is a recursive function.  
	private void move(){
	

			
			//Update Sensors
			for(int i=0;i<=3;i++){
				thingsArray[i] = sensorArray[i].sense();
			}

			
			
			//set the point infront of the vacuum to the new location based on the grid
			Point FrontPoint = new Point(currentLocation.getX()+1,currentLocation.getY());
			Point BackPoint = new Point(currentLocation.getX()-1,currentLocation.getY());
			Point LeftPoint = new Point(currentLocation.getX(),currentLocation.getY()+1);
			Point RightPoint = new Point(currentLocation.getX(),currentLocation.getY()-1);
			
			
			//updating the room to have the new point and the status of the room.  this status is set from the sensors and assumed to be dirty
			//once the vacuum travels over the location, it will then decide if it is dirty or not using the downward sensor. 
			room.updateLocation(FrontPoint, new RoomStatus(front,ThingsInRoom.DIRTY));
			room.updateLocation(BackPoint, new RoomStatus(back,ThingsInRoom.DIRTY));
			room.updateLocation(LeftPoint, new RoomStatus(right,ThingsInRoom.DIRTY));
			room.updateLocation(RightPoint, new RoomStatus(left,ThingsInRoom.DIRTY));

			
			
			//if the front is clear it goes forward.  if the not it looks left then right then back.  
			//if all are not clear, it then initiates the shutdown protocal.
			if((room.checkTypeOfFloor(FrontPoint)!=ThingsInRoom.OBSTACLE)){
				currentLocation = FrontPoint;
				
				this.move();
			}
			else if( (room.checkTypeOfFloor(LeftPoint)!=ThingsInRoom.OBSTACLE)){
				currentLocation = LeftPoint;
				this.move();
			}
			else if( (room.checkTypeOfFloor(RightPoint)!=ThingsInRoom.OBSTACLE)){
				
				currentLocation = RightPoint;
				this.move();
			}
			else if((room.checkTypeOfFloor(BackPoint)!=ThingsInRoom.OBSTACLE)){
				currentLocation = BackPoint;
				
				this.move();
			}
			else{
				
				System.out.println("There is no place to go.  all sensors are covered by an obtacle");
				this.shutDown(currentLocation);
				
			}
		
		}
		
		
	
	//Return to base function.  This will be called when the vacuum is filled.  
	//Then need to be changed to be induced when the vacuum is running out of battery.
	private void returnToBase() {
		// TODO Auto-generated method stub
		
	}
	
	
	private void shutDown(Point p){
		System.out.println("THERE IS NO WHER TO GO>   SHUTTING DOWN at location " +p.toString());
		System.exit(4);
	}
	
	
	
	//To String function
	public String toString(){
		return "HELLO FROM " +  this.name;
	}
}