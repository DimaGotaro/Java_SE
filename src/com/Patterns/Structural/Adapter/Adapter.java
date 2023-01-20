package com.Patterns.Structural.Adapter;

public class Adapter extends JavaApp implements Database{
    @Override
    public void update() {
        loadObj();
    }

    @Override
    public void insert() {
        saveObj();
    }

    @Override
    public void select() {
        loadObj();
    }

    @Override
    public void remove() {
        deleteObj();
    }
}
