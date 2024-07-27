package com.example.demofex.Controller;

import com.example.demofex.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Home {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void opentmpage(MouseEvent mouseEvent) throws IOException {
        TeacherManagementInit tmi = new TeacherManagementInit();
        tmi.show();
    }

    @FXML
    public void opencmpage(MouseEvent mouseEvent) throws IOException {
        ClassManagementInit cmi = new ClassManagementInit();
        cmi.show();
    }

    public void opensmpage(MouseEvent mouseEvent) throws IOException {
        StaffManagementInit smi = new StaffManagementInit();
        smi.show();
    }

    public void openstmpage(MouseEvent mouseEvent) throws IOException{
        StudentManagementInit smi = new StudentManagementInit();
        smi.show();
    }
}