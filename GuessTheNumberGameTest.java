// package Question2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GuessTheNumberGameTest {

    private GuessTheNumberGame game;

    @Before
    public void setUp() {
        game = new GuessTheNumberGame();
    }

    @Test
    public void generateRandomNumber_shouldReturnNumberInRange() {
        int randomNumber = game.generateRandomNumber();
        Assert.assertTrue(randomNumber >= 1 && randomNumber <= 1000);
    }

    @Test
    public void guessListener_withCorrectGuess_shouldDisplayCorrectMessage() {
        game.messageLabel.setText("I have a number between 1 and 1000. Can you guess my number?");
        game.guessTextField.setText(String.valueOf(game.randomNumber));
        game.submitButton.doClick();
        Assert.assertEquals("Correct! You guessed the number.", game.messageLabel.getText());
    }

    @Test
    public void guessListener_withLowGuess_shouldDisplayTooLowMessage() {
        game.messageLabel.setText("I have a number between 1 and 1000. Can you guess my number?");
        game.guessTextField.setText(String.valueOf(game.randomNumber - 1));
        game.submitButton.doClick();
        Assert.assertEquals("Too Low! Guess a higher number.", game.messageLabel.getText());
    }

    @Test
    public void guessListener_withHighGuess_shouldDisplayTooHighMessage() {
        game.messageLabel.setText("I have a number between 1 and 1000. Can you guess my number?");
        game.guessTextField.setText(String.valueOf(game.randomNumber + 1));
        game.submitButton.doClick();
        Assert.assertEquals("Too High! Guess a lower number", game.messageLabel.getText());
    }

    // Additional test cases for other methods can be added here

}
