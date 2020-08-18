package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class MainController {

    @FXML
    private TextField input;

    @FXML
    private TextField output;

    public MainController() {
    }

    @FXML
    public void initialize() {
    }


    public void printOutput() {
        output.setText(input.getText());
    }

    public void openPopup() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("popup.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Test");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
