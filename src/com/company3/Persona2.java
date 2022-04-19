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
}
