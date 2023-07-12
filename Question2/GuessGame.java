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
    JTextField guessBox;
    private JLabel initialTextLabel;
    private JLabel enterLabel;
    JLabel userMessageLabel;
    int randomNumber;
    private int userGuess;
    int counter = 0;
    private Set<Integer> guessedNumbers = new HashSet<>();

    JButton loginButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    JTextField usernameField;
    JPasswordField passwordField;

    JFrame loginFrame;

    public GuessGame() {
        super("Guessing Game"); // passes the string "Guessing Game" as an argument to the JFrame constructor.

        ImageIcon icon = new ImageIcon("Question2/logo1.png");
        setIconImage(icon.getImage());

        // Initialize login components
        loginButton = new JButton("Login");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);

        // Create login frame
        loginFrame = new JFrame("Login");
        loginFrame.setLayout(new GridLayout(3, 2));
        loginFrame.setSize(300, 150);
        loginFrame.setLocationRelativeTo(null); // Center the login frame
        loginFrame.setIconImage(icon.getImage());
        loginFrame.setLayout(new GridLayout(3, 2));
        // loginFrame.pack();

        // Add components to login frame
        loginFrame.add(usernameLabel);
        loginFrame.add(usernameField);
        loginFrame.add(passwordLabel);
        loginFrame.add(passwordField);
        loginFrame.add(loginButton);

        // Register login button event handler
        loginButton.addActionListener(new LoginButtonHandler());

        // Make the login frame visible
        loginFrame.setVisible(true);

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
        setLayout(new BorderLayout()); // determines how the components within the JFrame are arranged and positioned.

        // Create panel for input and labels
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(enterLabel);
        inputPanel.add(guessBox);
        inputPanel.add(enterButton);

        // Create panel for message label
        JPanel messagePanel = new JPanel(new BorderLayout());
        messagePanel.add(userMessageLabel, BorderLayout.CENTER);

        // Create panel for new game and exit buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(newGameButton);
        buttonPanel.add(exitButton);

        // Create panel for message and button panels
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(messagePanel, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add components to the frame
        add(initialTextLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(contentPanel, BorderLayout.SOUTH);

        // Create accelerator keys to enhances the user experience by providing
        // alternative keyboard shortcuts
        newGameButton.setMnemonic('N');
        exitButton.setMnemonic('X');
        enterButton.setMnemonic('E');

        // Define and register window event handler
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // determines what happens when the user closes the window

        // Create and register button event handlers
        newGameButton.addActionListener(new NewGameButtonHandler());
        exitButton.addActionListener(new ExitButtonHandler());
        enterButton.addActionListener(new EnterButtonHandler());

        // Add KeyListener to guessBox
        guessBox.addKeyListener(new GuessBoxKeyListener());

        // Set default frame size
        setSize(500, 200);
    }

    // LoginButtonHandler class
    class LoginButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Perform login authentication
            if (authenticate(username, password)) {
                // If authentication is successful, show the game frame and hide the login frame
                setVisible(true);
                loginFrame.setVisible(false);
            } else {
                // If authentication fails, show an error message
                JOptionPane.showMessageDialog(loginFrame, "Invalid username or password", "Login Failed",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Perform login authentication (dummy method, replace with your own
    // implementation)
    private boolean authenticate(String username, String password) {
        // Check if the username and password match a valid login credential
        // Replace this logic with your own authentication mechanism
        return username.equals("admin") && password.equals("password");
    }

    // Generate a new random number
    void generateRandomNumber() {
        randomNumber = new Random().nextInt(1000) + 1;
        guessedNumbers = new HashSet<>();
    }

    // Reset the game to start a new one
    void resetGame() {
        getContentPane().setBackground(Color.WHITE);
        userMessageLabel.setText("");
        guessBox.setText("");
        generateRandomNumber();
        counter = 0;
    }

    // Check if the user's guess is correct
    private void checkGuess() {
        String guessText = guessBox.getText().trim(); // retrieves the text entered by the user, removes any leading or
                                                      // trailing whitespace stores it in the guessText variable

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
                    guessBox.setText("");
                } else {
                    guessedNumbers.add(userGuess);
                    compareGuess(userGuess);
                    guessBox.setText("");
                    guessBox.requestFocus();
                }
            }
        } catch (NumberFormatException ex) {
            userMessageLabel.setText("Invalid input. Please enter a valid number.");
            guessBox.setText("");
        }
    }

    // Compare the user's guess with the random number
    void compareGuess(int userGuess) {
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
            new GuessGame();
            // game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // game.pack(); // Resize frame to fit components
            // game.setVisible(true);
        });
    }
}
