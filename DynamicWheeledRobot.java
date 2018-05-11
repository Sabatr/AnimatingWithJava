package robot;
import java.awt.Color;


public class DynamicWheeledRobot extends Robot {
	/**
	 * Default constructor of the DynamicWheeledRobot.
	 * Creates an instance where the paramters are the default parameters.
	 */
	
	private boolean _hitHorizontal = false;
	public DynamicWheeledRobot() {
		super();
	}
	/**
	 * 
	 * @param x x position
	 * @param y y position
	 * @param deltaX speed and direction for horizontal axis
	 * @param deltaY speed and direction for vertical axis
	 */
	public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	/**
	 * 
	 * @param x x position
	 * @param y y position
	 * @param deltaX speed and direction for horizonral axis
	 * @param deltaY speed and direction for vertical axis
	 * @param colour colour of the robot
	 */
	public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY,Color colour) {
		super(x,y,deltaX,deltaY,colour);
	}
	/**
	 * 
	 * @param x x position
	 * @param y y position
	 * @param deltaX speed and direction for horizonral axis
	 * @param deltaY speed and direction for vertical axis
	 * @param height height of the robot in pixels 
	 * @param width width of the robot in pixels
	 * @param colour colour of the robot
	 */
	public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY, int width, int height,Color colour) {
		super(x,y,deltaX,deltaY,width,height,colour);
	}
	/**
	 * @param x x position
	 * @param y y position
	 * @param deltaX speed and direction for horizonral axis
	 * @param deltaY speed and direction for vertical axis
	 * @param height height of the robot in pixels 
	 * @param width width of the robot in pixels
	 **/
	public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	/**
	 * Paints the robot accordingly. 
	 * Hitting the vertical walls will cause the robot to change colour.
	 * Hitting the horizontal walls will cause the robot to look like WheeledRobot.
	 */
	
	public void move(int width,int height) {
		super.move(width, height);
		if (_x <= 0 || _x>=width-_width) {
			_hitHorizontal = true;
		} else if (_y<= 0 || _y>=height-_height) {
			_hitHorizontal = false;
		}
	}
	protected void paintRobot(Painter painter) {
		if (_hitHorizontal== true) {
			painter.setColour(_colour);
			painter.fillRect(_x, _y, _width, _height);
		} else {
			painter.setColour(Color.BLACK);
			painter.drawRect(_x, _y, _width, _height);
		}
	}
}
