package model;

import java.util.HashMap;
import java.util.Observable;

import swing.SwingAnimatorBuilder;
import util.Animator;
import util.AnimatorBuilder;
import vacuum.Vacuum;
import room.Point;
import room.RoomStatus;

public class Model extends Observable {
	Vacuum V;
	Animator animator;
	boolean disposed = false;
	
	public Model(Vacuum S, AnimatorBuilder builder){
		
		this.V = S;
		setup(builder, V.getRoom().getRoom());
		this.animator = builder.getAnimator();
		super.addObserver(animator);
	}
	
	public void dispose(){
		animator.dispose();
		disposed = true;
	}
	
	private void setup(AnimatorBuilder builder, HashMap<Point,RoomStatus> r){
		for(Point p : r.keySet()){
			System.out.println(p.ToString()+ " ???");
			
			builder.addLocation(p, r.get(p));
			
			
		}
	}

}
