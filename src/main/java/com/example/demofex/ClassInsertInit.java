package com.example.demofex;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ClassInsertInit {

    Scene scene;
    Stage stage;

    public ClassInsertInit() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("classinsert.fxml"));
        scene = new Scene(loader.load());
        stage = new Stage();

        stage.setScene(scene);
    }

    public void show(){
        stage.setTitle("add a class in your school");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    public void Close(){
        stage.close();
    }
}
