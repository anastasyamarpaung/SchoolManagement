package com.example.demofex.Data;

public class Student extends People {

    private String class_name;
    private String teacher_name;

    public Student(int id, String  name, String class_name, String teacher_name, int age){
        super.id = id;
        super.name = name;
        this.class_name = class_name;
        this.teacher_name = teacher_name;
        super.age = age;
    }

    public int getAge() {
        return super.age;
    }

    public int getId() {
        return super.id;
    }

    public String getName() {
        return super.name;
    }

    public String getClass_name() {
        return class_name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }
}
