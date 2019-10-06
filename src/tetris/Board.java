package tetris;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Board extends JPanel {
	
	public Board() {
		
	}
	
	public void paintComponent (Graphics g) {
		
		super.paintComponent(g);
		
		g.drawRect(100, 100, 50, 50);
		
	}

}
