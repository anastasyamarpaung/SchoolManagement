package com.example.demofex;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentManagementInit {
    private Stage stage;
    private Scene scene;

    public StudentManagementInit() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("studentman.fxml"));
        scene = new Scene(loader.load());
        stage = new Stage();

        stage.setScene(scene);
    }

    public void show(){
        stage.setTitle("Manage your Student");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void close(){
        stage.close();
    }
}
