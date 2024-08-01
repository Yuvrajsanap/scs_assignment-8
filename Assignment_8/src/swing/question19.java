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

public class question19 extends JPanel implements ActionListener {

	private static final int PANEL_WIDTH = 800;
	private static final int PANEL_HEIGHT = 600;
	private static final int CIRCLE_DIAMETER = 50;
	private static final int TIMER_DELAY = 20;

	private int x = 0; // Starting X position
	private int y = (PANEL_HEIGHT - CIRCLE_DIAMETER) / 2; // Y position centered vertically
	private Timer timer;

	public question19() {
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setBackground(Color.BLACK);
		timer = new Timer(TIMER_DELAY, this);
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.RED);
		g2d.fillOval(x, y, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		x += 2; // Move the circle 2 pixels to the right
		if (x > PANEL_WIDTH) {
			x = -CIRCLE_DIAMETER; // Reset to the left if it goes out of bounds
		}
		repaint();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Timer Animation Example");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.add(new question19());
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}
}
