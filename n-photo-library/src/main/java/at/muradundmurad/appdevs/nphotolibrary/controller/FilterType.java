package at.muradundmurad.appdevs.nphotolibrary.controller;

public enum FilterType {
    TITLE("Titel"), PHOTOGRAPHER("Fotograph"), DATE_BEFORE("Datum vor"), DATE_AFTER("Datum nach");

    private String name;

    private FilterType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
