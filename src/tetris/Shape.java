package tetris;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Shape {
	
	private BufferedImage block;
	private int[][] coordinates;
	private Board board;
	
	public Shape(BufferedImage block, int[][] coordinates, Board board) {
		this.block = block;
		this.coordinates=coordinates;
		this.board=board;
	}
	
	public void update() {
	
	}
	
	public void render(Graphics g) {
		
		
		for (int i = 0; i < coordinates.length; i++) {
			for (int j = 0; j < coordinates[i].length; j++) {
				if (coordinates[i][j] != 0) {
					g.drawImage(block, j*30, i*30, null);
				}
			}
		}
	}
	

}
