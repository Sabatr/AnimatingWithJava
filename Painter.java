package robot;

import java.awt.Color;

/** 
 * Interface to represent a type that offers primitive drawing methods.
 * 
 * @author Craig Sutherland
 * 
 */
public interface Painter {
	/**
	 * Draws a rectangle. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawRect(int x, int y, int width, int height);
	
	/**
	 * Draws an oval. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawOval(int x, int y, int width, int height);
	
	/**
	 * Draws a line. Parameters x1 and y1 specify the starting point of the 
	 * line, parameters x2 and y2 the ending point.
	 */
	public void drawLine(int x1, int y1, int x2, int y2);
	/**
	 * Fills a given rectangle. Parameters x and y specify the top left corner
	 * of the rectangle. Parameters width and height specify the width and height
	 * of the rectangle.
	 */
	public void fillRect(int x, int y, int width, int height);
	/**
	 * returns a java.awt.Color value
	 */
	public Color getColour();
	/**
	 * Sets the colour. Parameter colour specifies the colour.
	 */
	public void setColour(Color colour);
	/**
	 * Sets an image. Parameter path determine the directory of the image.
	 * Parameters x and y specify the top left corner of the image.
	 * Parameters width and height specify the width and height of the image.
	 */
	public void setImage(String path, int x, int y, int width, int height);
	
	/**
	 * Sets the new coordinate system.
	 * Parameter x and y specify the new corner of the coordinate system. 
	 */
	public void translate(int x,int y);
	
	/**
	 * Paints the text in the centre.
	 * Parameter text specifies what string to display.
	 * Parameter x and y specify the bottom left position of the text.
	 * Parameter width and height, determines the bounding box of the text.
	 */
	public void drawCentredText(String text,int x, int y,int width, int height);
}
