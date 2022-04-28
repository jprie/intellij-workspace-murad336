package com.example.mcalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {

    private static final String INIT_DISPLAY = "0.0";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label display;
    private boolean enteringANumber;
    private CalculatorModel model = new CalculatorModel();

    @FXML
    void onNumericButtonPressed(ActionEvent event) {

        Button button = (Button)event.getTarget();
        String numericString = button.getText();
        // Holt sich Daten vom View
        String displayedNumber = display.getText();

        // Komma-Logik
        if (numericString.equals(".") && displayedNumber.contains(".")) {
            numericString = "";
        }

        // Append-Logik
        if (enteringANumber) {
            displayedNumber += numericString;
        } else {
            displayedNumber = numericString;
            enteringANumber = true;
        }

        // manipuliert View
        display.setText(displayedNumber);
    }

    @FXML
    void onOperatorButtonPressed(ActionEvent event) {

        Button button = (Button)event.getTarget();
        String operatorString = button.getText();

        if (operatorString.equals("=") && model.getOperator() != null) {
            // Operand2 speichern und Ergebnis berechnen
            model.setOperand2(Double.parseDouble(display.getText()));
            model.calculateResult();

            display.setText(String.valueOf(model.getResult()));


        } else {
            // Operand1 und Operator speichern
            model.setOperand1(Double.parseDouble(display.getText()));
            try {
                model.setOperatorAsString(operatorString);
            } catch (Exception e) {
                System.err.println("bad operator");
            }
        }

        enteringANumber = false;


    }

    /**
     * Wird automatisch aufgerufen sobald der Scene-Graph fertig geladen wurde und alle Referenzen auf Nodes zeigen
     */
    @FXML
    void initialize() {
        // assert prüft die nachstehende Bedingung und wirft, falls diese nicht zutrifft eine Exception
        assert display != null : "fx:id=\"display\" was not injected: check your FXML file 'calculator-view.fxml'.";

        display.setText(INIT_DISPLAY);
    }

    @FXML
    private void onClearButtonPressed(ActionEvent actionEvent) {

        // clear display
        display.setText(INIT_DISPLAY);

        // clear model
        model.clear();

        // reset enteringANumber
        enteringANumber = false;
    }

    @FXML
    private void onInvertDisplayedNumberButtonPressed(ActionEvent actionEvent) {

        double displayedNumber = Double.parseDouble(display.getText());
        if (displayedNumber != 0) {
            display.setText(String.valueOf(displayedNumber * (-1)));
        }
    }
}
