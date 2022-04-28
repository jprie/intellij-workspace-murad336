package com.example.nphotolibrary.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PhotoLibraryModel {

    public final ObservableList<Photo> photos = FXCollections.observableArrayList();
    public final ObservableList<Photographer> photographers = FXCollections.observableArrayList(
            new Photographer(0, "Johannes", "Priebsch")
    );
}
