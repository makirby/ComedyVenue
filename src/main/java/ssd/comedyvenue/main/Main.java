package ssd.comedyvenue.main;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ssd.comedyvenue.setup.Database;


public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Splash.fxml"));
        primaryStage.setTitle("splash");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();
    }

    public static void main(String[] args){

        Database database = new Database();

        database.init();

        launch(args);

    }
}
