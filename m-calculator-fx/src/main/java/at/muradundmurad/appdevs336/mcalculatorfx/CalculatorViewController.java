package at.muradundmurad.appdevs336.mcalculatorfx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class CalculatorViewController {

    private static final String INIT_DISPLAY = "0.0";
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label display;

    @FXML
    private Label messageDisplay;

    private boolean enteringANumber;
    private CalculatorModel model = new CalculatorModel();

    @FXML
    void onNumberButtonPressed(ActionEvent event) {

        Button button = (Button) event.getTarget();
        String numberEntered = button.getText();
        String displayedNumber = display.getText();

        // Display-Logic
        // if display is "empty", insert "0."
        // if display contains ".", do not append another comma
        if (numberEntered.equals(".")) {
            if (displayedNumber.matches("0.0")){
                numberEntered = "0.";
            } else if (displayedNumber.matches("\\d+.(\\d+)?")) {
                numberEntered = "";
            }
        }

        // first number pressed overrides display
        // all the others get appended
        if (enteringANumber) {
            display.setText(displayedNumber + numberEntered);
        } else {
            display.setText(numberEntered);
            enteringANumber = true;
        }

    }

    @FXML
    void onOperatorButtonPressed(ActionEvent event) {

        String operatorPressed = ((Button) event.getTarget()).getText();
        double displayedNumber = Double.parseDouble(display.getText());

        if (operatorPressed.equals("=")) {

            model.setOp2(displayedNumber);
            executeCalculation();
            display.setText(String.valueOf(model.getResult()));

        } else if (operatorPressed.equals("+/-")) {

            if (displayedNumber != 0.0)
                display.setText(String.valueOf(displayedNumber * (-1)));

        } else {

            if (model.getOp1() != 0.0) {
                model.setOp2(displayedNumber);
                executeCalculation();
                model.setOp1(model.getResult());

            } else {
                model.setOp1(displayedNumber);
            }

            setOperator(operatorPressed);

        }
        enteringANumber = false;
    }

    private void setOperator(String operatorPressed) {
        try {
            model.setOperatorString(operatorPressed);

        } catch (Exception e) {
            messageDisplay.setText("Unknown Operator");
            animateMessage();
        }
    }

    private void executeCalculation() {
        try {
            model.calculateResult();
        } catch (ArithmeticException e) {
            messageDisplay.setText("Division / 0");
            animateMessage();
        }
    }

    @FXML
    void initialize() {
        assert display != null : "fx:id=\"display\" was not injected: check your FXML file 'calculator-view.fxml'.";

        // im Code anpassen
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setText(INIT_DISPLAY);

        // display.setFont(Font.font(32.0));
        display.setStyle("-fx-font-size: 44.0");

        messageDisplay.setText("");
        messageDisplay.setOpacity(0);


    }

    private void animateMessage() {

        final Timeline timeline = new Timeline();
        timeline.setCycleCount(1);
        timeline.setAutoReverse(false);
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.millis(500), new KeyValue (messageDisplay.opacityProperty(), 1)),
                new KeyFrame(Duration.millis(500), new KeyValue(messageDisplay.translateYProperty(), 0)),
                new KeyFrame(Duration.millis(3000), new KeyValue(messageDisplay.translateYProperty(), -50)),
                new KeyFrame(Duration.millis(3000), new KeyValue (messageDisplay.opacityProperty(), 0))
                );
        timeline.play();
    }

    @FXML
    private void onClearButtonPressed(ActionEvent actionEvent) {

        model.clear();
        display.setText(INIT_DISPLAY);
    }
}
