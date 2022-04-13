package at.muradundmurad.appdevs.nphotolibrary;

import at.muradundmurad.appdevs.nphotolibrary.model.Photo;
import at.muradundmurad.appdevs.nphotolibrary.model.PhotoModel;
import at.muradundmurad.appdevs.nphotolibrary.model.Photographer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class PhotoLibraryApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PhotoLibraryApplication.class.getResource("photo-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Photo Library");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        PhotoModel.initPhotos = generateDummyPhotos();
    }

    private List<Photo> generateDummyPhotos() throws IOException {
        Photographer photographer = new Photographer("Johannes", "Priebsch");
        String toscanaPath = Path.of("n-photo-library/src/main/resources/at/muradundmurad/appdevs/nphotolibrary/images/IMG_4404.jpg").toAbsolutePath().toString();
        String madridPath = Path.of("n-photo-library/src/main/resources/at/muradundmurad/appdevs/nphotolibrary/images/IMG_5307.jpg").toAbsolutePath().toString();
        String sanSebastianPath = Path.of("n-photo-library/src/main/resources/at/muradundmurad/appdevs/nphotolibrary/images/IMG_5199.jpg").toAbsolutePath().toString();
        return new ArrayList<>(
                List.of(
                        new Photo("Toscana", photographer, LocalDate.now(), toscanaPath, "Dolce vita", Files.newInputStream(Path.of(toscanaPath)).readAllBytes()),
                        new Photo("Madrid", photographer, LocalDate.now().minus(2, ChronoUnit.YEARS), madridPath, "Museum", Files.newInputStream(Path.of(madridPath)).readAllBytes()),
                        new Photo("San Sebastian", photographer, LocalDate.now(), sanSebastianPath, "el mar", Files.newInputStream(Path.of(sanSebastianPath)).readAllBytes())
                )
        );
    }

    public static void main(String[] args) {
        launch();
    }
}