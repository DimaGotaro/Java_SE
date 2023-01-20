package com.Patterns.Structural.Decorator;

public class Task {
    public static void main(String[] args) {
        Devel devel = new JavaTM(new SeniorJavaDevel(new JavaDevel()));

        System.out.println(devel.makeJob());
    }
}
