package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;


public class PopupController {

    private MainController mainController;

    @FXML
    private ImageView logoView;

    @FXML
    private Button fileDialogButton;

    @FXML
    private Button confirmButton;

    @FXML
    private VBox controls;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<Boolean> isTrueComboBox;

    @FXML
    private Label completionLabel;

    private IntegerProperty completionPercentage;

    private File image;

    //TODO rename, maybe float type, look into it
    private int percent;

    public PopupController(MainController controller){
        mainController = controller;
    }
    public PopupController(){
    }

    @FXML
    private void initialize() {
        logoView.setPreserveRatio(true);
        logoView.setSmooth(true);
        confirmButton.setDisable(false);
        fileDialogButton.setOnAction(event -> {
            FileChooser.ExtensionFilter imageFilter =
                    new FileChooser.ExtensionFilter("Image", "*.img", "*.png");
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(imageFilter);
            image = fileChooser.showOpenDialog(((Node) event.getTarget()).getScene().getWindow());
            if (image != null) {
                logoView.setImage(new Image(image.toURI().toString()));
            }
        });

        percent = 100 / controls.getChildren().size();
        completionPercentage = new SimpleIntegerProperty(0);
        //TODO potentially totally incorrect validation, look deeper into bindings

        idTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                idTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        completionLabel.textProperty().bind(completionPercentage.asString());
        //TODO look deeper into possibility to check collection of children nodes
        controls.onKeyPressedProperty().addListener((obs, oldValue, newValue) -> {
            completionPercentage.setValue(0);
            if (!idTextField.getText().isEmpty()) {
                completionPercentage.setValue(completionPercentage.get() + percent);
            }
            if (!descriptionTextField.getText().isEmpty()) {
                completionPercentage.setValue(completionPercentage.get() + percent);
            }
            if (datePicker.getValue() != null) {
                completionPercentage.setValue(completionPercentage.get() + percent);
            }
            if (logoView.getImage() != null) {
                completionPercentage.setValue(completionPercentage.get() + percent);
            }
            if (!isTrueComboBox.getSelectionModel().isEmpty()) {
                completionPercentage.setValue(completionPercentage.get() + percent);
            }
            if (completionPercentage.get() == 100) {
                confirmButton.setDisable(false);
            }
        });
    }

    public void confirm() throws IOException {
        TableRow tableRow = new TableRow();
        tableRow.setId(Integer.parseInt(idTextField.getText()));
        tableRow.setDescription(descriptionTextField.getText());
        tableRow.setDate(datePicker.getValue());
        tableRow.setImage(imageToFile(logoView.getImage()));
        tableRow.setState(isTrueComboBox.getValue());

        mainController.addItem(tableRow);
    }

    private File imageToFile(Image image) {
        File file = new File("./temp.png");
        String format = "*.png";
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), format, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

}
