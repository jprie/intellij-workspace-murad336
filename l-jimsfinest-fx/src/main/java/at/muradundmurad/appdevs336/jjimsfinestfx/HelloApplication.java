package at.muradundmurad.appdevs336.jjimsfinestfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        // SceneGraph enthält Nodes in einer Baum-Struktur
        // Ein Node kann mehrere Kinder enthalten
//        Parent rootOfSceneGraph = fxmlLoader.load();

        // Manuell den SceneGraph erstellen

        Parent rootOfFXML = fxmlLoader.load();

        // Container
         HBox hbox = new HBox();

         // Controls
        Label label = new Label("Hello FXML");
        Button button = new Button("Push me");

        button.setOnAction(event -> {
            // Label text verändern
            label.setText("Changed text");

        });

        // Füge Controls in Container ein
        hbox.getChildren().addAll(label, button);

        hbox.getChildren().add(rootOfFXML);

        Parent rootOfSceneGraph = hbox;

        Scene scene = new Scene(rootOfSceneGraph);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        // ruft static Methode aus abgeleiteter Klasse Application auf
        // in launch wird ein Application-Objekt erstellt und auf diesem die 'start'-Methode aufgerufen
        launch();
    }
}