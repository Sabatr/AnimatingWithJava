package robot;

import java.util.ArrayList;
import java.util.List;

public class CarrierRobot extends Robot {
	private List<Robot> child = new ArrayList<Robot>();
	/**
	 * Creates a CarrierRobot instance with the default values.
	 */
	public CarrierRobot() {
		super();
	}
	/**
	 * Creates a CarrierRobot instance with specified values for instance
	 * variables.
	 * @param x x position
	 * @param y y position
	 */
	public CarrierRobot(int x,int y) {
		super(x,y);
	}
	/**
	 * Creates a CarrierRobot instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public CarrierRobot(int x,int y,int deltaX,int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	/**
	 * Creates a CarrierRobot instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 */
	public CarrierRobot(int x,int y,int deltaX,int deltaY,int width,int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	/**
	 * Overrides the robot move method. 
	 * This allows the children robots of the
	 * CarrierRobot to move.
	 */
	public void move(int width, int height) {
		super.move(width,height);
		for (Robot robot: child) {
			robot.move(this._width, this._height);
		}
	}
	/**
	 * Paints this WheeledRobot object using the supplied Painter object.
	 */
	protected void paintRobot(Painter painter) {
		painter.drawRect(_x, _y, _width, _height);
		painter.translate(_x, _y); //sets up a new coordinate system.
		for (Robot robot: child) {
			robot.paint(painter);
		}
		//reverts the coordinate system.
		painter.translate(-_x,-_y);
	
	}
	/**
	 * Adds a robot to the CarrierRobot.
	 * Throws IllegalArgumentException if robot cannot be 
	 * added for various reasons.
	 */
	void add(Robot robot) throws IllegalArgumentException{
		if ((robot.x() + robot.width()) >= this.width() || (robot.y() + robot.height()) >= this.height()) {
			throw new IllegalArgumentException("Robot too big for carrier.");
		} else if (robot._parent != null){
			throw new IllegalArgumentException();
		} else {
			robot._parent = this;
			child.add(robot);
		}
	}
	/**
	 * Removes a robot.
	 */
	void remove(Robot robot) {
		child.remove(robot);
		robot._parent = null;
	}
	
	/**
	 * Determines how many children a robot has.
	 */
	public int robotCount() {
		int counter = 0;
		for (Robot robot:child) {
			counter++;
		}
		return counter;
	}
	
	/**
	 * Determines the position of the child robot in the list.
	 */
	public int indexOf(Robot robot) {
		return child.indexOf(robot);
	}
	
	/**
	 * Determines if a robot contains a certain robot.
	 */
	public boolean contains(Robot robot) {
		return child.contains(robot);
	}
	
	/**
	 * Determines what robot is at a specified index.
	 */
	public Robot robotAt(int index) {
		return child.get(index);
	}
}
