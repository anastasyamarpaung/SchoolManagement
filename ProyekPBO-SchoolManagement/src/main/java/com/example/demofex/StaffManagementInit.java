package com.example.demofex;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class StaffManagementInit {
    private Stage stage;
    private Scene scene;

    public StaffManagementInit() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("staffman.fxml"));
        scene = new Scene(loader.load());
        stage = new Stage();

        stage.setScene(scene);
    }

    public void show(){
        stage.setTitle("Manage your School Staffs");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void close(){
        stage.close();
    }
}
