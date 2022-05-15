/*
* this is where everything that happens in the gui goes
* this class is gonna get very full so you can make another class for custom classes and stuff
*/

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Controller {
    public Pane colorPane;
    public Button genButton;
    public TextField rField;
    public TextField gField;
    public TextField bField;
    public AnchorPane anchorPane;

    public void initialize() {
        changeText(255, 255, 255);
        changeColor(255, 255, 255);

        getColorValues();
    }

    public void getColorValues() {
        rField.textProperty().addListener((observable, oldVal, newVal) -> {
            if (!newVal.matches("\\d*")) {
                newVal = oldVal;
            } else if (newVal.isEmpty()) {
                newVal = "0";
            } else if (Integer.parseInt(newVal) > 255) {
                newVal = "255";
            } else {
                String regex = "^0+(?!$)";
                newVal = newVal.replaceAll(regex, "");
            }

            rField.setText(newVal);

            int r = Integer.parseInt(rField.getText());
            int g = Integer.parseInt(gField.getText());
            int b = Integer.parseInt(bField.getText());

            changeColor(r, g, b);
        });

        gField.textProperty().addListener((observable, oldVal, newVal) -> {
            if (!newVal.matches("\\d*")) {
                newVal = oldVal;
            } else if (newVal.isEmpty()) {
                newVal = "0";
            } else if (Integer.parseInt(newVal) > 255) {
                newVal = "255";
            } else {
                String regex = "^0+(?!$)";
                newVal = newVal.replaceAll(regex, "");
            }

            gField.setText(newVal);

            int r = Integer.parseInt(rField.getText());
            int g = Integer.parseInt(gField.getText());
            int b = Integer.parseInt(bField.getText());

            changeColor(r, g, b);
        });

        bField.textProperty().addListener((observable, oldVal, newVal) -> {
            if (!newVal.matches("\\d*")) {
                newVal = oldVal;
            } else if (newVal.isEmpty()) {
                newVal = "0";
            } else if (Integer.parseInt(newVal) > 255) {
                newVal = "255";
            } else {
                String regex = "^0+(?!$)";
                newVal = newVal.replaceAll(regex, "");
            }

            bField.setText(newVal);

            int r = Integer.parseInt(rField.getText());
            int g = Integer.parseInt(gField.getText());
            int b = Integer.parseInt(bField.getText());

            changeColor(r, g, b);
        });
    }

    public void pressedGenButton() {
        int r = random();
        int g = random();
        int b = random();

        changeColor(r, g, b);
        changeText(r, g, b);

        rField.setFocusTraversable(false);
        gField.setFocusTraversable(false);
        bField.setFocusTraversable(false);
    }

    public int random() {
        return (int) (Math.random() * 256);
    }

    public void changeText(int r, int g, int b) {
        rField.setText(String.valueOf(r));
        gField.setText(String.valueOf(g));
        bField.setText(String.valueOf(b));
    }

    public void changeColor(int r, int g, int b) {
        Color color = Color.rgb(r, g, b);
        Background newBackground = new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY));
        colorPane.setBackground(newBackground);
    }

    public void turnOn() {
        rField.setFocusTraversable(true);
        gField.setFocusTraversable(true);
        bField.setFocusTraversable(true);
    }

    public void turnOff() {
        rField.setFocusTraversable(false);
        gField.setFocusTraversable(false);
        bField.setFocusTraversable(false);

        anchorPane.requestFocus();
    }
}
