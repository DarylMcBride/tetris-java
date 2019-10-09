package tetris;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Shape {
	
	private final int DEFAULTSPEED = 600, DOWNSPEED = 10;
	
	private BufferedImage block;
	private int[][] coordinates;
	private Board board;
	private int deltaX = 0;
	private int xPosition, yPosition;
	private long time, lastTime;
	
	public Shape(BufferedImage block, int[][] coordinates, Board board) {
		this.block = block;
		this.coordinates=coordinates;
		this.board=board;
		
		
		xPosition= 4;
		yPosition= 0;
	}
	
	public void update() {
		
	//check to add colision to side of window
	if (!(xPosition + deltaX + coordinates[0].length > 10) && !(xPosition + deltaX < 0)) {
		
		
		 xPosition += deltaX;
		 
		 deltaX = 0;
	}
	
	}
	
	public void render(Graphics g) {
		
		
		for (int i = 0; i < coordinates.length; i++) {
			for (int j = 0; j < coordinates[i].length; j++) {
				if (coordinates[i][j] != 0) {
					g.drawImage(block, j*board.getBlockSize() + xPosition *board.getBlockSize(), 
							i*board.getBlockSize() + yPosition*board.getBlockSize(), null);
				}
			}
		}
	}
	
	public void setDeltaX(int deltaX) {
		this.deltaX = deltaX;
	}
	

}
