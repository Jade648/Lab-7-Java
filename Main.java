package edu.wctc.racecar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main extends Application {

    public static final double SCENE_WIDTH = 600;
    public static final double SCENE_HEIGHT = 400;

    private ExecutorService threadPool = Executors.newCachedThreadPool();
    private Pane pane = new Pane();

    private void addCarToRace() {
       Car car = new Car();
       pane.getChildren().add(car);
       Runnable task = new AnimateCarTask(car);
       Thread thread = new Thread(task);
       thread.start();

    }

    private void endRace() {

    }

    @Override
    public void start(Stage primaryStage) {
        // Layout the buttons on the stage
        HBox box = new HBox();
        box.setPadding(new Insets(15, 12, 15, 12));
        box.setSpacing(10);

        Button joinRaceButton = new Button("Join Race");
        joinRaceButton.setOnMouseClicked(e -> addCarToRace());
        box.getChildren().add(joinRaceButton);

        Button endRaceButton = new Button("End Race");
        endRaceButton.setOnMouseClicked(e -> endRace());
        box.getChildren().add(endRaceButton);

        pane.getChildren().add(box);

        // Create the scene
        Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT);

        // Add scene to stage and show the display
        primaryStage.setTitle("Racing Cars");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
