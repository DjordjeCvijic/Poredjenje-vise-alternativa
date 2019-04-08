package main;
import model.Table;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {


    public static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{

        stage=primaryStage;
        Table table=new Table();

        Parent root = FXMLLoader.load(getClass().getResource(".."+ File.separator+"view"+File.separator+"tableScena.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
