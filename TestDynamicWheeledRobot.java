package robot;
import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class TestDynamicWheeledRobot {
	private MockPainter _painter;
	
	@Before
	public void setUp() {
		_painter = new MockPainter();
	}
	
	@Test
	public void testColourOffRight() {
		DynamicWheeledRobot robot = new DynamicWheeledRobot(10,10,12,15,30,30,Color.red);
		robot.paint(_painter);
		//when the robot hits the wall, it changes color.
		robot.move(50, 10000);
		robot.paint(_painter);
		assertEquals("(colour java.awt.Color[r=0,g=0,b=0])(rectangle 10,10,30,30)"
				+ "(colour java.awt.Color[r=255,g=0,b=0])(rectangle 20,25,30,30)",_painter.toString());
	}
	
	@Test
	public void testColourOffLeft() {
		//uses default rectangle and colour.
		DynamicWheeledRobot robot = new DynamicWheeledRobot(10,10,-12,15);
		robot.paint(_painter);
		robot.move(100, 10000);
		robot.paint(_painter);
		assertEquals("(colour java.awt.Color[r=0,g=0,b=0])(rectangle 10,10,25,35)(colour java.awt.Color[r=0,g=0,b=0])(rectangle 0,25,25,35)",_painter.toString());
	}
	
	@Test
	public void testColourTop() {
		//default rectangle sizes.
		DynamicWheeledRobot robot = new DynamicWheeledRobot(20,20,10,-12,Color.green);
		robot.paint(_painter);
		//allows colour change
		robot.move(50, 100);
		robot.paint(_painter);
		//second move causes robot to look like WheeledRobot
		robot.move(50, 100);
		robot.paint(_painter);
		
		assertEquals("(colour java.awt.Color[r=0,g=0,b=0])(rectangle 20,20,25,35)(colour java.awt.Color[r=0,g=255,b=0])(rectangle 25,8,25,35)(colour java.awt.Color[r=0,g=0,b=0])(rectangle 15,0,25,35)",_painter.toString());
	}
	
	@Test
	public void testColourBot() {
		//default rectangle sizes.
		DynamicWheeledRobot robot = new DynamicWheeledRobot(20,50,10,12,Color.blue);
		robot.paint(_painter);
		//allows colour change
		robot.move(50, 100);
		robot.paint(_painter);
		//second move causes robot to look like WheeledRobot
		robot.move(50, 100);
		robot.paint(_painter);
		assertEquals("(colour java.awt.Color[r=0,g=0,b=0])(rectangle 20,50,25,35)(colour java.awt.Color[r=0,g=0,b=255])"
				+ "(rectangle 25,62,25,35)(colour java.awt.Color[r=0,g=0,b=0])(rectangle 15,65,25,35)",_painter.toString());
	}
	
	@Test
	public void testTopLeft() {
		DynamicWheeledRobot robot = new DynamicWheeledRobot(10,10,-6,-6,20,20,Color.yellow);
		robot.paint(_painter);
		robot.move(100, 100);
		robot.paint(_painter);
		robot.move(100, 100);
		robot.paint(_painter);
		assertEquals("(colour java.awt.Color[r=0,g=0,b=0])(rectangle 10,10,20,20)(colour java.awt.Color[r=0,g=0,b=0])"
				+ "(rectangle 4,4,20,20)(colour java.awt.Color[r=255,g=255,b=0])(rectangle 0,0,20,20)",_painter.toString());
	}
	
	@Test
	public void testTopRight() {
		DynamicWheeledRobot robot = new DynamicWheeledRobot(65,10,6,6,Color.yellow);
		robot.paint(_painter);
		robot.move(100, 100);
		robot.paint(_painter);
		robot.move(100, 100);
		robot.paint(_painter);
		assertEquals("(colour java.awt.Color[r=0,g=0,b=0])(rectangle 65,10,25,35)(colour java.awt.Color[r=0,g=0,b=0])"
				+ "(rectangle 71,16,25,35)(colour java.awt.Color[r=255,g=255,b=0])(rectangle 75,22,25,35)",_painter.toString());
	}
	@Test
	public void testBotRight() {
		DynamicWheeledRobot robot = new DynamicWheeledRobot(65,55,6,6);
		robot.paint(_painter);
		robot.move(100, 100);
		robot.paint(_painter);
		robot.move(100, 100);
		robot.paint(_painter);
		assertEquals("(colour java.awt.Color[r=0,g=0,b=0])(rectangle 65,55,25,35)(colour java.awt.Color[r=0,g=0,b=0])"
				+ "(rectangle 71,61,25,35)(colour java.awt.Color[r=0,g=0,b=0])(rectangle 75,65,25,35)",_painter.toString());
	}
	@Test
	public void testBotLeft() {
		DynamicWheeledRobot robot = new DynamicWheeledRobot(10,55,-6,6);
		robot.paint(_painter);
		robot.move(100, 100);
		robot.paint(_painter);
		robot.move(100, 100);
		robot.paint(_painter);
		assertEquals("(colour java.awt.Color[r=0,g=0,b=0])(rectangle 10,55,25,35)(colour java.awt.Color[r=0,g=0,b=0])"
				+ "(rectangle 4,61,25,35)(colour java.awt.Color[r=0,g=0,b=0])(rectangle 0,65,25,35)",_painter.toString());
	}
	
}
