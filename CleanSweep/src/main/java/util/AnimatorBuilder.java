package util;

import room.Point;
import room.RoomStatus;
import util.Animator;

/**
 * An interface for building a {@link Animator} for this {@link Model}.
 */
public interface AnimatorBuilder {
	/**
	 *  Returns the {@link Animator}.
	 *  This method may be called only once; subsequent calls throw an
	 *  {@link IllegalStateException}.
	 */
	public Animator getAnimator();

	public void addLocation(Point p, RoomStatus rs);

}

/**
 * Null object for {@link AnimatorBuilder}.
 */
class NullAnimatorBuilder implements AnimatorBuilder {
	public Animator getAnimator() { return new NullAnimator(); }

	@Override
	public void addLocation(Point p, RoomStatus rs) {}
	
	

}

/**
 * Null object for {@link Animator}.
 */
class NullAnimator implements Animator {
	public void update(java.util.Observable o, Object arg) { }
	public void dispose() { }
}
