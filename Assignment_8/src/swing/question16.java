package swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class question16 extends JFrame {

	private JLabel infoLabel;

	public question16() {
		setTitle("File Chooser Example");
		setSize(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());

		JButton openButton = new JButton("Open File");
		openButton.setFont(new Font("Arial", Font.BOLD, 16));
		openButton.setBackground(new Color(70, 130, 180));
		openButton.setForeground(Color.WHITE);
		openButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					long fileSize = selectedFile.length();
					infoLabel.setText("File: " + selectedFile.getAbsolutePath() + " | Size: " + fileSize + " bytes");
				}
			}
		});

		infoLabel = new JLabel("No file selected");
		infoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		infoLabel.setForeground(new Color(50, 205, 50));

		add(openButton);
		add(infoLabel);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new question16();
			frame.setVisible(true);
		});
	}
}
