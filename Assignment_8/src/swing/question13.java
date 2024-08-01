package swing;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class question13 extends JFrame {

	public question13() {
		setTitle("Form Layout Example");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(4, 2, 10, 10));

		add(new JLabel("Name:"));
		add(new JTextField());

		add(new JLabel("Email:"));
		add(new JTextField());

		add(new JLabel("Password:"));
		add(new JPasswordField());

		JButton submitButton = new JButton("Submit");
		add(new JLabel(""));
		add(submitButton);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			question13 app = new question13();
			app.setVisible(true);
		});
	}
}
