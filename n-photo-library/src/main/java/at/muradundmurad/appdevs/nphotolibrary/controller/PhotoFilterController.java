package at.muradundmurad.appdevs.nphotolibrary.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.Predicate;

import at.muradundmurad.appdevs.nphotolibrary.model.Photo;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
    private TextField titleFilterTextField;

    @FXML
    private DatePicker afterFilterDatePicker;

    @FXML
    private DatePicker beforeFilterDatePicker;

    @FXML
    void onFilterAction(ActionEvent event) {

        filterTable();

    }

    private Map<String, Predicate> predicateMap = new HashMap<>();

    @FXML
    void onFilterTextFieldReleased(KeyEvent event) {
        
        
        TextField textField = (TextField)event.getTarget();
        String nodeId = textField.getId();
        final String text = textField.getText();

        switch(nodeId) {
            case "titleFilterTextField" ->
                updateTitleFilter(nodeId, text);
        }

        filterTable();
    }

    void onDatePickerAction(ActionEvent event) {

        DatePicker datePicker = (DatePicker) event.getTarget();
        String nodeId = datePicker.getId();

        LocalDate selectedDate = datePicker.getValue();

        log.info("DatePicker filter {} {}", nodeId, selectedDate);

        updateDateFilter(nodeId, selectedDate);
        filterTable();
    }

    private void updateTitleFilter(String nodeId, String text) {
        final Predicate<Photo> titleFilterPredicate = (photo -> photo.getTitle().toLowerCase().contains(text));
        updateFilter(nodeId, text, titleFilterPredicate);
    }

    private void updateDateFilter(String nodeId, LocalDate date) {
        final Predicate<Photo> beforeDateFilterPredicate = (photo -> photo.getDate().isBefore(date));
        final Predicate<Photo> afterDateFilterPredicate = (photo -> photo.getDate().isAfter(date));
        switch(nodeId) {
            case "beforeFilterDatePicker" -> updateFilter(nodeId, date, beforeDateFilterPredicate);
            case "afterFilterDatePicker" -> updateFilter(nodeId, date, afterDateFilterPredicate);
        }
    }

    private void updateFilter(String nodeId, Object content, Predicate<Photo> filterPredicate) {

        predicateMap.remove(nodeId);
        if (content != null) {
            predicateMap.put(nodeId, filterPredicate);
        }
    }

    @FXML
    void initialize() {

        titleFilterTextField.setOnKeyReleased(this::onFilterTextFieldReleased);
        beforeFilterDatePicker.setOnAction(this::onDatePickerAction);
        afterFilterDatePicker.setOnAction(this::onDatePickerAction);

    }


    private void filterTable() {

        log.info("Filters: {}", predicateMap);
        Predicate<Photo> combinedPredicate = predicateMap.values().stream().reduce(x->true, Predicate::and);
        model.filteredPhotos.setPredicate(combinedPredicate);

    }
}
