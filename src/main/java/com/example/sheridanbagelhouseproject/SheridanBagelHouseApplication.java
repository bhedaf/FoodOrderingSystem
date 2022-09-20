package com.example.sheridanbagelhouseproject;
/*
 * @author Fizza Imran  991670304
 * @author Freya Bheda  991643368
 * modified: 6 Aug 2022
 * Description: this is the View class that responsible for setting stage and showing output.

 *
 * */
//imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SheridanBagelHouseApplication extends Application{
    public void start(Stage stage) throws Exception
    {
        // Loading the FXML file
        Parent parent = FXMLLoader.load(getClass().getResource("SheridanBagelHouse-View.fxml"));
        // Building the Scene graph
        Scene scene = new Scene(parent);
        // Displaying the window
        stage.setTitle("Sheridan Coffee & Bagel House");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        // Launching the application.
        launch(args);
    }


}
