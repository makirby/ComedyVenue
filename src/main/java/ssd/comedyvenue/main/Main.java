package ssd.comedyvenue.main;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Splash.fxml"));
        primaryStage.setTitle("splash");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();
    }

    public static void main(String[] args){

//        Startup init = new Startup();

        launch(args);



    }
}
