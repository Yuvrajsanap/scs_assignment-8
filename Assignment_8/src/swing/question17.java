package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class question17 extends JFrame {
	private Color currentColor = Color.BLACK;
	private String currentShape = "Line";
	private Point startPoint, endPoint;
	private ArrayList<ColoredShape> shapes = new ArrayList<>();

	public question17() {
		setTitle("Drawing Application");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel controlPanel = new JPanel();
		JButton colorButton = new JButton("Select Color");
		JComboBox<String> shapeComboBox = new JComboBox<>(new String[] { "Line", "Rectangle", "Circle" });
		JButton clearButton = new JButton("Clear");

		controlPanel.add(colorButton);
		controlPanel.add(shapeComboBox);
		controlPanel.add(clearButton);

		add(controlPanel, BorderLayout.NORTH);

		DrawingPanel drawingPanel = new DrawingPanel();
		add(drawingPanel, BorderLayout.CENTER);

		colorButton.addActionListener(e -> {
			currentColor = JColorChooser.showDialog(null, "Choose a color", currentColor);
		});

		shapeComboBox.addActionListener(e -> {
			currentShape = (String) shapeComboBox.getSelectedItem();
		});

		clearButton.addActionListener(e -> {
			shapes.clear();
			drawingPanel.repaint();
		});

		setVisible(true);
	}

	private class DrawingPanel extends JPanel {
		public DrawingPanel() {
			setBackground(Color.WHITE);

			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					startPoint = e.getPoint();
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					endPoint = e.getPoint();
					Shape shape = null;
					switch (currentShape) {
					case "Line":
						shape = new Line2D.Double(startPoint, endPoint);
						break;
					case "Rectangle":
						shape = new Rectangle(Math.min(startPoint.x, endPoint.x), Math.min(startPoint.y, endPoint.y),
								Math.abs(startPoint.x - endPoint.x), Math.abs(startPoint.y - endPoint.y));
						break;
					case "Circle":
						int radius = (int) startPoint.distance(endPoint);
						shape = new Ellipse2D.Double(startPoint.x - radius, startPoint.y - radius, 2 * radius,
								2 * radius);
						break;
					}
					if (shape != null) {
						shapes.add(new ColoredShape(shape, currentColor));
						repaint();
					}
				}
			});

			addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					endPoint = e.getPoint();
					repaint();
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			for (ColoredShape coloredShape : shapes) {
				g2d.setColor(coloredShape.getColor());
				g2d.draw(coloredShape.getShape());
			}
			if (startPoint != null && endPoint != null) {
				g2d.setColor(currentColor);
				switch (currentShape) {
				case "Line":
					g2d.draw(new Line2D.Double(startPoint, endPoint));
					break;
				case "Rectangle":
					g2d.draw(new Rectangle(Math.min(startPoint.x, endPoint.x), Math.min(startPoint.y, endPoint.y),
							Math.abs(startPoint.x - endPoint.x), Math.abs(startPoint.y - endPoint.y)));
					break;
				case "Circle":
					int radius = (int) startPoint.distance(endPoint);
					g2d.draw(
							new Ellipse2D.Double(startPoint.x - radius, startPoint.y - radius, 2 * radius, 2 * radius));
					break;
				}
			}
		}
	}

	private static class ColoredShape {
		private Shape shape;
		private Color color;

		public ColoredShape(Shape shape, Color color) {
			this.shape = shape;
			this.color = color;
		}

		public Shape getShape() {
			return shape;
		}

		public Color getColor() {
			return color;
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(question17::new);
	}
}
