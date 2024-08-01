package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class question2 extends JFrame {
	private JButton startButton;
	private JProgressBar progressBar;
	private JLabel statusLabel;

	public question2() {
		setTitle("SwingWorker Example");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Create UI components
		startButton = new JButton("Start Task");
		progressBar = new JProgressBar(0, 100);
		statusLabel = new JLabel("Task not started", SwingConstants.CENTER);

		// Customize components
		startButton.setBackground(new Color(70, 130, 180)); // Steel Blue
		startButton.setForeground(Color.WHITE);
		startButton.setFont(new Font("Arial", Font.BOLD, 16));

		progressBar.setForeground(new Color(50, 205, 50)); // Lime Green
		progressBar.setBackground(new Color(211, 211, 211)); // Light Gray

		statusLabel.setForeground(new Color(128, 0, 128)); // Purple
		statusLabel.setFont(new Font("Arial", Font.BOLD, 16));

		// Customize panel background
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(new Color(240, 248, 255)); // Alice Blue
		panel.add(startButton, BorderLayout.NORTH);
		panel.add(progressBar, BorderLayout.CENTER);
		panel.add(statusLabel, BorderLayout.SOUTH);

		// Set layout and add components
		setLayout(new BorderLayout());
		add(panel, BorderLayout.CENTER);

		// Add action listener to the button
		startButton.addActionListener(e -> startBackgroundTask());
	}

	private void startBackgroundTask() {
		SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
			@Override
			protected Void doInBackground() throws Exception {
				for (int i = 0; i <= 100; i++) {
					Thread.sleep(50); // Simulate work
					publish(i); // Send data to process method
				}
				return null;
			}

			@Override
			protected void process(java.util.List<Integer> chunks) {
				int progress = chunks.get(chunks.size() - 1);
				progressBar.setValue(progress);
				statusLabel.setText("Progress: " + progress + "%");
			}

			@Override
			protected void done() {
				statusLabel.setText("Task completed!");
				startButton.setEnabled(true);
			}
		};

		startButton.setEnabled(false);
		worker.execute();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			question2 example = new question2();
			example.setVisible(true);
		});
	}
}
