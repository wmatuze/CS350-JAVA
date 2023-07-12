//package Question2;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class GuessGameTest {
    private GuessGame game;

    @Before
    public void setUp() {
        game = new GuessGame();
        game.setVisible(false);
    }

    @Test
    public void testAuthentication_Successful() {
        // Arrange
        JTextField usernameField = game.usernameField;
        JPasswordField passwordField = game.passwordField;
        JButton loginButton = game.loginButton;

        // Set valid credentials
        usernameField.setText("admin");
        passwordField.setText("password");

        // Act
        loginButton.doClick();

        // Assert
        assertFalse(game.loginFrame.isVisible());
        assertTrue(game.isVisible());
    }

    @Test
    public void testAuthentication_Failed() {
        // Arrange
        JTextField usernameField = game.usernameField;
        JPasswordField passwordField = game.passwordField;
        JButton loginButton = game.loginButton;

        // Set invalid credentials
        usernameField.setText("invalid");
        passwordField.setText("wrong");

        // Act
        loginButton.doClick();

        // Assert
        assertTrue(game.loginFrame.isVisible());
        assertFalse(game.isVisible());
        JOptionPane dialog = (JOptionPane) SwingUtilities.getRoot(game.loginFrame);
        assertEquals(JOptionPane.ERROR_MESSAGE, dialog.getMessageType());
    }

    @Test
    public void testGenerateRandomNumber() {
        // Arrange

        // Act
        game.generateRandomNumber();
        int randomNumber = game.randomNumber;

        // Assert
        assertTrue(randomNumber >= 1 && randomNumber <= 1000);
    }

    @Test
    public void testCompareGuess_CorrectGuess() {
        // Arrange
        int userGuess = game.randomNumber;
        game.counter = 5;

        // Act
        game.compareGuess(userGuess);

        // Assert
        assertEquals("Congratulations! You guessed the number " + userGuess + " in 5 guess(es).", game.userMessageLabel.getText());
        assertEquals(Color.GREEN, game.getContentPane().getBackground());
    }

    @Test
    public void testCompareGuess_TooHigh() {
        // Arrange
        int userGuess = game.randomNumber + 1;
        game.counter = 3;

        // Act
        game.compareGuess(userGuess);

        // Assert
        assertEquals("Too high", game.userMessageLabel.getText());
        assertEquals(Color.RED, game.getContentPane().getBackground());
    }

    @Test
    public void testCompareGuess_TooLow() {
        // Arrange
        int userGuess = game.randomNumber - 1;
        game.counter = 2;

        // Act
        game.compareGuess(userGuess);

        // Assert
        assertEquals("Too low", game.userMessageLabel.getText());
        assertEquals(Color.BLUE, game.getContentPane().getBackground());
    }

    @Test
    public void testResetGame() {
        // Arrange
        JTextField guessBox = game.guessBox;
        JLabel userMessageLabel = game.userMessageLabel;

        // Act
        game.resetGame();

        // Assert
        assertEquals(Color.WHITE, game.getContentPane().getBackground());
        assertEquals("", userMessageLabel.getText());
        assertEquals("", guessBox.getText());
        assertEquals(0, game.counter);
    }

    // Add more test cases for other methods and functionality if needed
}

