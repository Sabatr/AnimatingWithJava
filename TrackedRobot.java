package robot;

public class TrackedRobot extends Robot {
	public TrackedRobot() {
		super();
	}
	

	public TrackedRobot(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	

	public TrackedRobot(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	protected void paintRobot(Painter painter) {
		if (_width > 40) {
			//draws the hexagon from the top left with a clockwise motion.
			painter.drawLine(_x+20,_y,_x+_width-20,_y);
			painter.drawLine(_x+_width-20, _y, _x+_width, _y+_height/2);
			painter.drawLine(_x+_width, _y+_height/2, _x+_width-20, _y+_height);
			painter.drawLine(_x+_width-20, _y+_height, _x+20, _y+_height);
			painter.drawLine(_x+20, _y+_height, _x, _y+_height/2);
			painter.drawLine(_x, _y+_height/2, _x+20, _y);
		} else {
			painter.drawLine(_x, _y+_height/2, _x+_width/2, _y);
			painter.drawLine(_x+_width/2, _y, _x+_width, _y+_height/2);
			painter.drawLine(_x+_width, _y+_height/2, _x+_width/2, _y+_height);
			painter.drawLine(_x+_width/2, _y+_height, _x, _y+_height/2);
		}			
	}

}
