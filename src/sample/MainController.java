package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;


public class MainController {

    @FXML
    private ObservableList<Entity> entitiesObservableList = FXCollections.observableArrayList(
            new Entity(1, "test",
                    new Date(), null, true));

    @FXML
    private TableView<Entity> entriesTable;


    public void initialize() {

        TableColumn<Entity, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Entity, String> descriptionCall = new TableColumn<>("Description");
        descriptionCall.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Entity, Long> dateCol = new TableColumn<>("Date");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Entity, Object> logoCol = new TableColumn<>("Logo");
        logoCol.setCellValueFactory(new PropertyValueFactory<>("logo"));

        TableColumn<Entity, Boolean> stateCol = new TableColumn<>("isTrue");
        stateCol.setCellValueFactory(new PropertyValueFactory<>("state"));

        entriesTable.getColumns().addAll(idCol, descriptionCall, dateCol, logoCol, stateCol);
        entriesTable.setItems(entitiesObservableList);
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
