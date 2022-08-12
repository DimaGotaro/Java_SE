package com.Core_sobes.Core_OOP;

public class OOP_1 {
    public String a;
    private static String f;
    private oop1 oop1;
    private static oop2 oop2;

    public void hhh() {
        String d = oop1.d;
        OOP_1.oop2.bbb();
        OOP_1.oop2 oop21 = OOP_1.oop2;
        oop21.bbb();
        String k = OOP_1.oop2.k;
    }
    public void eee() {
//        oop3 oop3 = new oop3(); - ошибка, можем создать объект только в методе
//        String n = oop3.n;
        class oop3 { // локальный класс, имеем доступ ко всем переменным и методам
            String n;
            public void qqq() {
                String a1 = a;
                String f1 = f;
                System.out.println("Hello!");
            }
        }

        oop3 oop3 = new oop3();
        oop3.qqq();
    }
    protected static void ggg() {
        OOP_1.oop2.bbb();
        String l = OOP_1.oop2.l;
        String k = OOP_1.oop2.k;
    }

    public class oop1 {

        public String d;
        public static String g;

        public void ppp() {
            OOP_1.ggg();
            String f1 = OOP_1.f;

            String k = OOP_1.oop2.k;

            String a1 = OOP_1.this.a;
            OOP_1.this.hhh();

            OOP_1.oop2.bbb();
            String l = OOP_1.oop2.l;
        }
    }

    static class oop2 {
        String l;
        static String k;
        public void bbb() {
            String f1 = OOP_1.f;
            OOP_1.ggg();
//            OOP_1.oop1.g // ошибка, нельзя получить доступ к статич перем нестатич вложенного класса

            OOP_1 oop_1 = new OOP_1();
            String a1 = oop_1.a;
            oop_1.hhh();

            OOP_1.oop1 oop11 = oop_1.new oop1();
            String d = oop11.d;
            oop11.ppp();
        }
    }
}
class OOP_12 extends OOP_1 {
     public static void ggg() {
    }
}
class OOP_11 {
    public static void main(String[] args) {
        String k = OOP_1.oop2.k;
        String g = OOP_1.oop1.g;

        OOP_1.oop2 oop2 = new OOP_1.oop2();
        oop2.l = "m";
        OOP_1.oop2 oop3 = new OOP_1.oop2();
        oop3.l = "n";
        System.out.println(oop2.l + " " + oop3.l);

        OOP_1 oop_1 = new OOP_1();
        OOP_1.oop1 oop_11 = oop_1.new oop1(); // объект вложенного нестатического класса
        String d = oop_11.d;
        oop_1.eee(); // метод из локального класса
        String a = oop_1.a;

        OOP_12.ggg();

        final String b = "kkr";
        String r = b.replaceAll("r", "");
        System.out.println(r);
    }
}
