package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField nameToGreet;
    @FXML
    private Button greetButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox ourCheckbox;

    @FXML
    public void initialize() {
        greetButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void OnButtonClick(ActionEvent event) {

        if (greetButton.equals(event.getSource())) {
            System.out.println("Marry Christmas , " + nameToGreet.getText());
        } else if (byeButton.equals(event.getSource())) {
            System.out.println(nameToGreet.getText() + " signing off");
        }

        if (ourCheckbox.isSelected()) {
            nameToGreet.clear();
            greetButton.setDisable(true);
            byeButton.setDisable(true);
        }
    }

    @FXML
    public void handleKeyReleased() {
        String text = nameToGreet.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        greetButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

    @FXML
    public void handleCheckBox() {
        System.out.println("Checkbox is now " + ((ourCheckbox.isSelected()) ? "checked" : "unchecked"));
    }
}
