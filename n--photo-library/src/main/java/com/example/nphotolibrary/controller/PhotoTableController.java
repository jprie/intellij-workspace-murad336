package com.example.nphotolibrary.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.example.nphotolibrary.model.Photo;
import com.example.nphotolibrary.model.Photographer;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

public class PhotoTableController extends BaseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Photo, String> commentColumn;

    @FXML
    private TableColumn<Photo, LocalDate> dateColumn;

    @FXML
    private TableColumn<Photo, Photographer> photographerColumn;

    @FXML
    private TableColumn<Photo, Image> previewColumn;

    @FXML
    private TableColumn<Photo, Integer> sizeColumn;

    @FXML
    private TableView<Photo> tableView;

    @FXML
    private TableColumn<Photo, String> titleColumn;

    @FXML
    void initialize() {
        assert commentColumn != null : "fx:id=\"commentColumn\" was not injected: check your FXML file 'photo-table-view.fxml'.";
        assert dateColumn != null : "fx:id=\"dateColumn\" was not injected: check your FXML file 'photo-table-view.fxml'.";
        assert photographerColumn != null : "fx:id=\"photographerColumn\" was not injected: check your FXML file 'photo-table-view.fxml'.";
        assert previewColumn != null : "fx:id=\"previewColumn\" was not injected: check your FXML file 'photo-table-view.fxml'.";
        assert sizeColumn != null : "fx:id=\"sizeColumn\" was not injected: check your FXML file 'photo-table-view.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'photo-table-view.fxml'.";
        assert titleColumn != null : "fx:id=\"titleColumn\" was not injected: check your FXML file 'photo-table-view.fxml'.";

        // Objekte aus ObservableList in Tabelle anzeigen
        tableView.setItems(model.photos);

        // Definieren, wie die Objekte dargestellt werden
        titleColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTitle()));
        photographerColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getPhotographer()));
        dateColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDate()));
        sizeColumn.setCellValueFactory(cellDataFeatures -> new SimpleObjectProperty<>(cellDataFeatures.getValue().getSize()));
        commentColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getComment()));

        // Spezial Column
        previewColumn.setCellFactory(new Callback<TableColumn<Photo, Image>, TableCell<Photo, Image>>() {

            ImageView imageView = new ImageView();
            @Override
            public TableCell<Photo, Image> call(TableColumn<Photo, Image> param) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(Image item, boolean empty) {
                        super.updateItem(item, empty);

                        if(empty) {
                            setText(null);
                            setGraphic(null);
                        } else {

                            InputStream inputStream = null;
                            Image image = null;
                            try {
                                Photo photo = getTableView().getItems().get(getIndex());
                                inputStream = new FileInputStream(photo.getPath());
                                image = new Image(inputStream);
                                imageView.setPreserveRatio(true);
                                imageView.setFitHeight(100);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            setGraphic(imageView);
                            imageView.setImage(image);
                        }
                    }
                };
            }
        });
    }

}
