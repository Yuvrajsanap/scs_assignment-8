package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class question10 extends JFrame {

	private JEditorPane editorPane;
	private JButton refreshButton;
	private String currentUrl = "https://www.example.com";

	public question10() {
		setTitle("Swing WebView Example");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// Create and set up the JEditorPane for displaying HTML content
		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(editorPane);
		add(scrollPane, BorderLayout.CENTER);

		// Create a button to refresh the content
		refreshButton = new JButton("Refresh Content");
		refreshButton.setFont(new Font("Arial", Font.BOLD, 14));
		refreshButton.setBackground(new Color(100, 149, 237));
		refreshButton.setForeground(Color.WHITE);
		refreshButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadContent();
			}
		});
		add(refreshButton, BorderLayout.SOUTH);

		// Load initial content
		loadContent();
	}

	private void loadContent() {
		try {
			editorPane.setPage(currentUrl);
		} catch (Exception e) {
			editorPane.setText("Failed to load content.");
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new question10();
			frame.setVisible(true);
		});
	}
}
