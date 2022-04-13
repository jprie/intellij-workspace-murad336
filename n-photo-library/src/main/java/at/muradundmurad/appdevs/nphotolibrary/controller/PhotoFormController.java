package at.muradundmurad.appdevs.nphotolibrary.controller;

import at.muradundmurad.appdevs.nphotolibrary.model.Photo;
import at.muradundmurad.appdevs.nphotolibrary.model.PhotoModel;
import at.muradundmurad.appdevs.nphotolibrary.model.Photographer;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;


public class PhotoFormController extends  BaseController{

    private static final Logger log = LoggerFactory.getLogger(PhotoFormController.class);

    @FXML
    private TextField titleTextField;
    @FXML
    private TextField pathToFileTextField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextArea commentTextArea;
    @FXML
    private ChoiceBox<Photographer> photographerChoiceBox;
    @FXML
    private ImageView imageView;

    private final ObjectProperty<Photo> selectedPhoto = new SimpleObjectProperty<>();


    @FXML
    private void onAddButtonClick(ActionEvent actionEvent) {

        String title = titleTextField.getText();
        String pathToFile = pathToFileTextField.getText();
        LocalDate date = datePicker.getValue();
        Photographer photographer = photographerChoiceBox.getValue();
        String comment = commentTextArea.getText();

        if (!isValidInput(title, pathToFile, date, photographer, comment)) {
            log.error("Photo not added");
            System.out.println("photo not added");
            return;
        }

        // Lese bytes aus gewählter Foto-Datei ein
        Path path = Path.of(pathToFile);
        try {
            InputStream inputStream = Files.newInputStream(path);
            byte[] imageBytes = inputStream.readAllBytes();
            Photo photo = new Photo(title, photographer, date, pathToFile, comment, imageBytes);
            model.photos.add(photo);
            System.out.println("Added photo: " + photo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void fillForm(Photo photo) {

        titleTextField.setText(photo.getTitle());
        photographerChoiceBox.setValue(photo.getPhotographer());
        datePicker.setValue(photo.getDate());
        pathToFileTextField.setText(photo.getPathToFile());
        commentTextArea.setText(photo.getComment());
        imageView.setImage(new Image(new ByteArrayInputStream(photo.getImageBytes())));
    }

    private boolean isValidInput(String title, String pathToFile, LocalDate date, Photographer photographer, String comment) {

        if (!title.isBlank() && !pathToFile.isBlank() && date != null && photographer != null) {
            return true;
        }
        log.debug("Validation: {}, {}, {}, {}, {}", title, date, photographer, pathToFile, comment);
        return false;
    }

    @FXML
    private void onClearButtonClick(ActionEvent actionEvent) {
        titleTextField.setText("");
        pathToFileTextField.setText("");
        datePicker.setValue(null);
        commentTextArea.setText("");
        photographerChoiceBox.setValue(null);
        imageView.setImage(null);
        log.info("Cleared form");
    }

    @FXML
    private void onFileChooserButtonClick(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();
        // Öffnet einen Öffnen-Dialog
        File file = fileChooser.showOpenDialog(getCurrentStage());

        // Bild-Datei im ImageView anzeigen
        try {
            imageView.setImage(new Image(new FileInputStream(file)));
            pathToFileTextField.setText(file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("File " + file.getAbsolutePath() + " not found");
        }
    }

    // Liefert die Stage an die Sie den Dialog anhängen wollen
    private Stage getCurrentStage() {

        return (Stage) titleTextField.getScene().getWindow();
    }


    @FXML
    private void initialize() {


        imageView.setImage(new Image(getClass().getResourceAsStream("/at/muradundmurad/appdevs/nphotolibrary/images/IMG_4404.jpg")));
        photographerChoiceBox.setItems(model.photographers);

        model.selectedPhotoProperty().addListener((o, ov, nv) -> fillForm(nv));

    }
}
