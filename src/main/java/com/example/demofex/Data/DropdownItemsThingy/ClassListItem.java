package com.example.demofex.Data.DropdownItemsThingy;

public class ClassListItem {
    private String name;
    private int value;

    public ClassListItem(String name, int value){
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