package at.muradundmurad.appdevs.nphotolibrary.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.List;

public class PhotoModel {

    public static List<Photo> initPhotos = new ArrayList<>();

    public final ObservableList<Photo> photos = FXCollections.observableArrayList();

    // Erstellt eine observableArrayList mit den Elementen der List.of
    public final ObservableList<Photographer> photographers =
            FXCollections.observableArrayList(List.of(
            new Photographer("Johannes", "Priebsch")));

    public FilteredList<Photo> filteredPhotos = new FilteredList<>(photos);

    public SortedList<Photo> sortedPhotos = new SortedList<>(filteredPhotos);

    private ObjectProperty<Photo> selectedPhoto = new SimpleObjectProperty<>();

    public PhotoModel() {

        photos.addAll(initPhotos);
    }

    public ObservableList<Photo> getPhotos() {
        return photos;
    }

    public ObservableList<Photographer> getPhotographers() {
        return photographers;
    }

    public Photo getSelectedPhoto() {
        return selectedPhoto.get();
    }

    public ObjectProperty<Photo> selectedPhotoProperty() {
        return selectedPhoto;
    }

    public void setSelectedPhoto(Photo selectedPhoto) {
        this.selectedPhoto.set(selectedPhoto);
    }
}
