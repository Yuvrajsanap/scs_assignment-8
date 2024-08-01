package swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class question11 extends JFrame {

	private JLabel helloLabel;
	private JButton changeMessageButton;

	public question11() {
		setTitle("Basic GUI Application");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		getContentPane().setBackground(new Color(255, 255, 255));

		helloLabel = new JLabel("Hello Yuvraj");
		helloLabel.setFont(new Font("Arial", Font.BOLD, 20));
		helloLabel.setForeground(new Color(0, 102, 204));

		changeMessageButton = new JButton("Change Message");
		changeMessageButton.setBackground(new Color(0, 153, 76));
		changeMessageButton.setForeground(Color.WHITE);
		changeMessageButton.setFont(new Font("Arial", Font.BOLD, 14));

		changeMessageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				helloLabel.setText("Message Changed!");
			}
		});

		add(helloLabel);
		add(changeMessageButton);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			question11 app = new question11();
			app.setVisible(true);
		});
	}
}
