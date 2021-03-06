package com.example.assignment1gc200485862;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("covidVaccinationCasesChartView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Covid Cases Based On Vaccination Status!");
        Image icon = new Image(getClass().getResourceAsStream("covid19.png"));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}