package com.Core_sobes.Core_OOP;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Vector;

public class NewOOP {
    public static void main(String[] args) {
        Pather pather = new Pather();
        byte t = pather.t;
        System.out.println(pather.getR());
        pather.methodP();

        Pather patherChild = new Child();
        byte t1 = patherChild.t;
        patherChild.methodP();
        System.out.println(patherChild.getR());

        Child child = new Child();
        short y = child.y;
        byte t2 = child.t;
        child.methodC();
        child.methodP();
        System.out.println(child.getR());

        String f;
        StringBuilder g;
        StringBuffer h;

//        Reflection API
        String name;
        try {
            Field field = pather.getClass().getDeclaredField("name");
            field.setAccessible(true);
            name = (String) field.get(pather);
            System.out.println(name);

            field.set(pather, "Set name, no Hello world");
            name = (String) field.get(pather);
            System.out.println(name);

            Method method = pather.getClass().getDeclaredMethod("methodP_Private");
            method.setAccessible(true);
            method.invoke(pather); // вызов приватного метода
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
class Pather {
    private int r;
    byte t;
    private final String name = "Hello world!";

    public int getR() {
        return r;
    }
    void methodP() { }

    private void methodP_Private() {
        System.out.println("Private method!");
    }
}
class Child extends Pather {
    short y;
    @Override
    public int getR() {
        return super.getR() + 2;
    }
    void methodC() {
        super.methodP();
        byte t1 = super.t;
    }
}
