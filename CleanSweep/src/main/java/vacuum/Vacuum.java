package vacuum;

import room.Room;

public class Vacuum {
	int storage = 50;
	int batteryLife = 100;
	String name;
	Room room;
	
	
	public Vacuum(String name, Room room){
		this.name = name;
		this.room = room;
	}
	
	
	public void checkStorage(){
		if (this.storage+1 == 51){
			returnToBase();
		}
		
	}


	private void returnToBase() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString(){
		return "HELLO FROM " +  this.name;
	}
}
