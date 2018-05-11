package robot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



/**
 * Simple GUI program to show an animation of robots. Class AnimationViewer is
 * a special kind of GUI component (JPanel), and as such an instance of 
 * AnimationViewer can be added to a JFrame object. A JFrame object is a 
 * window that can be closed, minimized, and maximized. The state of an
 * AnimationViewer object comprises a list of Robots and a Timer object. An
 * AnimationViewer instance subscribes to events that are published by a Timer.
 * In response to receiving an event from the Timer, the AnimationViewer iterates 
 * through a list of Robots requesting that each Robot paints and moves itself.
 * 
 * @author Craig Sutherland
 * 
 */
@SuppressWarnings("serial")
public class AnimationViewer extends JPanel implements ActionListener {
	// Frequency in milliseconds for the Timer to generate events.
	private static final int DELAY = 20;

	// Collection of Robots to animate.
	private List<Robot> _robots;

	private Timer _timer = new Timer(DELAY, this);

	/**
	 * Creates an AnimationViewer instance with a list of Robot objects and 
	 * starts the animation.
	 */
	public AnimationViewer() {
		_robots = new ArrayList<Robot>();
	
		// Populate the list of Robots.
		
		CarrierRobot _topLevelNest2;
		CarrierRobot _midLevelNest;
		CarrierRobot _midLevelNest2;
		CarrierRobot _bottomLevelNest;
		Robot _simpleRobot;
		CarrierRobot _topLevelNest = new CarrierRobot(0, 0, 2, 2, 200, 200);
		_topLevelNest.setText("topLevel");
		_topLevelNest2 = new CarrierRobot(50, 50, 5, 2, 50, 50);
		_midLevelNest = new CarrierRobot(0, 0, 5, 2, 100, 100);
		_midLevelNest2 = new CarrierRobot(0, 0, 3, 2, 40, 40);
		_bottomLevelNest= new CarrierRobot(5, 5, 2, 2, 50, 50);
		_bottomLevelNest.setText("bottomLevel");
		//_bottomLevelNest.setText("bottomLevel");
		
		
		Robot _evenbottomLevelNext = new FlyingRobot(0,0);
		_evenbottomLevelNext.setText("flying robot");
		_simpleRobot = new DynamicWheeledRobot(1, 1, 2, 1, 50, 50,Color.RED);
		_simpleRobot.setText("i am colourful");
		Robot rob = new WheeledRobot();
		_midLevelNest.add(_simpleRobot);
		_midLevelNest.add(_bottomLevelNest);
		_topLevelNest.add(_midLevelNest);
		_topLevelNest2.add(_midLevelNest2);
		_topLevelNest2.setText("help");
		
		Robot wheeledWithText = new WheeledRobot(0,0,10,5,50,50);
		wheeledWithText.setText("hello jj");
		_midLevelNest2.setText("ee");
		_bottomLevelNest.add(_evenbottomLevelNext);
		
		_robots.add(_topLevelNest);
		_robots.add(_topLevelNest2);
		_robots.add(wheeledWithText);
		
	
		// Start the animation.
		_timer.start();
	}

	/**
	 * Called by the Swing framework whenever this AnimationViewer object
	 * should be repainted. This can happen, for example, after an explicit 
	 * repaint() call or after the window that contains this AnimationViewer 
	 * object has been opened, exposed or moved.
	 * 
	 */
	public void paintComponent(Graphics g) {
		// Call inherited implementation to handle background painting.
		super.paintComponent(g);
		
		// Calculate bounds of animation screen area.
		int width = getSize().width;
		int height = getSize().height;
		
		// Create a GraphicsPainter that Robot objects will use for drawing.
		// The GraphicsPainter delegates painting to a basic Graphics object.
		Painter painter = new GraphicsPainter(g);
		
		// Progress the animation.
		for(Robot robot : _robots) {
			robot.paint(painter);
			robot.move(width, height);
		}
	}

	/**
	 * Notifies this AnimationViewer object of an ActionEvent. ActionEvents are
	 * received by the Timer.
	 */
	public void actionPerformed(ActionEvent e) {
		// Request that the AnimationViewer repaints itself. The call to 
		// repaint() will cause the AnimationViewer's paintComponent() method 
		// to be called.
		repaint();
	}
	
	
	/**
	 * Main program method to create an AnimationViewer object and display this
	 * within a JFrame window.
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Animation viewer");
				frame.add(new AnimationViewer());
		
				// Set window properties.
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
