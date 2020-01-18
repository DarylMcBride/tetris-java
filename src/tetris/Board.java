package tetris;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements KeyListener {

	private final int BLOCKSIZE = 30, BOARDHEIGHT = 20, BOARDWIDTH = 10, FPS = 60, DELAY = 1000 / FPS;

	private BufferedImage tiles;
	private int[][] board = new int[BOARDWIDTH][BOARDHEIGHT];
	private Shape[] shapes = new Shape[7];
	private Shape currentShape;

	private Timer timer;

	public Board() {

		// shape textures
		try {
			tiles = ImageIO.read(Board.class.getResource("/tiles.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		timer = new Timer(DELAY, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				update();
				repaint();
			}

		});
		
		timer.start();

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

		currentShape = shapes[3];
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
	
	public void setNextShape() {
		int index = (int)(Math.random()*BOARDHEIGHT);
	}

	public void update() {
		currentShape.update();
	}

	public int getBlockSize() {
		return BLOCKSIZE;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_A) {
			currentShape.setDeltaX(-1);
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			currentShape.setDeltaX(1);
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			currentShape.downardSpeed();
		} if (e.getKeyCode() == KeyEvent.VK_W) {
			currentShape.rotate();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_S) {
			currentShape.normalSpeed();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
