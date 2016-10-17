package room;


//Room status object to tell what is at that location and if it is clean or not.
public class RoomStatus {
	ThingsInRoom typeOfFloor;
	ThingsInRoom isClean;
	
	
	public RoomStatus(ThingsInRoom a,ThingsInRoom b){
		typeOfFloor = a;
		isClean = b;
	}
	
	public ThingsInRoom getIsClean(){
		return isClean;
	}
	
	public ThingsInRoom getTypeOfFloor(){
		return typeOfFloor;
		
	}
	

}
