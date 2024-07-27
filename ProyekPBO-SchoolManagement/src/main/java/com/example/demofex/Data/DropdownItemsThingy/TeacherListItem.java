package com.example.demofex.Data.DropdownItemsThingy;

public class TeacherListItem {
    String name;
    int value;

    public TeacherListItem(String name, int value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getName();
    }
}
