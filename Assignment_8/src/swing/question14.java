package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class question14 extends JFrame {

	private JPanel colorPanel;
	private JButton chooseColorButton;

	public question14() {
		setTitle("Custom Component Example");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		getContentPane().setBackground(new Color(240, 248, 255));

		colorPanel = new JPanel();
		colorPanel.setPreferredSize(new Dimension(100, 100));
		colorPanel.setBackground(Color.RED);

		chooseColorButton = new JButton("Choose Color");
		chooseColorButton.setBackground(new Color(75, 0, 130));
		chooseColorButton.setForeground(Color.WHITE);
		chooseColorButton.setFont(new Font("Arial", Font.BOLD, 14));

		chooseColorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(question14.this, "Choose Rectangle Color",
						colorPanel.getBackground());
				if (newColor != null) {
					colorPanel.setBackground(newColor);
				}
			}
		});

		add(colorPanel, BorderLayout.CENTER);
		add(chooseColorButton, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			question14 app = new question14();
			app.setVisible(true);
		});
	}
}
