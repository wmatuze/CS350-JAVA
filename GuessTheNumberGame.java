import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class GuessTheNumberGame extends Application {

    private int randomNumber;
    private TextField guessTextField;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = createGridPane();
        Scene scene = new Scene(gridPane, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Guess the Number");
        primaryStage.show();
        startNewGame();
    }

    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        Label instructionsLabel = new Label("I have a number between 1 and 1000.\nCan you guess my number?");
        guessTextField = new TextField();
        Button guessButton = new Button("Guess");
        guessButton.setOnAction(event -> handleGuess());

        resultLabel = new Label();
        resultLabel.setPrefWidth(200);

        Button playAgainButton = new Button("Play Again");
        playAgainButton.setVisible(false);
        playAgainButton.setOnAction(event -> startNewGame());

        gridPane.add(instructionsLabel, 0, 0, 2, 1);
        gridPane.add(guessTextField, 0, 1);
        gridPane.add(guessButton, 1, 1);
        gridPane.add(resultLabel, 0, 2, 2, 1);
        gridPane.add(playAgainButton, 0, 3, 2, 1);

        return gridPane;
    }

    private void startNewGame() {
        randomNumber = generateRandomNumber();
        guessTextField.setText("");
        guessTextField.setEditable(true);
        resultLabel.setText("");
        guessTextField.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    private void handleGuess() {
        try {
            int guess = Integer.parseInt(guessTextField.getText());
            if (guess == randomNumber) {
                handleCorrectGuess();
            } else if (guess < randomNumber) {
                resultLabel.setText("Too Low");
                guessTextField.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            } else {
                resultLabel.setText("Too High");
                guessTextField.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            }
            guessTextField.requestFocus();
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input");
        }
        guessTextField.setText("");
    }

    private void handleCorrectGuess() {
        resultLabel.setText("Correct!");
        guessTextField.setEditable(false);
        guessTextField.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        Button playAgainButton = (Button) guessTextField.getScene().lookup("#playAgainButton");
        playAgainButton.setVisible(true);
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(1000) + 1;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
