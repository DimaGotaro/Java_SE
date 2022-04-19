package com.company2;
import static com.company.Main2.*; // статические методы нужно импортировать через import static!
import static java.lang.System.*; // статический импорт
import static java.lang.Math.*; // пакет java.lang подключён автоматически
public class Main3 {
    public static void main(String[] args) {
        System.out.println("Hello!");

        Persona all = new Persona();
        all.inf();
        Persona carl = new Persona("Carl", 26);
        carl.inf();
        Persona all2 = new Persona("Неизвестный");
        all2.inf();

//        double a1 = Math.sqrt(26);
        double a1 = sqrt(17); // Math. - можно не писать, из-за операции статического импорта и того что Math
        // статический метод
        out.printf("%.2f\n", a1); // System. - можно не писать, из-за операции статического импорта
        hello();
    }
}
class Persona { /*нельзя использовать в других пакетах, класс не public, а public может быть только один!*/
    String name;
    int age;

    {
        name = "Любой";
        age = 19;
    }

    Persona() {    }

    Persona(String n, int g) {
        name=n;
        age=g;
    }

    Persona(String n){
        name=n;
    }

    void inf() {
        System.out.printf("Имя: %s,\t Возраст: %d\n", name,age);
    }
}
