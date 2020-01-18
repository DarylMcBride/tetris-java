package tetris;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Shape {
	
	private final int DEFAULTSPEED = 600, DOWNSPEED = 60;
	
	private BufferedImage block;
	private int[][] coordinates;
	private Board board;
	private int deltaX = 0;
	private int xPosition, yPosition;
	private long time, lastTime;
	private int currentSpeed;
	
	public Shape(BufferedImage block, int[][] coordinates, Board board) {
		this.block = block;
		this.coordinates=coordinates;
		this.board=board;
		
		time = 0;
		lastTime = System.currentTimeMillis();
		currentSpeed = DEFAULTSPEED;
		xPosition= 4;
		yPosition= 0;
	}
	
	public void update() {
	time += System.currentTimeMillis() - lastTime;
	lastTime = System.currentTimeMillis();
	//check to add colision to side of window
	if (!(xPosition + deltaX + coordinates[0].length > 10) && !(xPosition + deltaX < 0)) {
		 xPosition += deltaX;
	}
	
	if(!(yPosition + 1 + coordinates.length > 20)) {
		if (time > currentSpeed) {
			yPosition++;
			time = 0;
		}
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
	
	public void rotate() {
		int[][] rotatedMatrix;
		
		rotatedMatrix = getTranspose(coordinates);
		
		rotatedMatrix = getReverseMatrix(rotatedMatrix);
		
		if(xPosition+rotatedMatrix[0].length > 10 || yPosition + rotatedMatrix.length > 20) {
			return;
		}
			
		
		coordinates = rotatedMatrix;
	}
	
	private int[][] getTranspose(int[][] matrix) {
		int[][] newMatrix = new int[matrix[0].length][matrix.length];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				newMatrix[j][i] = matrix[i][j];
			}
			
		}
		
		return newMatrix;
	}
	
	
	private int[][] getReverseMatrix(int[][] matrix) {
		
		int middle = matrix.length /2;
		
		for (int i=0; i < middle; i++) {
		int[] m = matrix[i];
		matrix[i] = matrix[matrix.length - i - 1];
		matrix[matrix.length - i -1] = m;
		}
		return matrix;
	}
	
	
	public void downardSpeed() {
		currentSpeed=DOWNSPEED;
	}
	
	public void setDeltaX(int deltaX) {
		this.deltaX = deltaX;
	}
	
	public void normalSpeed() {
		currentSpeed = DEFAULTSPEED;
	}
	
	
	

}
