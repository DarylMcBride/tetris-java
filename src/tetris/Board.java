package tetris;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel {
	
	
	private final int BLOCKSIZE = 30, BOARDHEIGHT= 20, BOARDWIDTH = 10;
	
	
	private BufferedImage tiles;
	private int[][] board = new int[BOARDWIDTH][BOARDHEIGHT];
	
	
	public Board() {
		
		
		try {
			tiles = ImageIO.read(Board.class.getResource("/tiles.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paintComponent (Graphics g) {
		
		super.paintComponent(g);
		
		for(int i = 0; i < BOARDHEIGHT; i++) {
			g.drawLine(0, i*BLOCKSIZE, BOARDWIDTH*BLOCKSIZE, i*BLOCKSIZE);
		}
		
		for(int i = 0; i < BOARDHEIGHT; i++) {
			g.drawLine(i*BLOCKSIZE, 0, i*BLOCKSIZE, BOARDHEIGHT*BLOCKSIZE);
		}
		
		
		
		
	}

}
