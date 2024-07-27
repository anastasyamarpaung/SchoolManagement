package com.example.demofex;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class TeacherDeleteInit {
    private Stage stage;
    private Scene scene;

    public TeacherDeleteInit() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("teacherdelete.fxml"));
        scene = new Scene(loader.load());
        stage = new Stage();

        stage.setScene(scene);
    }

    public void show(){
        stage.setTitle("Delete a teacher");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void close(){ stage.close(); }

}
