import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GuessGame extends JFrame {
    private JButton newGameButton;
    private JButton enterButton;
    private JButton exitButton;
    private JTextField guessBox;
    private JLabel initialTextLabel;
    private JLabel enterLabel;
    private JLabel userMessageLabel;
    private int randomNumber;
    private int userGuess;
    private int counter = 0;
    private Set<Integer> guessedNumbers;

    public GuessGame() {
        super("Guessing Game"); //passes the string "Guessing Game" as an argument to the JFrame constructor.

        // Initialize components
        newGameButton = new JButton("New Game");
        exitButton = new JButton("Exit Game");
        enterButton = new JButton("Enter");
        guessBox = new JTextField(4);
        initialTextLabel = new JLabel("I have a number between 1 and 1000. Can you guess my number?");
        enterLabel = new JLabel("Please enter your guess:");
        userMessageLabel = new JLabel("");

        // Generate random number
        generateRandomNumber();

        // Set the layout manager to BorderLayout
        setLayout(new BorderLayout()); //determines how the components within the JFrame are arranged and positioned.

        // Create panel for input and labels
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(enterLabel);
        inputPanel.add(guessBox);
        inputPanel.add(enterButton);

        // Create panel for message label and buttons
        JPanel messagePanel = new JPanel(new GridLayout(1, 3)); // Use GridLayout for buttons
        messagePanel.add(userMessageLabel);
        messagePanel.add(newGameButton);
        messagePanel.add(exitButton);

        // Add components to the frame
        add(initialTextLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(messagePanel, BorderLayout.SOUTH);

        // Create accelerator keys to enhances the user experience by providing alternative keyboard shortcuts
        newGameButton.setMnemonic('N');
        exitButton.setMnemonic('X');
        enterButton.setMnemonic('E');

        // Define and register window event handler
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //determines what happens when the user closes the window

        // Create and register button event handlers
        newGameButton.addActionListener(new NewGameButtonHandler());
        exitButton.addActionListener(new ExitButtonHandler());
        enterButton.addActionListener(new EnterButtonHandler());

        // Add KeyListener to guessBox
        guessBox.addKeyListener(new GuessBoxKeyListener());

        // Set default frame size
        setSize(500, 200);
        //setVisible(true);
    }

    // Generate a new random number
    private void generateRandomNumber() {
        randomNumber = new Random().nextInt(1000) + 1;
        guessedNumbers = new HashSet<>();
    }

    // Reset the game to start a new one
    private void resetGame() {
        getContentPane().setBackground(Color.WHITE);
        userMessageLabel.setText("");
        guessBox.setText("");
        generateRandomNumber();
        counter = 0;
    }

    // Check if the user's guess is correct
    private void checkGuess() {
        String guessText = guessBox.getText().trim();

        if (guessText.isEmpty()) {
            return;
        }

        try {
            userGuess = Integer.parseInt(guessText);
            if (userGuess < 1 || userGuess > 1000) {
                userMessageLabel.setText("Invalid input. Please enter a number between 1 and 1000.");
            } else {
                if (guessedNumbers.contains(userGuess)) {
                    userMessageLabel.setText("You already guessed " + userGuess + ". Try a different number.");
                } else {
                    guessedNumbers.add(userGuess);
                    compareGuess(userGuess);
                    guessBox.setText("");
                    guessBox.requestFocus();
                }
            }
        } catch (NumberFormatException ex) {
            userMessageLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    // Compare the user's guess with the random number
    private void compareGuess(int userGuess) {
        counter++;

        if (userGuess == randomNumber) {
            userMessageLabel.setText(
                    "Congratulations! You guessed the number " + randomNumber + " in " + counter + " guess(es).");
            getContentPane().setBackground(Color.GREEN);
        } else if (userGuess > randomNumber) {
            userMessageLabel.setText("Too high");
            getContentPane().setBackground(Color.RED);
        } else if (userGuess < randomNumber) {
            userMessageLabel.setText("Too low");
            getContentPane().setBackground(Color.BLUE);
        }
    }

    // newGameButtonHandler class
    class NewGameButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            resetGame();
        }
    }

    // ExitButtonHandler class
    class ExitButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    // EnterButtonHandler class
    class EnterButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            checkGuess();
        }
    }

    // KeyListener for guessBox
    class GuessBoxKeyListener implements KeyListener {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                checkGuess();
            }
        }

        public void keyTyped(KeyEvent e) {
        }

        public void keyReleased(KeyEvent e) {
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GuessGame game = new GuessGame();
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //game.pack(); // Resize frame to fit components
            game.setVisible(true);
        });
    }
}
