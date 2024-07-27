package com.example.demofex.Data;

public class Teacher extends People{

    public String subject;


    public Teacher(int id, String name, int age, String subject){
        super.id = id;
        super.name = name;
        super.age = age;
        this.subject = subject;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public int getAge() {
        return super.age;
    }

    @Override
    public int getId() {
        return super.id;
    }

    public String getSubject() {
        return subject;
    }
}
