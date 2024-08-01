package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class question15 extends JFrame {

	private JTable studentTable;
	private DefaultTableModel tableModel;

	public question15() {
		setTitle("JTable Example");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		getContentPane().setBackground(new Color(240, 248, 255));

		String[] columnNames = { "Name", "Age", "Grade" };
		tableModel = new DefaultTableModel(columnNames, 0);
		studentTable = new JTable(tableModel);
		studentTable.setSelectionBackground(new Color(173, 216, 230));

		JScrollPane scrollPane = new JScrollPane(studentTable);
		add(scrollPane, BorderLayout.CENTER);

		JPanel tableControlPanel = new JPanel();
		tableControlPanel.setBackground(new Color(255, 255, 255));
		JButton addButton = new JButton("Add");
		JButton editButton = new JButton("Edit");
		JButton deleteButton = new JButton("Delete");

		addButton.setBackground(new Color(0, 128, 0));
		addButton.setForeground(Color.WHITE);
		addButton.setFont(new Font("Arial", Font.BOLD, 14));

		editButton.setBackground(new Color(255, 165, 0));
		editButton.setForeground(Color.WHITE);
		editButton.setFont(new Font("Arial", Font.BOLD, 14));

		deleteButton.setBackground(new Color(255, 69, 0));
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFont(new Font("Arial", Font.BOLD, 14));

		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Enter Name:");
				String age = JOptionPane.showInputDialog("Enter Age:");
				String grade = JOptionPane.showInputDialog("Enter Grade:");
				tableModel.addRow(new Object[] { name, age, grade });
			}
		});

		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = studentTable.getSelectedRow();
				if (selectedRow >= 0) {
					String name = JOptionPane.showInputDialog("Edit Name:", tableModel.getValueAt(selectedRow, 0));
					String age = JOptionPane.showInputDialog("Edit Age:", tableModel.getValueAt(selectedRow, 1));
					String grade = JOptionPane.showInputDialog("Edit Grade:", tableModel.getValueAt(selectedRow, 2));
					tableModel.setValueAt(name, selectedRow, 0);
					tableModel.setValueAt(age, selectedRow, 1);
					tableModel.setValueAt(grade, selectedRow, 2);
				}
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = studentTable.getSelectedRow();
				if (selectedRow >= 0) {
					tableModel.removeRow(selectedRow);
				}
			}
		});

		tableControlPanel.add(addButton);
		tableControlPanel.add(editButton);
		tableControlPanel.add(deleteButton);

		add(tableControlPanel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			question15 app = new question15();
			app.setVisible(true);
		});
	}
}
