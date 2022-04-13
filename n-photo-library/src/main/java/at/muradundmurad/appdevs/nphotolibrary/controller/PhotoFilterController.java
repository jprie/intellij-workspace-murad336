package at.muradundmurad.appdevs.nphotolibrary.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhotoFilterController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(PhotoFilterController.class);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<FilterType> filterChoiceBox;

    @FXML
    private TextField filterTextField;

    @FXML
    void onFilterAction(ActionEvent event) {



    }

    @FXML
    void onFilterTextFieldReleased(KeyEvent event) {

        filterTable();
    }

    @FXML
    void initialize() {
        assert filterChoiceBox != null : "fx:id=\"filterChoiceBox\" was not injected: check your FXML file 'photo-filter-view.fxml'.";
        assert filterTextField != null : "fx:id=\"filterTextField\" was not injected: check your FXML file 'photo-filter-view.fxml'.";

        filterChoiceBox.setItems(FXCollections.observableList(Arrays.stream(FilterType.values()).toList()));
        filterTextField.setOnKeyReleased(this::onFilterTextFieldReleased);
        filterChoiceBox.getSelectionModel().select(0);
        filterChoiceBox.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                filterTable();
            }
        });
    }


    private void filterTable() {
        LocalDate parsedDate;
        String filterText = filterTextField.getText().toLowerCase();
        try {
            parsedDate = LocalDate.parse(filterTextField.getText());
        } catch (DateTimeParseException e) {
            log.info("Not a valid date: {}", filterTextField.getText());
            parsedDate = LocalDate.now();
        }

        final LocalDate finalDate = parsedDate;
        switch (filterChoiceBox.getValue()) {
            case null -> log.info("No filter selected");
            case TITLE -> model.filteredPhotos.setPredicate(photo -> photo.getTitle().toLowerCase().contains(filterText));
            case PHOTOGRAPHER -> model.filteredPhotos.setPredicate(photo -> photo.getPhotographer().getFullname().toLowerCase().contains(filterText));
            case DATE_BEFORE -> model.filteredPhotos.setPredicate(photo -> photo.getDate().isBefore(finalDate));
            case DATE_AFTER -> model.filteredPhotos.setPredicate(photo -> photo.getDate().isAfter(finalDate));
        }

    }

}
