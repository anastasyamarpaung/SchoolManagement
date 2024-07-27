package com.example.demofex.Controller;

import com.example.demofex.Data.Staff;
import com.example.demofex.StaffAddInit;
import com.example.demofex.StaffDeleteInit;
import com.example.demofex.StaffEditInit;
import com.example.demofex.utils.common.DB;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StaffManagement {
    @FXML
    TableView StaffTable;

    @FXML
    TextField name;

    @FXML
    TextField id;

    @FXML
    TextField age;

    @FXML
    TextField position;

    public void initialize(){
        if(StaffTable != null){
            try{
                ResultSet rst = (new DB()).Connect().createStatement().executeQuery("SELECT * FROM staff");
                while(rst.next()){
                    StaffTable.getItems().addAll(
                            new Staff(
                                    rst.getString("name"),
                                    rst.getInt("age"),
                                    rst.getInt("id"),
                                    rst.getString("position")
                            )
                    );
                }
            }catch (Exception e){
                System.err.println(e);
            }
        }
    }

    public void ShowAddStaff(MouseEvent mouseEvent) throws Exception {
        StaffAddInit sai =  new StaffAddInit();
        sai.show();
    }

    public void ShowEditStaff(MouseEvent mouseEvent) throws Exception {
        StaffEditInit sei = new StaffEditInit();
        sei.show();
    }

    public void ShowDeleteStaff(MouseEvent mouseEvent) throws Exception{
        StaffDeleteInit sdi = new StaffDeleteInit();
        sdi.show();
    }
    
    public void Update(){
        int _id = Integer.parseInt(id.getText());
        String _nama = name.getText();
        int _age = Integer.parseInt(age.getText());
        String _pos = position.getText();

        try{
            PreparedStatement pstm = (new DB()).Connect().prepareStatement("UPDATE staff SET name = ?, age = ?, position = ? WHERE id = ?");
            pstm.setString(1, _nama);
            pstm.setInt(2, _age);
            pstm.setString(3, _pos);
            pstm.setInt(4, _id);
            pstm.execute();
        }catch (Exception e){

        }
    }

    public void Insert(MouseEvent mouseEvent) {
        String _name = name.getText();
        int _age = Integer.parseInt(age.getText());
        String _position = position.getText();
        try{
            PreparedStatement ps = (new DB()).Connect().prepareStatement(
                    "INSERT INTO staff (name, age, position) VALUES (?, ?, ?)"
            );
            ps.setString(1, _name);
            ps.setInt(2, _age);
            ps.setString(3, _position);
            ps.execute();
        }catch (Exception e){
            System.err.println(e);
        }
    }

    public void RefreshTable(MouseEvent mouseEvent) {
        if(StaffTable != null){
            StaffTable.getItems().clear();
            try{
                ResultSet rst = (new DB()).Connect().createStatement().executeQuery("SELECT * FROM staff");
                while(rst.next()){
                    StaffTable.getItems().addAll(
                            new Staff(
                                    rst.getString("name"),
                                    rst.getInt("age"),
                                    rst.getInt("id"),
                                    rst.getString("position")
                            )
                    );
                }
            }catch (Exception e){
                System.err.println(e);
            }
        }
    }

    public void Drop(MouseEvent mouseEvent) {
        int _id = Integer.parseInt(id.getText());

        try{
            PreparedStatement ps = (new DB()).Connect().prepareStatement("DELETE FROM staff WHERE id = ?");
            ps.setInt(1, _id);
            ps.execute();
        }catch (Exception e){
            System.err.println(e);
        }
    }
}
