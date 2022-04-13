package at.muradundmurad.appdevs.nphotolibrary.controller;

import at.muradundmurad.appdevs.nphotolibrary.model.Photo;
import at.muradundmurad.appdevs.nphotolibrary.model.PhotoModel;
import at.muradundmurad.appdevs.nphotolibrary.model.Photographer;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class PhotoTableController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(PhotoTableController.class);
    @FXML
    private TableView<Photo> photoTableView;
    @FXML
    private TableColumn<Photo, String> titleColumn;
    @FXML
    private TableColumn<Photo, String> photographerColumn;
    @FXML
    private TableColumn<Photo, LocalDate> dateColumn;
    @FXML
    private TableColumn<Photo, Integer> sizeColumn;

    private void initTable() {
        // Tabelle
        model.sortedPhotos.comparatorProperty().bind(photoTableView.comparatorProperty());
        photoTableView.setItems(model.sortedPhotos);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        photographerColumn.setCellValueFactory(new PropertyValueFactory<>("photographer"));

        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        sizeColumn.setCellValueFactory((dataFeatures) -> new SimpleObjectProperty<Integer>(dataFeatures.getValue().getImageBytes().length));

        photoTableView.getSelectionModel().selectedItemProperty().addListener((o, ov, nv) -> model.setSelectedPhoto(nv));

        // sortable list
//        photoTableView.getSortOrder().addAll(titleColumn, photographerColumn, dateColumn, sizeColumn);



        titleColumn.setSortType(TableColumn.SortType.ASCENDING);

        photoTableView.setOnSort(event -> {

            log.info("Sort called");

        });



    }

    @FXML
    private void initialize() {
        initTable();
    }

    private ObservableValue<String> createPhotographerName(Photographer photographer) {
        return photographer == null ? new SimpleObjectProperty<>() : new SimpleObjectProperty<>(photographer.getFirstName() + " " + photographer.getLastName());
    }

}
