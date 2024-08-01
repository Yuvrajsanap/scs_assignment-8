package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class question7 extends JFrame {
	public question7() {
		setTitle("Dialogs and Menus Example");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// Create a button to show the custom dialog
		JButton showDialogButton = new JButton("Show Custom Dialog");
		showDialogButton.setFont(new Font("Arial", Font.BOLD, 16));
		showDialogButton.setBackground(new Color(70, 130, 180));
		showDialogButton.setForeground(Color.WHITE);

		showDialogButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showCustomDialog();
			}
		});

		add(showDialogButton, BorderLayout.NORTH);

		// Create a text area with a context-sensitive popup menu
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Serif", Font.PLAIN, 14));
		textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(new JScrollPane(textArea), BorderLayout.CENTER);

		JPopupMenu popupMenu = createPopupMenu(textArea);
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showPopup(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				showPopup(e);
			}

			private void showPopup(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});

		// Add a status bar
		JLabel statusBar = new JLabel(" Right-click inside the text area for options.");
		statusBar.setFont(new Font("SansSerif", Font.ITALIC, 12));
		statusBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		add(statusBar, BorderLayout.SOUTH);
	}

	private void showCustomDialog() {
		JDialog dialog = new JDialog(this, "Custom Dialog", true);
		dialog.setSize(300, 200);
		dialog.setLocationRelativeTo(this);
		dialog.setLayout(new BorderLayout());

		JLabel messageLabel = new JLabel("This is a custom modal dialog", SwingConstants.CENTER);
		messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
		dialog.add(messageLabel, BorderLayout.CENTER);

		JButton closeButton = new JButton("Close");
		closeButton.setFont(new Font("Arial", Font.BOLD, 12));
		closeButton.setBackground(new Color(255, 69, 0));
		closeButton.setForeground(Color.WHITE);
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(closeButton);
		dialog.add(buttonPanel, BorderLayout.SOUTH);

		dialog.setVisible(true);
	}

	private JPopupMenu createPopupMenu(JTextArea textArea) {
		JPopupMenu popupMenu = new JPopupMenu();

		JMenuItem cutItem = new JMenuItem("Cut");
		cutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.cut();
			}
		});

		JMenuItem copyItem = new JMenuItem("Copy");
		copyItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.copy();
			}
		});

		JMenuItem pasteItem = new JMenuItem("Paste");
		pasteItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.paste();
			}
		});

		popupMenu.add(cutItem);
		popupMenu.add(copyItem);
		popupMenu.add(pasteItem);

		return popupMenu;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				question7 example = new question7();
				example.setVisible(true);
			}
		});
	}
}
