package swing;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class question3 extends JFrame {

	private JPanel draggablePanel;
	private Point initialClick;

	public question3() {
		setTitle("Drag and Drop Example");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		draggablePanel = new JPanel();
		draggablePanel.setBackground(new Color(70, 130, 180));
		draggablePanel.setBounds(100, 100, 150, 150);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setLayout(null);
		layeredPane.add(draggablePanel, JLayeredPane.DEFAULT_LAYER);

		add(layeredPane);

		DragMouseAdapter mouseAdapter = new DragMouseAdapter();
		draggablePanel.addMouseListener(mouseAdapter);
		draggablePanel.addMouseMotionListener(mouseAdapter);
	}

	private class DragMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			initialClick = e.getPoint();
			getComponentAt(initialClick);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// Calculate the location of the component on the screen
			int thisX = draggablePanel.getLocation().x;
			int thisY = draggablePanel.getLocation().y;

			// Determine how much the mouse moved since the initial click
			int xMoved = e.getX() - initialClick.x;
			int yMoved = e.getY() - initialClick.y;

			// Move the component to its new location
			int x = thisX + xMoved;
			int y = thisY + yMoved;
			draggablePanel.setLocation(x, y);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			question3 example = new question3();
			example.setVisible(true);
		});
	}
}
