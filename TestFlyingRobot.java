package robot;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class TestFlyingRobot {
	private MockPainter _painter;
	@Before
	public void setUp() {
		_painter = new MockPainter();
	}
	@Test
	public void testFlyingShape() {
		FlyingRobot flyingRobot = new FlyingRobot(100,20,12,15);
		flyingRobot.paint(_painter);
		assertEquals("(oval 100,20,25,35)", 
				_painter.toString());
	}

}
