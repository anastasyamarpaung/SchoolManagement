package com.example.demofex.Controller;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public interface Data {
    void Insert(MouseEvent event) throws SQLException;
    void Update(MouseEvent event) throws SQLException;
    void Drop(MouseEvent event) throws SQLException;
}
