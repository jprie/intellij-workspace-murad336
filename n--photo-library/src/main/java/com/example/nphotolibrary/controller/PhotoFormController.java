package com.example.nphotolibrary.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.example.nphotolibrary.model.Photo;
import com.example.nphotolibrary.model.PhotoLibraryModel;
import com.example.nphotolibrary.model.Photographer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class PhotoFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private TextArea commentTextArea;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField pathTextField;

    @FXML
    private ChoiceBox<Photographer> photographerChoiceBox;

    @FXML
    private ImageView previewImageView;

    @FXML
    private Button resetButton;

    @FXML
    private TextField titleTextField;

    private PhotoLibraryModel model = new PhotoLibraryModel();

    @FXML
    void onAddButtonPressed(ActionEvent event) {

        String title = titleTextField.getText();
        Photographer photographer = photographerChoiceBox.getValue();
        LocalDate date = datePicker.getValue();
        String path = pathTextField.getText();
        String comment = commentTextArea.getText();
        byte[] imageBytes = Photo.imageBytesFromPath(path);

        // im Model speichern
        Photo photo = new Photo(0l, title, photographer, date, path, comment, imageBytes);
        System.out.println(photo);
    }

    @FXML
    void onLoadPhotoButtonPressed(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(getWindow());

        try {
            Image image = new Image(new FileInputStream(file.getAbsolutePath()));
            previewImageView.setImage(image);
            pathTextField.setText(file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Window getWindow() {
        // beliebigen Node wählen!
        return addButton.getScene().getWindow();
    }

    @FXML
    void onResetButtonPressed(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'photo-form-view.fxml'.";
        assert commentTextArea != null : "fx:id=\"commentTextArea\" was not injected: check your FXML file 'photo-form-view.fxml'.";
        assert datePicker != null : "fx:id=\"datePicker\" was not injected: check your FXML file 'photo-form-view.fxml'.";
        assert pathTextField != null : "fx:id=\"pathTextField\" was not injected: check your FXML file 'photo-form-view.fxml'.";
        assert photographerChoiceBox != null : "fx:id=\"photographerChoiceBox\" was not injected: check your FXML file 'photo-form-view.fxml'.";
        assert previewImageView != null : "fx:id=\"previewImageView\" was not injected: check your FXML file 'photo-form-view.fxml'.";
        assert resetButton != null : "fx:id=\"resetButton\" was not injected: check your FXML file 'photo-form-view.fxml'.";
        assert titleTextField != null : "fx:id=\"titleTextField\" was not injected: check your FXML file 'photo-form-view.fxml'.";

        photographerChoiceBox.setItems(model.photographers);
    }

}
