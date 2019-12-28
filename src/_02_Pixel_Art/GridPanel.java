package _02_Pixel_Art;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GridPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private int windowWidth;
	private int windowHeight;
	private int pixelWidth;
	private int pixelHeight;
	private int rows;
	private int cols;
	int m;
	int s;
	
	//1. Create a 2D array of pixels. Do not initialize it yet.
	Pixel[][] pixels;
	
	private Color color;
	
	public GridPanel(int w, int h, int r, int c) {
		this.windowWidth = w;
		this.windowHeight = h;
		this.rows = r;
		this.cols = c;
		
		this.pixelWidth = windowWidth / cols;
		this.pixelHeight = windowHeight / rows;
		
		color = Color.WHITE;
		
		setPreferredSize(new Dimension(windowWidth, windowHeight));
		
		//2. Initialize the pixel array using the rows and cols variables.
			pixels = new Pixel[rows][cols];
		
		//3. Iterate through the array and initialize each element to a new pixel.
			for (int i = 0; i < pixels.length; i++) {
				for (int j = 0; j < pixels.length; j++) {
					pixels[i][j] = new Pixel(i, j);
				}
			}
		
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public void clickPixel(int mouseX, int mouseY) {
		//5. Use the mouseX and mouseY variables to change the color
		//   of the pixel that was clicked. *HINT* Use the pixel's dimensions.
			System.out.println(mouseX+", "+mouseY);
			m = mouseX/pixelWidth;
			s = mouseY/pixelHeight;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//4. Iterate through the array.
		//   For every pixel in the list, fill in a rectangle using the pixel's color.
		//   Then, use drawRect to add a grid pattern to your display.
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels.length; j++) {
				if (m==i && s==j) {
					g.setColor(color);
					g.fillRect(windowWidth/m, windowHeight/s, pixelWidth, pixelHeight);
				}
				g.setColor(Color.BLACK);
				g.drawRect(pixelWidth, pixelHeight, pixelWidth, pixelHeight);
				g.drawRect(pixelWidth, 0, pixelWidth, pixelHeight);
			}
		}
	}
}

