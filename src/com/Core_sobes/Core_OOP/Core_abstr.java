package com.Core_sobes.Core_OOP;

import java.io.*;
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
class Singl implements Serializable {
    private static final Singl singl = new Singl();
    @Serial
    private static final long serialVersionUID = 3L;
    private String f;
    public Singl(String f) {
        this.f = f;
    }
    public String getF() {
        return f;
    }
    public void setF(String f) {
        this.f = f;
    }
    private Singl() {
    }
    public static Singl getSingl() {
        return singl;
    }
    @Override
    public String toString() {
        return "Singl{" +
                "f='" + f + '\'' +
                '}';
    }
    @Serial
    protected Object readResolve() throws ObjectStreamException {
        // при десериализации возвращает этот же объект
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
    @Serial
    private static final long serialVersionUID = 1L;
    private String o;
    private /*transient*/ Ser1 ser1;
    // transient - поле не будет сериализовано, ему будет присвоено null
    public Ser (Ser ser) { // конструктор копирования
        this.o = ser.o;
        this.ser1 = new Ser1(ser.ser1.getG());
    }
    public Ser(String o, Ser1 ser1) {
        this.o = o;
        this.ser1 = ser1;
    }
    public String getO() {
        return o;
    }
    public void setO(String o) {
        this.o = o;
    }
    public Ser1 getSer1() {
        return ser1;
    }
    public void setSer1(Ser1 ser1) {
        this.ser1 = ser1;
    }
    @Override
    public String toString() {
        return "Ser{" +
                "o='" + o + '\'' +
                ", ser1=" + ser1 +
                '}';
    }
}
class Ser1 implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    // все поля которые ссылаются на объекты других классов должны применять Serializable и
    // иметь поле serialVersionUID
    private String g;
    public Ser1(String g) {
        this.g = g;
    }
    public String getG() {
        return g;
    }
    public void setG(String g) {
        this.g = g;
    }
    @Override
    public String toString() {
        return "Ser1{" +
                "g='" + g + '\'' +
                '}';
    }
}
class Ser2 implements Externalizable {
    @Serial
    private static final long serialVersionUID = 4L;
    private String d;
    public Ser2(String d) {
        this.d = d;
    }
    public String getD() {
        return d;
    }
    public void setD(String d) {
        this.d = d;
    }
    public Ser2() {
    } // нужен обязательно
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getD());
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        d = (String) in.readObject();
    }
    @Override
    public String toString() {
        return "Ser2{" +
                "d='" + d + '\'' +
                '}';
    }
}
class Ser_main {
    public static void main(String[] args) {
        Ser dima = new Ser("Dima", new Ser1("Grande"));
        Singl singl = Singl.getSingl();
        singl.setF("Lampasy");
        Ser2 gargantua = new Ser2("Gargantua");

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(
                "C:\\Users\\dima\\IdeaProjects\\Java_SE\\src\\com\\Core_sobes\\Core_OOP\\serv.ser"));
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(
                "C:\\Users\\dima\\IdeaProjects\\Java_SE\\src\\com\\Core_sobes\\Core_OOP\\serv.ser")))
        {
            objectOutputStream.writeObject(dima); // сохранили состояние объекта
            objectOutputStream.writeObject(singl);
            objectOutputStream.writeObject(gargantua);

            Ser dima1 = (Ser) objectInputStream.readObject();
            System.out.println(dima1.toString());
            Singl singl1 = (Singl) objectInputStream.readObject();
            System.out.println(singl1.toString());
            System.out.println(singl == singl1);
            // без readResolve() - false, новый объект Singleton-на!
            // с readResolve() - true, объект тот же

            Ser2 gargantua1 = (Ser2) objectInputStream.readObject();
            System.out.println(gargantua1.toString());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
