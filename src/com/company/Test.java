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
        try {
            int a = in.nextInt();
            if (a>=30) { // создаём своё исключение, с помощью throw
                throw new Exception("Меньше 30"); // создали объект и использовали конструктор класса Exception
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
class Person2 {
    String name;

    Person2(String name) {
        this.name = name;
    }

    public int hashCode2() {
        return 5*name.hashCode()/3;
    }
}
