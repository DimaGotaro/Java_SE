package com.Patterns.Structural.Proxy;

public class Client {
    public static void main(String[] args) {
        Proj proj = new Proxy("http://www.gogo.com/blblb");

        proj.run();
    }
}
