package com.Core_sobes.Core2;

import com.Core_sobes.Core.Core_1;

public class Core_2_1 extends Core_1{
    public String a2;

    public Core_2_1(String a2, String a, String b, String d, String cc) {
        super(a, b, d, cc);
        this.a2 = a2;
    }

    public Core_2_1(String a2, String a) {
        super(a);
        this.a2 = a2;
    }

    public static void main(String[] args) {
//        a;
//        a2;
        Core_1 core_1 = new Core_1();
        String a = core_1.a; // только через объект!
        System.out.println(a);
//        String b = core_1.b; // без модификатора, внешний пакет
//        Core_2_1 c2 = core_1.c; // protected в статическом методе, не доступен!
//        core_1.cc;
//        core_1.d // d - private

//        core_1.abc(); // - ошибка

        String cc21 = Core_1.cc2; // protected
    }

    public void aVoid() {
        Core_2_1 c1 = c; // если метод не статический, можем использовать
        String cc1 = cc;
        abc();
        String cc21 = Core_1.cc2;
        String a1 = a;
        String a21 = a2;
        Core_1.sabc();
    }

    @Override
    protected void abc() {
        System.out.println("Cba!");
    }

    @Override
    public void abc2() {
        System.out.println("Гав, гав!");
    }
}

class Core_2_2 {
    public static void main(String[] args) {
        Core_1 core_1 = new Core_1();
        String a = core_1.a;
//        String b = core_1.b; // без модификатора, внешний пакет
//        Core_2_1 c = core_1.c; // protected - внешний пакет, не производный класс
//        core_1.d // d - private

        Core_2_1 core_2_1 = new Core_2_1("1", "2");
        // имеем доступ к переменным и класса наследника и класса родителя
        System.out.println(core_2_1.a2);
        System.out.println(core_2_1.a);
        core_2_1.abc();
        core_2_1.abc2();
        core_2_1.vb(core_1); // Полиморфизм подтипов

        Core_1 core_2_12 = new Core_2_1("1", "2");
        // имеем доступ только к переменным класса родителя
//        System.out.println(core_2_12.a2);
        System.out.println(core_2_12.a);
        core_2_12.abc2();
//        core_2_12.abc(); // ошибка, protected

        Core_2_1 core21 = (Core_2_1) core_2_12;

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement f :
                stackTraceElements) {
            System.out.println(f);
        }
    }
    public void cr() {
        Core_2_1 core_2_1 = new Core_2_1("1", "2");
        // имеем доступ к переменным и класса наследника и класса родителя
        System.out.println(core_2_1.a2);
        System.out.println(core_2_1.a);

        Core_1 core_2_12 = new Core_2_1("1", "2");
        // имеем доступ только к переменным класса родителя
//        System.out.println(core_2_12.a2);
        System.out.println(core_2_12.a);
    }
}
