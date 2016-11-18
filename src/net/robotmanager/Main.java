package net.robotmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static java.lang.System.exit;
import static javafx.application.Application.launch;

/**
 * Created by Ethan on 11/14/2016.
 */
public class Main extends Application {

    protected FXController fxController;
    protected Manager manager;

    @Override
    public void start(Stage stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        try { fxmlLoader.load(); } catch(Exception e) { e.printStackTrace(); exit(1); }
        Parent root = fxmlLoader.getRoot();
        stage.setTitle("RobotManager");
        stage.setScene(new Scene(root, 800, 600));
        this.manager = new Manager();
        this.fxController = fxmlLoader.getController();
        fxController.passManager(this.manager);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
