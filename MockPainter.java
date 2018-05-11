package robot;

import java.awt.Color;

/**
 * Implementation of the Painter interface that does not actually do any
 * painting. A MockPainter implementation responds to Painter requests by
 * logging simply logging them. The contents of a MockPainter object's
 * log can be retrieved by a call to toString() on the MockPainter.
 * 
 * @author Craig Sutherland
 * 
 */
public class MockPainter implements Painter {
	// Internal log.
	private StringBuffer _log = new StringBuffer();
	private Color colour;

	/**
	 * Returns the contents of this MockPainter's log.
	 */
	public String toString() {
		return _log.toString();
	}

	/**
	 * Logs the drawRect call.
	 */
	public void drawRect(int x, int y, int width, int height) {
		_log.append("(rectangle " + x + "," + y + "," + width + "," + height + ")");
	}
	
	/**
	 * Logs the drawOval call.
	 */
	public void drawOval(int x, int y, int width, int height) {
		_log.append("(oval " + x + "," + y + "," + width + "," + height + ")");
	}

	/**
	 * Logs the drawLine call.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_log.append("(line " + x1 + "," + y1 + "," + x2 + "," + y2 + ")");
	}
	/**
	 * Logs the dimensions of the rectangle that is filled.
	 */
	public void fillRect(int x, int y, int width, int height) {
		_log.append("(rectangle " + x + "," + y + "," + width + "," + height + ")");
	}
	/**
	 * Logs the colour get.
	 */
	public Color getColour() {
		return null;
	}
	/**
	 * Logs the colour that is set.
	 */
	public void setColour(Color colour) {
		_log.append("(colour " + colour + ")");
	}
	/**
	 * Logs the image that is set.
	 */
	public void setImage(String path,int x,int y,int width,int height) {
		_log.append("(image "+ path + "," + x+ "," + y +"," +width +"," + height +")");
	}
	
	/**
	 * Empty method, doesn't need to be logged.
	 */
	public void translate(int x,int y) {
	}
	
	public void drawCentredText(String text, int x,int y,int width,int height) {
	}
}