module com.example.sheridanbagelhouseproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;


    opens com.example.sheridanbagelhouseproject to javafx.fxml;
    exports com.example.sheridanbagelhouseproject;
}