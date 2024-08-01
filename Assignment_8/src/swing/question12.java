package swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class question12 extends JFrame {

	private JTextField textField;
	private JButton displayButton;
	private JLabel displayLabel;

	public question12() {
		setTitle("Event Handling Example");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());

		textField = new JTextField(20);
		displayButton = new JButton("Display Text");
		displayLabel = new JLabel(" ");

		displayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayLabel.setText(textField.getText());
			}
		});

		add(new JLabel("Enter Text:"));
		add(textField);
		add(displayButton);
		add(displayLabel);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			question12 app = new question12();
			app.setVisible(true);
		});
	}
}
