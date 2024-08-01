package swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class question20 extends JFrame {

	public question20() {
		setTitle("Tabbed Pane Example");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JTabbedPane tabbedPane = new JTabbedPane();

		// Tab 1: Form
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(3, 2));
		formPanel.add(new JLabel("Name:"));
		formPanel.add(new JTextField());
		formPanel.add(new JLabel("Email:"));
		formPanel.add(new JTextField());
		formPanel.add(new JLabel("Phone:"));
		formPanel.add(new JTextField());
		tabbedPane.addTab("Form", formPanel);

		// Tab 2: Table
		String[] columnNames = { "Name", "Age", "Email" };
		Object[][] data = { { "Yuvraj sanap", 20, "yuvraj@example.com" }, { "harsh darade", 25, "harsh@example.com" } };
		JTable table = new JTable(data, columnNames);
		JScrollPane tableScrollPane = new JScrollPane(table);
		tabbedPane.addTab("Table", tableScrollPane);

		// Tab 3: Drawing Canvas
		JPanel drawingCanvas = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.BLUE);
				g.drawRect(50, 50, 200, 100);
				g.drawOval(300, 50, 100, 100);
			}
		};
		drawingCanvas.setBackground(Color.WHITE);
		tabbedPane.addTab("Drawing Canvas", drawingCanvas);

		add(tabbedPane);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new question20();
			frame.setVisible(true);
		});
	}
}
