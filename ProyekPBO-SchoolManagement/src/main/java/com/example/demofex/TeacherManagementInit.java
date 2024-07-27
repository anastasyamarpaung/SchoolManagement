package com.example.demofex;

import com.example.demofex.Controller.TeacherManagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class TeacherManagementInit {

    private Stage stage;
    private Scene scene;

    public TeacherManagementInit() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("teacherman.fxml"));

        scene = new Scene(loader.load());
        stage = new Stage();

        stage.setScene(scene);
    }

    public void show(){
        stage.setTitle("Manage your teacher");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void close(){
        stage.close();
    }
}