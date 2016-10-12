package room;

import java.util.Arrays;


//Point implementation with overritten hash code and equals
public class Point {
	int x;
	int y;
	
	public Point(int a, int b){
		x = a;
		y = b;
	}
	
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public String ToString(){
		return x + " "+y;		
	}
	
	
	@Override
	public int hashCode(){
		return Arrays.hashCode(new Object[]{new Character((char) x),new Character((char) y)});
	}
	
	
	@Override
	public boolean equals(Object copy){
		Point copy1 = (Point) copy;
		if (copy1 == null){
			throw new NullPointerException("The point was null");
		}
		else if( (copy1.x == this.x) &&(copy1.y == this.y)){
			return true;
		}
		else{
			return false;
		}
	}
	
	
}
