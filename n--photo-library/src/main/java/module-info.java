module com.example.nphotolibrary {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.nphotolibrary to javafx.fxml;
    exports com.example.nphotolibrary;
    exports com.example.nphotolibrary.controller;
    opens com.example.nphotolibrary.controller to javafx.fxml;
    exports com.example.nphotolibrary.model;
    opens com.example.nphotolibrary.model to javafx.fxml;
}