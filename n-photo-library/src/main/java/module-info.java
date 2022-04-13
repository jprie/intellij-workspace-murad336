module at.muradundmurad.appdevs.nphotolibrary {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;

    exports at.muradundmurad.appdevs.nphotolibrary;
    opens at.muradundmurad.appdevs.nphotolibrary to javafx.fxml;
    exports at.muradundmurad.appdevs.nphotolibrary.controller;
    opens at.muradundmurad.appdevs.nphotolibrary.controller to javafx.fxml;
    exports at.muradundmurad.appdevs.nphotolibrary.model;
    opens at.muradundmurad.appdevs.nphotolibrary.model to javafx.fxml;


}