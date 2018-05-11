package robot;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestTrackedRobot{
	private MockPainter _painter;
	
	@Before
	public void setUp() {
		_painter = new MockPainter();
	}
	
	@Test
	public void testNormalShape() {
		TrackedRobot trackedRobot = new TrackedRobot(0,0,12,15,50,50);
		trackedRobot.paint(_painter);

		assertEquals("(line 20,0,30,0)(line 30,0,50,25)(line 50,25,30,50)"
				+ "(line 30,50,20,50)(line 20,50,0,25)(line 0,25,20,0)",_painter.toString());
	}
	
	@Test
	public void testSmallTrackedSimpleMove() {
		TrackedRobot trackedRobot = new TrackedRobot(0,0,12,15,40,40);
		trackedRobot.paint(_painter);
		assertEquals("(line 0,20,20,0)(line 20,0,40,20)"
				+ "(line 40,20,20,40)(line 20,40,0,20)",_painter.toString());
	}
	
	
}

