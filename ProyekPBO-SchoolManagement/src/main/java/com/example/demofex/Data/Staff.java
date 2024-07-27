package com.example.demofex.Data;

public class Staff extends People{

    private String position;
    private String name;

    public Staff(String name, int age, int id, String position){
        this.name = name;
        super.id = id;
        super.age = age;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return super.age;
    }

    @Override
    public int getId() {
        return super.id;
    }
}
