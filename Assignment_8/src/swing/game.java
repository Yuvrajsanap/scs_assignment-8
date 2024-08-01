package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class game extends JPanel implements ActionListener, KeyListener {
	private static final int PANEL_WIDTH = 800;
	private static final int PANEL_HEIGHT = 600;
	private static final int BALL_DIAMETER = 30;
	private static final int PADDLE_WIDTH = 100;
	private static final int PADDLE_HEIGHT = 10;
	private static final int BALL_SPEED = 5;
	private static final int PADDLE_SPEED = 10;
	private static final int TIMER_DELAY = 20;

	private int ballX = 0;
	private int ballY = 0;
	private int ballDX = BALL_SPEED;
	private int ballDY = BALL_SPEED;
	private int paddleX = PANEL_WIDTH / 2 - PADDLE_WIDTH / 2;
	private int score = 0;
	private Timer timer;

	public game() {
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);

		timer = new Timer(TIMER_DELAY, this);
		timer.start();

		spawnBall();
	}

	private void spawnBall() {
		Random rand = new Random();
		ballX = rand.nextInt(PANEL_WIDTH - BALL_DIAMETER);
		ballY = 0;
		ballDX = BALL_SPEED * (rand.nextBoolean() ? 1 : -1);
		ballDY = BALL_SPEED;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw the ball
		g.setColor(Color.RED);
		g.fillOval(ballX, ballY, BALL_DIAMETER, BALL_DIAMETER);

		// Draw the paddle
		g.setColor(Color.BLUE);
		g.fillRect(paddleX, PANEL_HEIGHT - PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);

		// Draw the score
		g.setColor(Color.WHITE);
		g.drawString("Score: " + score, 10, 20);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Update ball position
		ballX += ballDX;
		ballY += ballDY;

		// Bounce ball off the sides
		if (ballX < 0 || ballX > PANEL_WIDTH - BALL_DIAMETER) {
			ballDX = -ballDX;
		}

		// Ball hits the bottom of the panel
		if (ballY > PANEL_HEIGHT - BALL_DIAMETER) {
			if (ballX + BALL_DIAMETER > paddleX && ballX < paddleX + PADDLE_WIDTH) {
				score++;
				spawnBall(); // Reset ball position
			} else {
				// Game Over
				timer.stop();
				JOptionPane.showMessageDialog(this, "Game Over! Your score: " + score);
				System.exit(0);
			}
		}

		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT && paddleX > 0) {
			paddleX -= PADDLE_SPEED;
		}
		if (key == KeyEvent.VK_RIGHT && paddleX < PANEL_WIDTH - PADDLE_WIDTH) {
			paddleX += PADDLE_SPEED;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Catch the Ball Game");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(new game());
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}
}
