package main;
import room.Room;
import vacuum.*;


public class RunVacuum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Vacuum firstVacuum = new Vacuum("henry", new Room());
			
			
			System.out.println(firstVacuum.toString());
	}

}
