package com.example.demofex.Data;

public class Kelas {
    public int id;
    public String classname;

    public Kelas(int id, String classname){
        this.id = id;
        this.classname = classname;
    }

    public String getClassname() {
        return classname;
    }

    public int getId() {
        return id;
    }
}
