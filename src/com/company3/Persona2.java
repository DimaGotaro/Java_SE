package com.company3;

public class Persona2 { // класс можно импортировать в другие пакеты
    String name;
    int age;

    {
        name = "Любой";
        age = 19;
    }

    public Persona2() {    }

    public Persona2(String n, int g) {
        name=n;
        age=g;
    }

    public Persona2(String n){
        name=n;
    }

    public void inf() {
        System.out.printf("Имя: %s.\t Возраст: %d\n", name,age);
    }

    // static

    AnyClass anyClass;
    int d = 5;

    public static AnyClass staticAnyClass;
    static int c = 4;

    public void obj() {
        Persona2.stat();
        stat();
        obj();
        AnyClass.jsnf();
        AnyClass test4 = new AnyClass();
        test4.kjn();
        anyClass.kjn();
        staticAnyClass.kjn();
        AnyClass.a = 2;
        test4.b = 6;
    }

    static void stat() {
        Persona2 test = new Persona2();
        test.obj();
        stat();
        AnyClass.jsnf();
        staticAnyClass.kjn();
        c=9;
        test.d=3;
        AnyClass test2 = new AnyClass();
        test2.kjn();
        AnyClass.a = 3;
        test2.b = 7;
    }
}
class AnyClass {
    Persona2 test3 = new Persona2();
//    test3.obj(); // Ошибка!
//    Persona2.stat(); // Ошибка!
    void kjn() {
        Persona2.stat();
        Persona2 test5 = new Persona2();
        test5.obj();
        Persona2.c=8;
        test5.d = 5;
    }
    static void jsnf() {
        Persona2.stat();
        Persona2 test6 = new Persona2();
        test6.obj();
        Persona2.c=6;
        test6.d = 9;
    }
    static int a = 1;
    int b = 5;
}
