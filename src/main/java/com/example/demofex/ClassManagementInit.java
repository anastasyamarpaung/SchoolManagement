package com.example.demofex;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ClassManagementInit {

    private Scene scene;
    private Stage stage;
    public ClassManagementInit() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("classman.fxml"));
        scene = new Scene(loader.load());
        stage = new Stage();

        stage.setScene(scene);
    }

    public void show(){
        stage.setTitle("Manage your school classes");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void close(){
        stage.close();
    }
}
