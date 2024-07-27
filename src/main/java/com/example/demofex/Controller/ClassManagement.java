package com.example.demofex.Controller;

import com.example.demofex.ClassDeleteInit;
import com.example.demofex.ClassInsertInit;
import com.example.demofex.ClassUpdateInit;
import com.example.demofex.Data.Kelas;
import com.example.demofex.utils.common.DB;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClassManagement {

    @FXML
    TableView classtable;

    @FXML
    TextField classname;

    @FXML
    TextField id;

    @FXML
    public void initialize(){
        try{
            if(classtable != null){
                DB database = new DB();
                ResultSet rst = database.Connect().createStatement().executeQuery("SELECT * FROM class");

                while(rst.next()){
                    classtable.getItems().add(new Kelas(
                            rst.getInt("id"),
                            rst.getString("classname")
                    ));
                }
            }
        }catch (SQLException sqe){
            System.out.println("ERROR AT SQL : " + sqe);
        }
    }

    @FXML
    public void StartAddClassWindow() throws IOException {
        ClassInsertInit cii = new ClassInsertInit();
        cii.show();
    }

    public void Insert(MouseEvent mouseEvent) {
        // getting the data first
        String _classname = classname.getText();

        try{
            // make the connection and statement
            PreparedStatement stmt = (new DB()).Connect().prepareStatement("INSERT INTO class (classname) VALUES (?)");
            stmt.setString(1, _classname);
            stmt.execute();
        }catch (SQLException sqe){
            System.out.println(sqe);
        }
    }

    public void ShowUpdateClass(MouseEvent mouseEvent) throws IOException {
        ClassUpdateInit cui = new ClassUpdateInit();
        cui.show();
    }

    public void ShowDeleteClass(MouseEvent mouseEvent) throws IOException{
        ClassDeleteInit cdi = new ClassDeleteInit();
        cdi.show();
    }

    public void Update(){
        // gathering data.
        int _id = Integer.parseInt(id.getText());
        String _newclassname = classname.getText();

        try{
            PreparedStatement pstmt = (new DB()).Connect().prepareStatement(
                    "UPDATE class set classname = ? WHERE id = ?"
            );
            pstmt.setInt(2, _id);
            pstmt.setString(1, _newclassname);
            pstmt.execute();
        }catch (SQLException sqe){
            System.err.println(sqe);
        }
    }

    public void Drop(){
        int _id = Integer.parseInt(id.getText());

        try{
            PreparedStatement pstmt = (new DB()).Connect().prepareStatement(
                    "DELETE FROM class WHERE id = ?"
            );
            pstmt.setInt(1, _id);
            pstmt.execute();
        }catch (SQLException sqe){
            System.err.println(sqe);
        }
    }

    public void Refresh(MouseEvent mouseEvent) {
        classtable.getItems().clear();
        try{
            if(classtable != null){
                DB database = new DB();
                ResultSet rst = database.Connect().createStatement().executeQuery("SELECT * FROM class");

                while(rst.next()){
                    classtable.getItems().add(new Kelas(
                            rst.getInt("id"),
                            rst.getString("classname")
                    ));
                }
            }
        }catch (SQLException sqe){
            System.out.println("ERROR AT SQL : " + sqe);
        }
    }
}
