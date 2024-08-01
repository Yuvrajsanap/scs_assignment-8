package swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

// Model class
class CounterModel {
	private int counter;

	public int getCounter() {
		return counter;
	}

	public void increment() {
		counter++;
	}

	public void decrement() {
		counter--;
	}
}

// View class
class CounterView extends JFrame {
	private JLabel counterLabel;
	private JButton incrementButton;
	private JButton decrementButton;

	public CounterView() {
		setTitle("MVC Counter Example");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		counterLabel = new JLabel("Counter: 0", SwingConstants.CENTER);
		counterLabel.setFont(new Font("Arial", Font.BOLD, 20));
		incrementButton = new JButton("Increment");
		decrementButton = new JButton("Decrement");

		setLayout(new BorderLayout());
		add(counterLabel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(incrementButton);
		buttonPanel.add(decrementButton);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	public void setCounter(int counter) {
		counterLabel.setText("Counter: " + counter);
	}

	public JButton getIncrementButton() {
		return incrementButton;
	}

	public JButton getDecrementButton() {
		return decrementButton;
	}
}

// Controller class
class CounterController {
	private CounterModel model;
	private CounterView view;

	public CounterController(CounterModel model, CounterView view) {
		this.model = model;
		this.view = view;

		view.getIncrementButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.increment();
				view.setCounter(model.getCounter());
			}
		});

		view.getDecrementButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.decrement();
				view.setCounter(model.getCounter());
			}
		});
	}
}

// Main class to tie everything together
public class question4 {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				CounterModel model = new CounterModel();
				CounterView view = new CounterView();
				CounterController controller = new CounterController(model, view);
				view.setVisible(true);
			}
		});
	}
}
