package com.example.demofex.Controller;

import com.example.demofex.Data.People;
import com.example.demofex.Data.Teacher;
import com.example.demofex.TeacherDeleteInit;
import com.example.demofex.TeacherInsertInit;
import com.example.demofex.TeacherUpdateInit;
import com.example.demofex.utils.common.DB;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherManagement implements Data  {

    @FXML
    TextField namein;
    @FXML
    TextField agein;
    @FXML
    TextField subjectin;
    @FXML
    TextField id;
    @FXML
    TableView<Teacher> tabledata;

    @FXML
    public void initialize() throws SQLException {
        if(tabledata != null){
            try{
                DB database = new DB();
                Statement stmt = database.Connect().createStatement();
                ResultSet rst = stmt.executeQuery("SELECT * FROM teacher");

                while(rst.next()){
                    System.out.println(rst.getString("name"));
                    tabledata.getItems().addAll(new Teacher(rst.getInt("id"), rst.getString("name"), rst.getInt("age"), rst.getString("subject")));
                }

            }catch (SQLException sqe){
                System.out.println(sqe);
            }
        }
    }

    @Override
    @FXML
    public void Insert(MouseEvent event) throws SQLException{
        String name = namein.getText();
        String age = agein.getText();
        String subject_teaching = subjectin.getText();

        System.out.println(name);
        System.out.println(age);
        System.out.println(subject_teaching);

        DB database = new DB();
        PreparedStatement stmt = database.Connect().prepareStatement(
                "INSERT INTO teacher (name, age, subject) VALUES (?, ?, ?)"
        );
        stmt.setString(1, name);
        stmt.setInt(2, Integer.parseInt(age));
        stmt.setString(3, subject_teaching);

        stmt.execute();
    }

    @Override
    @FXML
    public void Update(MouseEvent event) throws SQLException{
        String name = namein.getText();
        Integer age = Integer.parseInt(agein.getText());
        String subject_teaching = subjectin.getText();
        Integer _id = Integer.parseInt(id.getText());

        DB database = new DB();
        PreparedStatement stmt = database.Connect().prepareStatement(
                "UPDATE teacher SET name = ?, age = ?, subject = ? WHERE id = ?"
        );
        stmt.setString(1, name);
        stmt.setInt(2, age);
        stmt.setString(3, subject_teaching);
        stmt.setInt(4, _id);

        stmt.execute();
    }

    public void RefreshTable(MouseEvent mouseEvent) {
        if(tabledata != null){
            tabledata.getItems().clear();
            try{
                DB database = new DB();
                Statement stmt = database.Connect().createStatement();
                ResultSet rst = stmt.executeQuery("SELECT * FROM teacher");

                while(rst.next()){
                    System.out.println(rst.getString("name"));
                    tabledata.getItems().addAll(new Teacher(rst.getInt("id"), rst.getString("name"), rst.getInt("age"), rst.getString("subject")));
                }

            }catch (SQLException sqe){
                System.out.println(sqe);
            }
        }
    }

    @Override
    @FXML
    public void Drop(MouseEvent event) throws SQLException{
        int _id = Integer.parseInt(id.getText());
        DB database = new DB();
        PreparedStatement stmt = database.Connect().prepareStatement("DELETE FROM teacher WHERE id = ?");
        stmt.setInt(1, _id);
        stmt.execute();

    }

    @FXML
    public void ShowInsertPage() throws IOException {
        TeacherInsertInit tii = new TeacherInsertInit();
        tii.show();
    }

    public void ShowDeletePage(MouseEvent mouseEvent) throws IOException {
        TeacherDeleteInit tdi = new TeacherDeleteInit();
        tdi.show();
    }

    public void ShowUpdatePage(MouseEvent mouseEvent) throws IOException {
        TeacherUpdateInit tui = new TeacherUpdateInit();
        tui.show();
    }

}