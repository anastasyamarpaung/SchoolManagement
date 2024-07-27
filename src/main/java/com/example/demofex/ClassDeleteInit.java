package com.example.demofex;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ClassDeleteInit {
    Stage stage;
    Scene scene;
    public ClassDeleteInit() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("classdelete.fxml"));
        this.stage = new Stage();
        this.scene = new Scene(loader.load());
        stage.setScene(scene);
    }

    public void show(){
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle("Update a class in your school");
        stage.show();
    }

    public void close(){
        stage.close();
    }
}
