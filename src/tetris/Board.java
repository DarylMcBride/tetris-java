package tetris;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel {
	
	private BufferedImage tiles;
	
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
		
		g.drawImage(tiles, 0,0, null);
		
		
		
	}

}
