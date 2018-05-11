package robot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.FontMetrics;
/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Craig Sutherland
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;

	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
	}

	/**
	 * @see robot.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
	}

	/**
	 * @see robot.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * @see bounce.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}

	/**
	 * Fills a rectangle of a given width and height with a given colour.
	 */
	public void fillRect(int x, int y, int width, int height) {
		_g.fillRect(x, y, width, height);
		_g.setColor(Color.black);
		
	}

	/** 
	 * This gets a colour.
	 */
	public Color getColour() {
		return _g.getColor();
	}

	/**
	 * This predetermines the colour before filling.
	 */
	public void setColour(Color colour) {
		_g.setColor(colour);
	}
	
	/**
	 * Gets an image from the project and draws it onto the JPanel. 
	 * Parameters: path, the path to the directory of the file.
	 * x and y are the top left positions, where the image is placed
	 * width and height determine the sizes of the image
	 */
	public void setImage(String path,int x,int y,int width,int height) {
		try {
			Image Bomb = ImageIO.read(new File(path));
			_g.drawImage(Bomb, x,y,width,height,null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 /**
	  * Sets the new coordinate system. 
	  * Parameter x and y for the new coordinate system.
	  */
	public void translate(int x, int y) {
		_g.translate(x, y);
	}
	/**
	 * Paints the centred text.
	 * Parameter text specifies what string to display.
	 * Parameter x and y specify the bottom left position of the text.
	 * Parameter width and height, determines the bounding box of the text.
	 */
	public void drawCentredText(String text, int x, int y,int width,int height) {
		_g.setFont(new Font("TimesRoman", Font.PLAIN, height/2)); //sets up font and size.
		FontMetrics fontMetric = _g.getFontMetrics();
		int ascent = fontMetric.getAscent();
		int descent = fontMetric.getDescent();
		int size = _g.getFontMetrics().stringWidth(text);
		if (ascent > descent) {
			y = y + (ascent - descent)/2;
		} else if (descent > ascent) {
			y = y - (descent - ascent)/2;
		}
		//centering the font.
		_g.drawString(text, x-size/2+width/2, y+height/2-(height/2-fontMetric.getHeight()/2)/2);
	}

}
