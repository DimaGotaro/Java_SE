package com.Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tasks {
    public static void main(String[] args) {
        Integer[] mass = {1,3,4,5,7};
        System.out.println(Arrays.toString(mass));
        System.out.println(mass);
//        pr(mass); // ошибка
        int b = 5;
        System.out.println(b);
        byte a = 1;
        short a1 = a; // неявное приведение
        System.out.println(a1);
        byte a2 = (byte) a1; // явное приведение
        System.out.println(a2);

        String f = "fjn";
        String g = "andromeda"; // f и g - ссылаются на один объект
        String b1 = String.valueOf(5);
        System.out.println(g.length());

        // перевернуть строку
        char[] b2 = g.toCharArray();
        char[] b3 = new char[b2.length];
        int j = 0;
        for (int i = b2.length - 1; i >= 0; i--) {
            b3[j] = b2[i];
            ++j;
        }
        String b4 = String.valueOf(b3);
        System.out.println(g);
        System.out.println(b4);

        List<String> b5 = Arrays.asList(
                "Philip J. Fry",
                "Turanga Leela",
                "Bender Bending Rodriguez"
        );
        String b6 = String.join("; ", b5); // из коллекции в строку, через разделитель
        System.out.println(b6);

        String[] b7 = b6.split("; ");
        for (String r:
             b7) {
            System.out.println(r);
        }

        // изменить первую букву у всех строк в массиве строк
        int b9 = 0;
        String[] b8 = new String[b7.length];
        for (String r:
                b7) {
            char[] chars = r.toCharArray();
            chars[0] = 'F';
            b8[b9] = String.valueOf(chars);
            ++b9;
        }
        for (String r:
                b8) {
            System.out.println(r);
        }

        // получить строку из строки начиная с последней встречи нескольких символов в виде строки
        String b11 = b6.substring(b6.lastIndexOf("; ") + 2);
        System.out.println(b11.toUpperCase());

        String c = "java"; // все строки созданные с помощью литерала помещаются в string pool
        String c1 = "java";
        String c2 = new String("java"); // new - не сохраняет в пуле строк
        // == - сравнивает по ссылке на объект
        System.out.println(c == c1); // true, c и c1 ссылаются на один объект в string pool
        System.out.println(c == c2); // false, c2 новый объект
        System.out.println(c.equals(c2)); // true, сравнение по символам
        String c3 = new String("java").intern(); // сохранили в пул строк
        System.out.println(c == c3); // true, после intern c3 получил ссылку из string pool
        System.out.println(c1.hashCode());

        // проверим является ли строка палиндромом
        String c4 = "Jokonda";
        System.out.println(c4);
        char[] c5 = new char[c4.length()];
        int j1 = c4.length() - 1;
        for (int i = 0; i <= c4.length() - 1; i++) {
            c5[j1] = c4.charAt(i);
            --j1;
        }
        String c6 = String.valueOf(c5);
        System.out.println(c6);

        String c7 = "Kdfdk";
        StringBuilder stringBuilder = new StringBuilder(c7);
        StringBuilder reverse = stringBuilder.reverse();
        System.out.println(c7.equals(reverse.toString())); // false
        System.out.println(c7.equalsIgnoreCase(reverse.toString())); // true
        System.out.println(c7.compareTo(reverse.toString())); // -32
        System.out.println(c7.compareToIgnoreCase(reverse.toString())); // 0

        // сортировка массива по возрастанию
        int[] c8 = {6, 3, 9, 1, 2, 5, 3};
        System.out.println(Arrays.toString(c8));
        for (int i = 0; i < c8.length - 1; i++) {
            for (int l = i + 1; l < c8.length; l++) {
                if (c8[i] > c8[l]) {
                    int c9 = c8[i];
                    c8[i] = c8[l];
                    c8[l] = c9;
                }
            }
        }
        System.out.println(Arrays.toString(c8));

        // в массиве строк, заменить у каждой строки второй символ на "А"
        int i2 = 0;
        for (String d1 :
                b7) {
            StringBuilder stringBuilder1 = new StringBuilder(d1);
            stringBuilder1.replace(2, 3, "A");
            d1 = String.valueOf(stringBuilder1);
            b7[i2] = d1;
            ++i2;
        }
        for (String d2 :
                b7) {
            System.out.println(d2);
        }

        System.out.println(b6);

        // заменим все "i" на "F"
        String replace = b6.replace("i", "F");
        System.out.println(replace);

        // Удалим все "F"
        String f1 = replace.replaceAll("F", "");
        System.out.println(f1);

        // из строки в массив байтов
        byte[] d2 = f1.getBytes();
        System.out.println(Arrays.toString(d2));
        String d3 = new String(d2);
        System.out.println(d3);

        // как нужно хранить пароли
//        String d4 = "bambino";
//        JPasswordField jPasswordField = new JPasswordField(d4);
//        for (char c9 : jPasswordField.getPassword()) {
//            System.out.print(c9);
//        }

        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        System.out.println(list.size());
        System.out.println(list.get(list.size()/2));
        int y = list.size()-1;
        for (int i = 0; i < list.size(); i++) {
            if (y == i) {
                System.out.println(list.get(i));
            }
            --y;
        }

        int[] mass3 = new int[] {1, 3, 5, 6, 7};
        int r = 0;
        for (int i = mass3.length - 1; i >= mass3.length/2; i--) {
            int t = mass3[r];
            mass3[r] = mass3[mass3.length - 1 - r];
            mass3[mass3.length - 1 - r] = t;
            r++;
        }
        System.out.println(Arrays.toString(mass3));

        Tasks tasks = new Tasks();
        int q = 1;
        tasks.sss(q);
        System.out.println(q);

        Integer q1 = 129;
        Integer q2 = 129;
        System.out.println(q1.equals(q2)); // true
    }
    public static void pr(int[] f) {
        System.out.println(Arrays.toString(f));
    }
    public void sss(int m) {
        m += 2;
        System.out.println(m);
    }
}
