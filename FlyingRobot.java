package robot;

public class FlyingRobot extends Robot{
	/**
	 * default constructor of FlyingRobot
	 */
	public FlyingRobot() {
		super();
	}
	/**
	 * @param x and y is the top left position
	 * the other parameters are the default ones. 
	 */
	
	public FlyingRobot(int x,int y) {
		super(x,y);
	}
	/**
	 * 
	 * @param x and y is the top left position
	 * @param deltaX the speed and direction in the horizontal direction
	 * @param deltaY the speed and direction in the vertical direction
	 * the other parameters are default
	 */
	public FlyingRobot(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	/**
	 * @param x and y is the top left position
	 * @param deltaX the speed and direction in the horizontal direction
	 * @param deltaY the speed and direction in the vertical direction
	 * @param width of the robot
	 * @param height of the robot
	 */
	public FlyingRobot(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	/**
	 * Paints the oval.
	 */
	protected void paintRobot(Painter painter) {
		painter.drawOval(_x, _y, _width, _height);
	}

}
