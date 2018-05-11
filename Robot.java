package robot;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * Abstract superclass to represent the general concept of a Robot. This class
 * defines state common to all special kinds of Robot instances and implements
 * a common movement algorithm. Robot subclasses must override method paint()
 * to handle robot-specific painting.
 * 
 * @author Craig Sutherland
 * 
 */
public abstract class Robot {
	// === Constants for default values. ===
	protected static final int DEFAULT_X_POS = 0;
	
	protected static final int DEFAULT_Y_POS = 0;
	
	protected static final int DEFAULT_DELTA_X = 5;
	
	protected static final int DEFAULT_DELTA_Y = 5;
	
	protected static final int DEFAULT_HEIGHT = 35;

	protected static final int DEFAULT_WIDTH = 25;
	
	protected static final Color DEFAULT_COLOUR = Color.black;
	
	protected static final String DEFAULT_TEXT = "";
	// ===
	
	// === Instance variables, accessible by subclasses.
	protected int _x;

	protected int _y;

	protected int _deltaX;

	protected int _deltaY;

	protected int _width;

	protected int _height;
	
	protected Color _colour;
	
	protected CarrierRobot _parent;
	
	protected String _text = DEFAULT_TEXT;
	
	//originally set the bounce state to DEFAULT, the robot hasn't touched a wall yet.
	
	// ===
	/**
	 * Creates a Robot object with default values for instance variables.
	 */
	public Robot() {
		this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT,DEFAULT_COLOUR);
	}
	
	/**
	 * Creates a Robot object with a specified x and y position.
	 */
	public Robot(int x, int y) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT,DEFAULT_COLOUR);
	}
	
	/**
	 * Creates a Robot instance with specified x, y, deltaX and deltaY values.
	 * The Robot object is created with a default width,height and colour..
	 */
	public Robot(int x, int y, int deltaX, int deltaY) {
		this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT,DEFAULT_COLOUR);
	}
	/**
	 * Creates a Robot instance with specified x, y, deltaX,deltaY and colour values.
	 * The Robot object is created with a default width and height.
	 */
	public Robot(int x, int y, int deltaX, int deltaY,Color colour) {
		this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT,colour);
	}
	
	/**
	 * Creates a Robot instance with a specified x,y,deltaX,deltaY,width and height values.
	 * The Robot object is created with a default colour.
	 */
	public Robot(int x,int y,int deltaX,int deltaY,int width,int height) {
		this(x,y,deltaX,deltaY,width,height,DEFAULT_COLOUR);
	}
	/**
	 * Creates a Robot instance with specified x, y, deltaX, deltaY, width and
	 * height values.
	 */

	public Robot(int x, int y, int deltaX, int deltaY, int width, int height,Color colour) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
		_colour = colour;
	}
	
	/**
	 * Moves this Robot object within the specified bounds. On hitting a 
	 * boundary the Robot instance bounces off and back into the two- 
	 * dimensional world. 
	 * @param width width of two-dimensional world.
	 * @param height height of two-dimensional world.
	 */
	
	public void move(int width, int height) {
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;
		
		if (nextY <= 0) {
			nextY = 0;
			_deltaY = -_deltaY;
		} else if (nextY + _height >= height) {
			nextY = height - _height;
			_deltaY = -_deltaY;	
		}

		if (nextX <= 0) {
			nextX = 0;
			_deltaX = -_deltaX;
		} else if (nextX + _width >= width) {
			nextX = width - _width;
			_deltaX = -_deltaX;
		}
		
		_x = nextX;
		_y = nextY;
	}

	/**
	 * Method to be implemented by concrete subclasses to handle subclass
	 * specific painting.
	 * @param painter the Painter object used for drawing.
	 */
	protected abstract void paintRobot(Painter painter);

	/**
	 * Returns this Robot object's x position.
	 */
	public int x() {
		return _x;
	}
	
	/**
	 * Returns this Robot object's y position.
	 */
	public int y() {
		return _y;
	}
	
	/**
	 * Returns this Robot object's speed and direction.
	 */
	public int deltaX() {
		return _deltaX;
	}
	
	/**
	 * Returns this Robot object's speed and direction.
	 */
	public int deltaY() {
		return _deltaY;
	}
	
	/**
	 * Returns this Robot's width.
	 */
	public int width() {
		return _width;
	}
	
	/**
	 * Returns this Robot's height.
	 */
	public int height() {
		return _height;
	}
	
	/**
	 * Returns a String whose value is the fully qualified name of this class 
	 * of object. E.g., when called on a WheeledRobot instance, this method 
	 * will return "robot.WheeledRobot".
	 */
	public String toString() {
		return getClass().getName();
	}
	
	/**
	 * Returns the parent of this robot. If there is none, it will return null.
	 */
	public CarrierRobot parent() {
		return _parent;
	}
	/**
	 * Returns the path of parents and the curret robot.
	 */
	public List<Robot> path() {
		List<Robot> path = new ArrayList<Robot>();
		while (_parent != null) {
			//when adding the parent, it comes before the child.
			path.add(0,_parent);
			_parent = _parent._parent;
		}
		path.add(this);
		return path;
		
	}
	
	/**
	 * Using the template mehtod:
	 * Whenever paint is called the abstract method (which is overridden by the subclasses) 
	 * will be called. Also a text will be displayed if a robot is related to it.
	 */
	public void paint(Painter painter) {
		this.paintRobot(painter);
		this.paintText(painter);
			
	}
	/**
	 * sets the text of a robot.
	 * Parameter text is a string wanted to be displayed.
	 */
	public void setText(String text) {
		_text = text;
	}
	
	/**
	 * Paints the text accordingly.
	 */
	protected void paintText(Painter painter) {
		painter.drawCentredText(_text, _x, _y,_width,_height);
	}
	
	
	
}
