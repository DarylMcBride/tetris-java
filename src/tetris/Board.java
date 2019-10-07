package tetris;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel {

	private final int BLOCKSIZE = 30, BOARDHEIGHT = 20, BOARDWIDTH = 10;

	private BufferedImage tiles;
	private int[][] board = new int[BOARDWIDTH][BOARDHEIGHT];
	private Shape[] shapes = new Shape[6];
	private Shape currentShape;
	
	
	public Board() {

		// shape textures
		try {
			tiles = ImageIO.read(Board.class.getResource("/tiles.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// shape creation
		// Z
		shapes[0] = new Shape(tiles.getSubimage(0, 0, BLOCKSIZE, BLOCKSIZE), new int[][] { { 1, 1, 0 }, { 0, 1, 1 } },
				this);

		// Line
		shapes[1] = new Shape(tiles.getSubimage(0, 0, BLOCKSIZE, BLOCKSIZE), new int[][] { { 1, 1, 0, 1 } }, this);

		// S
		shapes[2] = new Shape(tiles.getSubimage(0, 0, BLOCKSIZE, BLOCKSIZE), new int[][] { { 0, 1, 1 }, { 1, 1, 0 } },
				this);

		// Cube
		shapes[3] = new Shape(tiles.getSubimage(0, 0, BLOCKSIZE, BLOCKSIZE), new int[][] { { 1, 1 }, { 1, 1 } }, this);

		// T
		shapes[4] = new Shape(tiles.getSubimage(0, 0, BLOCKSIZE, BLOCKSIZE), new int[][] { { 1, 1, 1 }, { 0, 1, 0 } },
				this);

		// L ->
		shapes[5] = new Shape(tiles.getSubimage(0, 0, BLOCKSIZE, BLOCKSIZE), new int[][] { { 1, 1, 1 }, { 0, 0, 1 } },
				this);

		// L <-
		shapes[6] = new Shape(tiles.getSubimage(0, 0, BLOCKSIZE, BLOCKSIZE), new int[][] { { 1, 1, 1 }, { 1, 0, 0 } },
				this);

		currentShape = shapes[5];
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		currentShape.render(g);

		for (int i = 0; i < BOARDHEIGHT; i++) {
			g.drawLine(0, i * BLOCKSIZE, BOARDWIDTH * BLOCKSIZE, i * BLOCKSIZE);
		}

		for (int i = 0; i < BOARDHEIGHT; i++) {
			g.drawLine(i * BLOCKSIZE, 0, i * BLOCKSIZE, BOARDHEIGHT * BLOCKSIZE);
		}

	}

}
