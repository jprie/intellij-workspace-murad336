package com.example.nphotolibrary.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class PhotoLibraryModel {

    public final ObservableList<Photo> photos = FXCollections.observableArrayList(
            new Photo(0, "Beispielfoto", null,
                    LocalDate.now(), "", "Kommentar", null)
    );
    public final ObservableList<Photographer> photographers = FXCollections.observableArrayList(
            new Photographer(0, "Johannes", "Priebsch")
    );
}
