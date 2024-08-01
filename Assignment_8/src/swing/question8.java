package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class question8 extends JPanel implements ActionListener {
	private static final int PANEL_WIDTH = 800;
	private static final int PANEL_HEIGHT = 600;
	private static final int RECTANGLE_WIDTH = 100;
	private static final int RECTANGLE_HEIGHT = 60;
	private static final int TIMER_DELAY = 20;

	private int x = 0; // Starting X position of the rectangle
	private int y = (PANEL_HEIGHT - RECTANGLE_HEIGHT) / 2; // Y position centered vertically
	private int dx = 2; // Speed of the rectangle movement
	private Timer timer;

	public question8() {
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setBackground(new Color(30, 30, 30)); // Dark background
		timer = new Timer(TIMER_DELAY, this);
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Draw a colorful rectangle
		g2d.setColor(new Color(255, 69, 0)); // Bright orange
		g2d.fillRect(x, y, RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		x += dx; // Move the rectangle
		if (x > PANEL_WIDTH || x < -RECTANGLE_WIDTH) {
			dx = -dx; // Reverse direction if it goes out of bounds
		}
		repaint(); // Request a repaint to update the rectangle's position
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame("Animation Example");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.add(new question8());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
