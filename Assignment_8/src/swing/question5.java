package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

// Custom data structure
class Person {
	String name;
	int age;
	String occupation;

	Person(String name, int age, String occupation) {
		this.name = name;
		this.age = age;
		this.occupation = occupation;
	}
}

// Custom table model
class PersonTableModel extends AbstractTableModel {
	private final List<Person> persons;
	private final String[] columnNames = { "Name", "Age", "Occupation" };

	PersonTableModel(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public int getRowCount() {
		return persons.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Person person = persons.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return person.name;
		case 1:
			return person.age;
		case 2:
			return person.occupation;
		default:
			return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
}

// Main application
public class question5 extends JFrame {
	public question5() {
		setTitle("Advanced Components and Layouts Example");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Custom layout manager usage
		JPanel customLayoutPanel = new JPanel();
		customLayoutPanel.setBackground(new Color(173, 216, 230)); // Light Blue
		customLayoutPanel.add(new JButton("Button 1"));
		customLayoutPanel.add(new JButton("Button 2"));
		customLayoutPanel.add(new JButton("Button 3"));

		// BorderLayout usage
		JPanel borderLayoutPanel = new JPanel(new BorderLayout());
		borderLayoutPanel.setBackground(new Color(240, 248, 255)); // Alice Blue
		borderLayoutPanel.add(new JButton("North"), BorderLayout.NORTH);
		borderLayoutPanel.add(new JButton("South"), BorderLayout.SOUTH);
		borderLayoutPanel.add(new JButton("East"), BorderLayout.EAST);
		borderLayoutPanel.add(new JButton("West"), BorderLayout.WEST);
		borderLayoutPanel.add(new JButton("Center"), BorderLayout.CENTER);

		// GridBagLayout usage
		JPanel gridBagLayoutPanel = new JPanel(new GridBagLayout());
		gridBagLayoutPanel.setBackground(new Color(240, 230, 140)); // Khaki
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gridBagLayoutPanel.add(new JButton("Button 1"), gbc);
		gbc.gridx = 1;
		gridBagLayoutPanel.add(new JButton("Button 2"), gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gridBagLayoutPanel.add(new JButton("Button 3"), gbc);
		gbc.gridx = 1;
		gridBagLayoutPanel.add(new JButton("Button 4"), gbc);

		// Custom table model usage
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Yuvraj", 20, "Engineer"));
		persons.add(new Person("Aniket", 25, "Designer"));
		persons.add(new Person("Sanket", 35, "Manager"));

		PersonTableModel personTableModel = new PersonTableModel(persons);
		JTable table = new JTable(personTableModel);
		table.setBackground(new Color(255, 248, 220)); // Cornsilk

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Custom Layout", customLayoutPanel);
		tabbedPane.addTab("BorderLayout", borderLayoutPanel);
		tabbedPane.addTab("GridBagLayout", gridBagLayoutPanel);
		tabbedPane.addTab("JTable", new JScrollPane(table));

		add(tabbedPane);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			question5 example = new question5();
			example.setVisible(true);
		});
	}
}
