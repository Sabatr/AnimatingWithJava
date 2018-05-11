package robot;
import java.awt.Image;


public class BombRobot extends Robot {
	/**
	 * BombRobot takes an image of a bomb. 
	 * Whenever it hits a wall, the bomb increases size.
	 * When the bomb is at it's limit, it will explode.
	 * An explosion image will be shown. Then the bomb resets 
	 * back to it's original image and size.
	 */
	//= the original heights and width. 
	private final int _WIDTH = _width;
	private final int _HEIGHT= _height;
	//this determines how quickly the bomb grows
	private final int _expansionRate = 30;
	//determines when the BombRobot will 'explode'.
	private final int _maxExpansionWidth = 300;
	private final int _maxExpansionHeight = 300;
	private boolean _hitHorizontal = false;
	private boolean _hitVertical = false;
	private String path = "Bomb1.png";
	/**
	 * Default constructor for the BombRobot.
	 * Takes in the default parameters of Robot.
	 */
	public BombRobot() {
		super();
	}
	/**
	 * 
	 * @param x x position
	 * @param y y position
	 * @param deltaX the speed and direction for horizontal
	 * @param deltaY the speed and direction for vertical
	 */
	public BombRobot(int x,int y,int deltaX,int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	/**
	 * 
	 * @param x x position
	 * @param y y position
	 * @param deltaX the speed and direction for horizontal
	 * @param deltaY the speed and direction for vertical
	 * @param width the width of the image in pixels
	 * @param height the height of the image in pixels
	 */
	public BombRobot(int x,int y,int deltaX,int deltaY,int width,int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	/**
	 * Paints the BombRobot with an image. 
	 * The width and the height of the robot change upon
	 * hitting a wall.
	 */
	
	public void move(int width,int height) {
		super.move(width, height);
		if (_x <= 0 || _x>=width-_width) {
			_hitHorizontal = true;
		}
		if (_y<= 0 || _y>=height-_height) {
			_hitVertical = true;
		}
	}
	
	public void expand() {
		
		if (_hitHorizontal == true) {
			
			_height+=_expansionRate;
		}
		if (_hitVertical == true) {
			_width+=_expansionRate;
		}
		_hitHorizontal = false;
		_hitVertical = false;
		
	}
	protected void paintRobot(Painter painter) {
		painter.setImage(path,_x,_y,_width,_height);
		this.expand();
		//when this requirement is met, the BombRobot explodes.
		if (_width > _maxExpansionWidth || _height > _maxExpansionHeight) {
			//a new image of an explosion		
			_width = _WIDTH;
			_height = _HEIGHT;
		} 

	}

}
