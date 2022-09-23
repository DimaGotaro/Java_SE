package com.Core_sobes;

public class Cat {
    private int f;
    private String v;
    private static Long id;

    public Cat() {
    }

    public Cat(int f, String v) {
        this.f = f;
        this.v = v;
    }

    void fff() {
        fff2();
        Long id1 = id;
        int f1 = f;
    }
    static void fff2() {
        Long id1 = id;
        Cat cat = new Cat();
        int f1 = cat.f; // только через объект
    }
}
class Lion extends Cat {
    public Lion(int f, String v) {
        super(f, v);
    }
}
abstract class Ggg {
    public abstract void ggg();

    public static void ggg2() { }
}
