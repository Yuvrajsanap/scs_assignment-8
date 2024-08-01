package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class question1 extends JPanel {

	public question1() {
		setPreferredSize(new Dimension(400, 300));
	}

	// paintComponent method to perform custom painting
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Cast Graphics to Graphics2D for better control
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Set the background color and fill the panel
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, getWidth(), getHeight());

		// custom shape
		g2d.setColor(Color.BLUE);
		int diameter = 100;
		int x = (getWidth() - diameter) / 2;
		int y = (getHeight() - diameter) / 2;
		g2d.fillOval(x, y, diameter, diameter);

		// text
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Arial", Font.BOLD, 20));
		g2d.drawString("Custom Painting", x, y + diameter + 30);
	}

	// Main method to create and display the JFrame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Custom Painting Example");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(new question1());
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}
}
