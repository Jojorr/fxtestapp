package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;


public class MainController {

    private ObservableList<TableRow> entitiesObservableList;

    @FXML
    private Button addButton;

    @FXML
    private GridPane gridPane;

    @FXML
    private TableView<TableRow> entriesTable;

    public void initialize() {

        entitiesObservableList = FXCollections.observableArrayList(
                new TableRow(1, "test",
                        LocalDate.now(), null, true));

        TableColumn<TableRow, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<TableRow, String> descriptionCall = new TableColumn<>("Description");
        descriptionCall.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<TableRow, LocalDate> dateCol = new TableColumn<>("Date");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<TableRow, Image> logoCol = new TableColumn<>("Logo");
        logoCol.setCellValueFactory(new PropertyValueFactory<>("logo"));

        TableColumn<TableRow, Boolean> stateCol = new TableColumn<>("isTrue");
        stateCol.setCellValueFactory(new PropertyValueFactory<>("state"));

        entriesTable.getColumns().addAll(idCol, descriptionCall, dateCol, logoCol, stateCol);
        entriesTable.setItems(entitiesObservableList);
    }


    public void addItem(TableRow tableRow) {
        entitiesObservableList.add(tableRow);
        entriesTable.setItems(entitiesObservableList);
    }

    @FXML
    private void openPopup() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("popup.fxml"));
        try {
            PopupController popupController = new PopupController(this);
            fxmlLoader.setController(popupController);
            Parent root = fxmlLoader.load();


            Stage stage = new Stage();
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setTitle("Test");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
