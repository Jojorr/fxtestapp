package sample;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;

public class PopupController {

    @FXML
    private Button confirmButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Group controls;

    @FXML
    private TextField id;

    @FXML
    private TextField description;

    @FXML
    private DatePicker date;

    @FXML
    private TextField logo;

    @FXML
    private ComboBox<Boolean> isTrue;

    @FXML
    private Label completion;

    private boolean[] validations;

    private int completionPercentage;

    @FXML
    private void initialize() {
        validations = new boolean[5];
        id.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                id.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        id.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!validations[0] || id.getText().isEmpty())
                if ( !id.getText().isEmpty() && !validations[0]) {
                    completionPercentage += 20;
                    validations[0] = true;
                } else if (id.getText().isEmpty() && validations[0]) {
                    completionPercentage -= 20;
                    validations[0] = false;
                }
            completion.setText(Integer.toString(completionPercentage));
        });
    }

    public void confirm(){

    }

    public void cancel(){

    }

}
