package tetris;

import javax.swing.JFrame;

public class Window {
	private JFrame window;
	private Board board;

	public static final int WIDTH = 300, HEIGHT = 600;

	public Window() {
		window = new JFrame("Tetris Java");
		window.setSize(WIDTH, HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		
		window.setLocationRelativeTo(null);
		
		board = new Board();
		
		window.add(board);
		
		window.setVisible(true);
	}

}
