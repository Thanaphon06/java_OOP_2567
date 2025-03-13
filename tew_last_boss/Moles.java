import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Moles extends JFrame implements MouseListener, ActionListener {
    private JLabel[] hoLabel = new JLabel[25];
    private JButton randButton, startButton, stopButton;
    private JLabel scoreLabel, attemptsLabel;
    private Timer time;
    private int score = 0;
    private int activeMole = -1;
    private int attemptsLeft = 3;
    private Random random = new Random();

    public Moles() {
        super("Program 123");
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(6, 5, 5, 5));
        
        randButton = new JButton("Random");
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        attemptsLabel = new JLabel("Attempts Left: " + attemptsLeft, SwingConstants.CENTER);
        
        randButton.addActionListener(this);
        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        
        container.add(randButton);
        container.add(startButton);
        container.add(stopButton);
        container.add(scoreLabel);
        container.add(attemptsLabel);
        
        for (int i = 0; i < 25; i++) {
            hoLabel[i] = new JLabel(" " + i, SwingConstants.CENTER);
            hoLabel[i].setPreferredSize(new Dimension(80, 80));
            hoLabel[i].setOpaque(true);
            hoLabel[i].setBackground(Color.RED);
            hoLabel[i].addMouseListener(this);
            container.add(hoLabel[i]);
        }
        
        time = new Timer(1000, this);
        
        this.setSize(600, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void moveMole() {
        if (activeMole != -1) {
            hoLabel[activeMole].setBackground(Color.RED);
        }
        activeMole = random.nextInt(25);
        hoLabel[activeMole].setBackground(Color.GREEN);
    }

    public void adjustSpeed() {
        int delay;
        if (score < 10) {
            delay = 1000;
        } else if (score < 15) {
            delay = 700;
        } else if (score < 20) {
            delay = 500;
        } else if (score < 25) {
            delay = 300;
        } else {
            delay = 200;
        }
        time.setDelay(delay);
    }

    public void resetGame() {
        score = 0;
        attemptsLeft = 3;
        activeMole = -1;
        scoreLabel.setText("Score: 0");
        attemptsLabel.setText("Attempts Left: " + attemptsLeft);
        for (JLabel label : hoLabel) {
            label.setBackground(Color.RED);
        }
        time.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == randButton) {
            moveMole();
        } else if (e.getSource() == startButton) {
            time.start();
        } else if (e.getSource() == stopButton) {
            time.stop();
        } else if (e.getSource() == time) {
            moveMole();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < 25; i++) {
            if (e.getSource() == hoLabel[i]) {
                if (i == activeMole) {
                    score++;
                    hoLabel[i].setBackground(Color.RED);
                    activeMole = -1;
                    scoreLabel.setText("Score: " + score);
                    adjustSpeed();
                } else {
                    attemptsLeft--;
                    attemptsLabel.setText("Attempts Left: " + attemptsLeft);
                    if (attemptsLeft == 0) {
                        time.stop();
                        JOptionPane.showMessageDialog(this, "Game Over! Final Score: " + score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        resetGame();
                    }
                }
            }
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new Moles();
    }
}