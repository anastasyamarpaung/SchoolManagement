package com.example.demofex.utils.common;

import java.sql.*;

public class DB {
    private Connection conn;
    public Connection Connect() throws SQLException {
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/appocalypsesm", "root", "");
            System.out.println("Koneksi ke DB Berhasil berhasil");
            return conn;
        }catch (SQLException ex){
            System.out.println("Koneksi ke database gagal!");
            System.out.println(ex);
            return null;
        }
    }

    public ResultSet RetrieveData(String query) throws SQLException {
        Statement stmt;
        try{
             stmt = this.Connect().createStatement();
            return stmt.executeQuery(query);
        }catch (SQLException sqe){
            System.out.println(sqe);
            return null;
        }
    }
}
