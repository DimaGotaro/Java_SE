package com.company;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Person2 tom = new Person2("Tom");
        System.out.println(tom.hashCode());
        System.out.println(tom.hashCode2());
        System.out.println(tom.name.hashCode());
        // Исключения
        Scanner in = new Scanner(System.in);
        try {
            int[] mass = new int[3];
            mass[3] = 5;
            System.out.println(mass[3]);
        }
//        catch (Exception ex) { // работает на болишинство исключений
//            ex.printStackTrace();
//        }
        catch (ArrayIndexOutOfBoundsException ex) { // класс исключения который обрабатывает ошибки, только с
            // выходом за пределы массива
            System.out.println("Выход за пределы массива");
        }
        finally { // выполняется всегда, необязателен
            System.out.println("Finally");
        }
        // throw - оператор
        /*try {
            int a = in.nextInt();
            if (a>=30) { // создаём своё исключение, с помощью throw
                throw new Exception("Меньше 30"); // создали объект и использовали конструктор класса Exception
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }*/

        try { // обработка исключения в методе main
            System.out.println(fact(-3));
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
//            System.out.println("O");
        }
        System.out.println(fact2(-2));

        // Классы исключений
        try {
            int h = 6/0;
        }
        catch (Exception ex) {
            ex.printStackTrace(); // вывод ошибки
        }

        // Создание своих классов исключений
        try {
            System.out.println(Factorial.fact(-6));
        }
        catch (FactExt ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNumber());
        }
        hanoe(3, 'A', 'B', 'C');
    }
    public static int fact(int x) throws Exception {
        if (x < 1) throw new Exception("Ошибка!");
        int res = 1;
        for (int i=1; i <= x; i++) {
            res *= i;
        }
        return res;
    }
    public static int fact2(int x) { // обработка исключения в самом методе fact2
        int res = 1;
        try {
            if (x < 1) throw new Exception("Ошибка2!");
            for (int i=1; i <= x; i++) {
                res *= i;
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            res = x;
        }
        return res;
    }
    public static void hanoe(int n, char start, char help, char target) {
        if (n==1) {
            System.out.println("!Disk 1 from " + start + " to " + target);
        }
        else {
            hanoe(n-1, start, target, help);
            System.out.println("Disk " + n + " from " + start + " to " + target);
            hanoe(n-1, help, start, target);
        }
    }
}
class Person2 implements Cloneable {
    String name;

    Person2(String name) {
        this.name = name;
    }

    public int hashCode2() {
        return 5*name.hashCode()/3;
    }

    public Person2 clone() throws CloneNotSupportedException {
        return (Person2) super.clone();
    }
}
class Factorial {
    public static int fact(int x) throws FactExt { // throws - не нужно try/catch
        int result = 1;
        if (x < 1) throw new FactExt("Error!", x);
        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }
}
class FactExt extends Exception {
    private int number;

    public int getNumber() {
        return number;
    }

    public FactExt(String message, int x) {
        super(message);
        this.number = x;
    }
}
