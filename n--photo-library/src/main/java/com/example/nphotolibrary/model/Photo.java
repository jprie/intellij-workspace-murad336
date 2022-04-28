package com.example.nphotolibrary.model;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Photo {

    private long id;
    private String title;
    private Photographer photographer;
    private LocalDate date;
    private String path;
    private String comment;
    private byte[] imageBytes;

    public Photo(long id, String title, Photographer photographer, LocalDate date, String path, String comment, byte[] imageBytes) {
        this.id = id;
        this.title = title;
        this.photographer = photographer;
        this.date = date;
        this.path = path;
        this.comment = comment;
        this.imageBytes = imageBytes;
    }

    public static byte[] imageBytesFromPath(String path) {

        byte[] imageBytes = null;
        try {
            imageBytes = new FileInputStream(path).readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageBytes;
    }

    @Override
    public String toString() {
        long imageBytesLength = 0;

        if (imageBytes != null) {
            imageBytesLength = imageBytes.length;
        }

        return "Photo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", photographer=" + photographer +
                ", date=" + date +
                ", path='" + path + '\'' +
                ", comment='" + comment + '\'' +
                ", imageBytes=" + imageBytesLength/1024 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return id == photo.id && Objects.equals(title, photo.title) && Objects.equals(photographer, photo.photographer) && Objects.equals(date, photo.date) && Objects.equals(path, photo.path) && Objects.equals(comment, photo.comment) && Arrays.equals(imageBytes, photo.imageBytes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, title, photographer, date, path, comment);
        result = 31 * result + Arrays.hashCode(imageBytes);
        return result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Photographer getPhotographer() {
        return photographer;
    }

    public void setPhotographer(Photographer photographer) {
        this.photographer = photographer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }
}
