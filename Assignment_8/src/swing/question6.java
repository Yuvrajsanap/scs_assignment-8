package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class question6 extends JFrame {
	public question6() {
		setTitle("Look and Feel Example");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Create a button
		JButton button = new JButton("Click Me");
		button.setFont(new Font("Arial", Font.BOLD, 16));
		button.setBackground(Color.CYAN);

		// Add the button to the frame
		setLayout(new BorderLayout());
		add(button, BorderLayout.CENTER);

		// Change Look and Feel
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Customize the appearance using UIManager
		UIManager.put("Button.font", new Font("Serif", Font.BOLD, 20));
		UIManager.put("Button.background", Color.ORANGE);
		SwingUtilities.updateComponentTreeUI(this);

		// Add a button to reset to default L&F
		JButton defaultLfButton = new JButton("Default L&F");
		defaultLfButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
					SwingUtilities.updateComponentTreeUI(question6.this);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		JPanel panel = new JPanel();
		panel.add(defaultLfButton);
		add(panel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				question6 example = new question6();
				example.setVisible(true);
			}
		});
	}
}
