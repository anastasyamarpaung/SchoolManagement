package com.example.demofex.Controller;

import com.example.demofex.Data.DropdownItemsThingy.TeacherListItem;
import com.example.demofex.Data.Student;
import com.example.demofex.StudentDeleteInit;
import com.example.demofex.StudentEditInit;
import com.example.demofex.StudentInsertInit;
import com.example.demofex.utils.common.DB;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import com.example.demofex.Data.DropdownItemsThingy.ClassListItem;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManagement {

    @FXML
    ChoiceBox<ClassListItem> Class;

    @FXML
    ChoiceBox<TeacherListItem> Homeroom_Teacher;

    @FXML
    TextField id;

    @FXML
    TextField name;

    @FXML
    TextField age;

    @FXML
    TableView StudentTable;

    @FXML
    public void initialize() {

        if (StudentTable != null) {
            try {
                ResultSet rs = (new DB()).Connect().createStatement().executeQuery(
                        "SELECT s.id as 'id', s.name as 'name', s.age as 'age', c.classname as 'classname', t.name as 'teacher_name' FROM student s INNER JOIN class c ON s.class = c.id INNER JOIN teacher t ON s.homeroom_teacher = t.id"
                );
                while (rs.next()) {
                    StudentTable.getItems().addAll(
                            new Student(
                                    rs.getInt("id"),
                                    rs.getString("name"),
                                    rs.getString("classname"),
                                    rs.getString("teacher_name"),
                                    rs.getInt("age")
                            )
                    );
                }
            } catch (SQLException sqe) {
                System.err.println(sqe);
            }
        }

        if (Class != null) {
            try {
                ResultSet rst = (new DB()).Connect().createStatement().executeQuery("SELECT * FROM class");
                while (rst.next()) {
                    Class.getItems().addAll(new ClassListItem(
                            rst.getString("classname"),
                            rst.getInt("id")
                    ));
                }
            } catch (SQLException sqe) {
                System.err.println(sqe);
            }

            Class.setValue(Class.getItems().get(0));
        }

        if (Homeroom_Teacher != null) {
            try {
                ResultSet rst = (new DB()).Connect().createStatement().executeQuery("SELECT * FROM teacher");
                while (rst.next()) {
                    Homeroom_Teacher.getItems().addAll(
                            new TeacherListItem(
                                    rst.getString("name"),
                                    rst.getInt("id")
                            )
                    );
                }

                Homeroom_Teacher.setValue(Homeroom_Teacher.getItems().get(0));
            } catch (SQLException sqe) {
                System.err.println(sqe);
            }
        }
    }

    public void ShowAddStudent(MouseEvent mouseEvent) throws IOException {
        StudentInsertInit sii = new StudentInsertInit();
        sii.show();
    }

    public void Drop(MouseEvent mouseEvent) throws SQLException {
        int _id = Integer.parseInt(id.getText());

        try{
            PreparedStatement stmt = (new DB()).Connect().prepareStatement("DELETE FROM student WHERE id = ?");
            stmt.setInt(1, _id);
            stmt.execute();
        }catch (SQLException s){
            throw s;
        }
    }

    public void RefreshTable() {
        if (StudentTable != null) {
            StudentTable.getItems().clear();
            try {
                ResultSet rs = (new DB()).Connect().createStatement().executeQuery(
                        "SELECT s.id as 'id', s.name as 'name', s.age as 'age', c.classname as 'classname', t.name as 'teacher_name' FROM student s INNER JOIN class c ON s.class = c.id INNER JOIN teacher t ON s.homeroom_teacher = t.id"
                );
                while (rs.next()) {
                    StudentTable.getItems().addAll(
                            new Student(
                                    rs.getInt("id"),
                                    rs.getString("name"),
                                    rs.getString("classname"),
                                    rs.getString("teacher_name"),
                                    rs.getInt("age")
                            )
                    );
                }
            } catch (SQLException sqe) {
                System.err.println(sqe);
            }
        }
    }

    public void ShowDeleteForm(MouseEvent mouseEvent) throws IOException{
        StudentDeleteInit sdi = new StudentDeleteInit();
        sdi.show();
    }

    public void Submit(MouseEvent mouseEvent) throws SQLException {
        int _classID = Class.getValue().getValue();
        int _homeroomTeacherID = Homeroom_Teacher.getValue().getValue();
        String _name = name.getText();
        int _age = Integer.parseInt(age.getText());

        try{
            PreparedStatement pstmt = (new DB()).Connect().prepareStatement(
                    "INSERT INTO student (name, age, class, homeroom_teacher) values (?, ?, ?, ?)"
            );
            pstmt.setString(1, _name);
            pstmt.setInt(2, _age);
            pstmt.setInt(3, _classID);
            pstmt.setInt(4, _homeroomTeacherID);
            pstmt.execute();

        }catch (SQLException sqe){
            throw sqe;
        }
    }

    public void ShowEditStudent(MouseEvent mouseEvent) throws IOException {
        StudentEditInit sei = new StudentEditInit();
        sei.show();
    }

    public void Update(MouseEvent mouseEvent) throws SQLException {
        int _classID = Class.getValue().getValue();
        int _homeroomTeacherID = Homeroom_Teacher.getValue().getValue();
        String _name = name.getText();
        int _age = Integer.parseInt(age.getText());
        int _id = Integer.parseInt(id.getText());

        try {
            PreparedStatement pstmt = (new DB()).Connect().prepareStatement(
                    "UPDATE student SET name = ?, age = ?, class = ?, homeroom_teacher = ? WHERE id = ?"
            );
            pstmt.setString(1, _name);
            pstmt.setInt(2, _age);
            pstmt.setInt(3, _classID);
            pstmt.setInt(4, _homeroomTeacherID);
            pstmt.setInt(5, _id);
            pstmt.execute();

        } catch (SQLException sqe) {
            throw sqe;
        }
    }
}
