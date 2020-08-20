package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class PopupController {

    @FXML
    private Button confirmButton;

    @FXML
    private Button cancelButton;

    @FXML
    private VBox controls;

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
    private Label completionLabel;

    private IntegerProperty completionPercentage;

    //TODO rename, maybe float type, look into it
    private int percent;

    @FXML
    private void initialize() {
        confirmButton.setDisable(true);
        percent = 100 / controls.getChildren().size();
        completionPercentage = new SimpleIntegerProperty(0);
        //TODO potentially totally incorrect validation, look deeper into bindings


        id.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                id.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        completionLabel.textProperty().bind(completionPercentage.asString());
        //TODO look deeper into possibility to check collection of children nodes
        id.focusedProperty().addListener((obs, oldValue, newValue) -> {
            completionPercentage.setValue(0);
            if (!id.getText().isEmpty()) {
                completionPercentage.setValue(completionPercentage.get() + percent);
            }
            if (!description.getText().isEmpty()) {
                completionPercentage.setValue(completionPercentage.get() + percent);
            }
            if (date.getValue() != null) {
                completionPercentage.setValue(completionPercentage.get() + percent);
            }
            if (!logo.getText().isEmpty()) {
                completionPercentage.setValue(completionPercentage.get() + percent);
            }
            if (!isTrue.getSelectionModel().isEmpty()) {
                completionPercentage.setValue(completionPercentage.get() + percent);
            }
            if (completionPercentage.get() == 100) {
                confirmButton.setDisable(false);
            }
        });
    }

    public void confirm() {
        MainController controller = new MainController();
        TableRow tableRow = new TableRow();
        tableRow.setId(Integer.parseInt(id.getText()));
        tableRow.setDescription(description.getText());
        tableRow.setDate(date.getValue());
        tableRow.setImage(null);
        tableRow.setState(isTrue.getValue());
        controller.addItem(tableRow);
    }

}
