package swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class question21 extends JFrame {

	public question21() {
		setTitle("Look and Feel Example");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());

		LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
		String[] lookNames = new String[looks.length];
		for (int i = 0; i < looks.length; i++) {
			lookNames[i] = looks[i].getName();
		}

		JComboBox<String> lookComboBox = new JComboBox<>(lookNames);
		lookComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String selectedLook = (String) lookComboBox.getSelectedItem();
					for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if (info.getName().equals(selectedLook)) {
							UIManager.setLookAndFeel(info.getClassName());
							SwingUtilities.updateComponentTreeUI(question21.this);
							break;
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		add(new JLabel("Select Look and Feel:"));
		add(lookComboBox);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new question21();
			frame.setVisible(true);
		});
	}
}
