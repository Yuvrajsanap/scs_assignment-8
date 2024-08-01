package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class question25 extends JFrame {

	private Color color = Color.RED;

	public question25() {
		setTitle("Custom Painting Example");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		CustomPanel customPanel = new CustomPanel();
		add(customPanel, BorderLayout.CENTER);

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		JButton colorButton = new JButton("Change Color");
		colorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(null, "Select Color", color);
				customPanel.repaint();
			}
		});
		controlPanel.add(colorButton);

		add(controlPanel, BorderLayout.SOUTH);
	}

	private class CustomPanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setColor(color);
			g2d.fillRect(100, 100, 200, 150);
			g2d.setColor(Color.BLUE);
			g2d.fillOval(400, 100, 100, 100);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new question25();
			frame.setVisible(true);
		});
	}
}
