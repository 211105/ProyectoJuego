module com.example.juego {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.juego to javafx.fxml;
    exports com.example.juego;
    exports com.example.juego.Controllers;
    opens com.example.juego.Controllers to javafx.fxml;
}