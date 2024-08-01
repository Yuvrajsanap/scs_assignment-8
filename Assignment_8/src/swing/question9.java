package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class question9 extends JPanel {
	private static final int PANEL_WIDTH = 800;
	private static final int PANEL_HEIGHT = 600;
	private static final int CIRCLE_DIAMETER = 100;

	public question9() {
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setBackground(Color.WHITE);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// Get the current DPI scaling factor
		double scaleFactor = getScaleFactor(g2d);
		AffineTransform transform = g2d.getTransform();

		// Apply scaling
		g2d.scale(scaleFactor, scaleFactor);

		// Draw a scalable shape
		g2d.setColor(new Color(70, 130, 180));
		g2d.fillOval(50, 50, CIRCLE_DIAMETER, CIRCLE_DIAMETER);

		// Restore the original transform
		g2d.setTransform(transform);
	}

	private double getScaleFactor(Graphics2D g2d) {
		// Use the GraphicsDevice to get the DPI scaling factor
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		GraphicsConfiguration gc = gd.getDefaultConfiguration();
		AffineTransform deviceTransform = gc.getDefaultTransform();
		return deviceTransform.getScaleX(); // Assuming scaling is uniform
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("High DPI Handling Example");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.add(new question9());
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}
}
