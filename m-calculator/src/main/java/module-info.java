module com.example.mcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mcalculator to javafx.fxml;
    exports com.example.mcalculator;
}