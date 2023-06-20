//package Question2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessTheNumberGame extends JFrame {
    private final int MAX_NUMBER = 1000; //Maximum number for the game
    int randomNumber; // Random number to guess
    JLabel messageLabel; 
    JTextField guessTextField;
    JButton submitButton;
    private JButton playAgainButton;

    public GuessTheNumberGame() {
        super("Guess the Number Game"); // Title for the JFrame
        randomNumber = generateRandomNumber(); // Generate a random number

        messageLabel = new JLabel("I have a number between 1 and 1000. Can you guess my number?");
        guessTextField = new JTextField(10); 
        submitButton = new JButton("Submit");
        playAgainButton = new JButton("Play Again");

        setLayout(new FlowLayout());

        add(messageLabel);
        add(guessTextField);
        add(submitButton);

        guessTextField.addActionListener(new GuessListener());
        submitButton.addActionListener(new GuessListener());

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    int generateRandomNumber() {
        return (int) (Math.random() * MAX_NUMBER) + 1;
    }

    private class GuessListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            int guess = Integer.parseInt(guessTextField.getText());

            if (guess == randomNumber) {
                messageLabel.setText("Correct! You guessed the number.");
                guessTextField.setEditable(false);
                getContentPane().setBackground(Color.GREEN);
                submitButton.setEnabled(false);
                add(playAgainButton);
            } else if (guess < randomNumber) {
                messageLabel.setText("Too Low! Guess a higher number.");
                getContentPane().setBackground(Color.BLUE);
            } else {
                messageLabel.setText("Too High! Guess a lower number");
                getContentPane().setBackground(Color.RED);
            }

            guessTextField.setText("");
            guessTextField.requestFocus();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GuessTheNumberGame();
            }
        });
    }
}
