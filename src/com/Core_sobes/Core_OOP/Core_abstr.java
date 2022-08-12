package com.Core_sobes.Core_OOP;

import java.io.Serializable;
import java.util.Arrays;

public abstract class Core_abstr {
    private String a;
    public String b;
    public abstract void vvv();
    static void nnn() {}
    public void ggg() {}
    public Core_abstr(String a) {
        this.a = a;
    }

    public Core_abstr() {
    }

    public String getA() {
        return a;
    }
}
class Core_a1 extends Core_abstr {
    public String g;
    public Core_a1(String a) {
        super(a);
    }
    @Override
    public void vvv() {
        System.out.println("Bye!");
    }

}
class Core_a2 extends Core_abstr {
    public String g2;
    public Core_a2(String a) {
        super(a);
    }
    @Override
    public void vvv() {
        System.out.println("Poka!");
    }
}
abstract class Core_a3 extends Core_abstr {
    public Core_a3(String a) {
        super(a);
    }
}
class Core_am {
    public static void main(String[] args) {
        Core_a1 core_a1 = new Core_a1("f");
        core_a1.vvv();
        String b = core_a1.b;
        String g = core_a1.g;

        Core_abstr core_abstr = new Core_a2("v");
        core_abstr.vvv(); // метод наследник
        String b1 = core_abstr.b; // только переменные класса родителя

        Core_abstr core_abstr1 = new Core_abstr("b") {
            @Override
            public void vvv() {
                System.out.println("Good Bye!");
            }
        };
        core_abstr1.vvv();
        System.out.println(core_abstr1.getA());
    }
}
class Core_n {
    String f;
    public void jjj() {
        System.out.println("1234");
    }
}
class Core_n1 extends Core_n {
    @Override
    public void jjj() {
        System.out.println("4321");
    }

    String v;
    public static void main(String[] args) {
        Core_n core_n = new Core_n();
        String f1 = core_n.f;
        core_n.jjj(); // родительский метод

        Core_n core_n1 = new Core_n1();
        String f2 = core_n1.f; // доступ только к полям род класса
        core_n1.jjj(); // метод наследник

        Core_n1 core_n11 = new Core_n1();
        String f3 = core_n11.f;
        String v1 = core_n11.v;
        core_n11.jjj(); // метод наследник

        Core_a4 core_a4 = new Core_a4();
        core_a4.aaa();
        core_a4.bbb();
        core_a4.aaa2();
        core_a4.nnn();
        Core_i core_i = new Core_a4();
        core_i.aaa(); // только переопределённые методы
        core_i.bbb();
        Core_i1 core_i1 = new Core_a4();
        core_i1.aaa2(); // только метод класса наследника, если без наследования интерфейса
//        core_i1.aaa(); // с наследованием одного интерфейса другим
        core_i1.bbb(); // с наследованием одного интерфейса другим

        Day a = Day.A;
        System.out.println(a);
        System.out.println(Arrays.toString(Day.values()));
        System.out.println(Day.valueOf("B"));
        System.out.println(Day.C.getW());
        System.out.println(Day.A.ordinal());

        Singl singl = Singl.getSingl();
    }
}
interface Core_i {
    String a = "Corsika";
    void aaa();
    default void bbb() { }
    private void ccc() { }
    static void ddd() { }
    default void ggg() {}
}
interface Core_i1 {
    void aaa2();
    default void bbb() {}
}
class Core_a4 implements Core_i, Core_i1 {
    @Override
    public void aaa() {
        String a1 = Core_i.a;
        System.out.println(a1);
    }

    @Override
    public void bbb() { // в двух интерфейсах одинаковые методы, нужно обяз переопр
        Core_i1.super.bbb(); // выбор метода с одинаковым названием
    }

    @Override
    public void aaa2() {}

    public void nnn() {}
}
class Core_ob extends Core_abstr implements Core_i {

    public Core_ob(String a) {
        super(a);
    }
    @Override
    public void vvv() {

    }
    @Override
    public void aaa() {

    }

    @Override
    public void ggg() {
        super.ggg();
    }
}
enum Day {
    A("ето А"),
    B("ето Б"),
    C("ето С");
    private String w;
    Day(String w) {
        this.w = w;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    @Override
    public String toString() {
        return "Day{" +
                "w='" + w + '\'' +
                '}';
    }
}
class Singl {
    private static final Singl singl = new Singl();
    private Singl() {
    }
    public static Singl getSingl() {
        return singl;
    }
}
class Lazy_Singl {
    private static Lazy_Singl lazy_singl;
    public Lazy_Singl() {
    }
    public static Lazy_Singl getLazy_singl() {
        if (lazy_singl == null) {
            lazy_singl = new Lazy_Singl();
        }
        return lazy_singl;
    }
}
class Ser implements Serializable {
    
}
