package com.Patterns.Structural.Adapter;

public class DBRun {
    public static void main(String[] args) {
        Database database = new Adapter();

        database.update();
        database.insert();
        database.select();
        database.remove();
    }
}
