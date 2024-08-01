package swing;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class question22 extends JFrame {

	public question22() {
		setTitle("Split Pane Example");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JTextArea leftTextArea = new JTextArea("Left Panel");
		leftTextArea.setBackground(Color.LIGHT_GRAY);

		JTextArea rightTextArea = new JTextArea("Right Panel");
		rightTextArea.setBackground(Color.WHITE);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(leftTextArea),
				new JScrollPane(rightTextArea));
		splitPane.setDividerLocation(300);

		add(splitPane);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new question22();
			frame.setVisible(true);
		});
	}
}
