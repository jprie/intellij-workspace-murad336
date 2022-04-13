package at.muradundmurad.appdevs.nphotolibrary.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

//public record Photo(String title, Photographer photographer, LocalDate date, String pathToFile,
//                    String comment, byte[] imageBytes) {
//}

public class Photo {

    private StringProperty title = new SimpleStringProperty();
    private ObjectProperty<Photographer> photographer = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();
    private StringProperty pathToFile = new SimpleStringProperty();
    private StringProperty comment = new SimpleStringProperty();
    private byte[] imageBytes = null;

    public Photo(String title, Photographer photographer, LocalDate date, String pathToFile,
    String comment, byte[] imageBytes) {
        setTitle(title);
        setPhotographer(photographer);
        setDate(date);
        setPathToFile(pathToFile);
        setComment(comment);
        this.imageBytes = imageBytes;
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public Photographer getPhotographer() {
        return photographer.get();
    }

    public ObjectProperty<Photographer> photographerProperty() {
        return photographer;
    }

    public void setPhotographer(Photographer photographer) {
        this.photographer.set(photographer);
    }

    public LocalDate getDate() {
        return date.get();
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public String getPathToFile() {
        return pathToFile.get();
    }

    public StringProperty pathToFileProperty() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile.set(pathToFile);
    }

    public String getComment() {
        return comment.get();
    }

    public StringProperty commentProperty() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment.set(comment);
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }
}