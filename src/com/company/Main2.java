package com.company;
//import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int a1,b1; /*объявление переменной*/
//        есть ещё byte, short, long, для целочисленных значений
        a1=2; /*присвоение значения*/
        b1=1;
        System.out.println("a1= " + a1); /* + - значения на одной строке, если только числа то суммирует*/
        System.out.println("b1= " + b1);
        int a2=3, b2=4; /*объявление и инициализация переменной*/
        System.out.println(a2);
        System.out.println(b2);
        a2=5; /*значение переменной можно менять*/
        System.out.println(a2);
        var c1=10; /*var сам определяет тип переменной, нужно сразу инициализировать*/
        System.out.println(c1);
        final int C2=11; /*константа, нельзя изменять после, имя в верхнем регистре*/
        System.out.println(C2);
        boolean d1=true;
        System.out.println(d1);
        long d2=2_147_483_649L; /*если число больше 2147483648*/
        System.out.println(d2);
        int d3=0x6f; /*111 в 16-ричной системе счисления*/
        System.out.println(d3);
//        числа с плавающей точкой
        double d4=2.8;
        System.out.println(d4);
        float d5=3.7f;
        System.out.println(d5);
//        символы
        char d6=101; /*символ, от 0 до 65535 по таблице UTF-16*/
        System.out.println(d6);
        char d7='f';
        System.out.println(d7);

//        строки
        String e1="Hello \nJava!"; /*\n - перенос на следующую строку*/
        System.out.println(e1);
        String e2="Вот мысль, которой весь я предан,\n" +
                "Итог всего, что ум скопил.";
        System.out.println(e2);
        String e3= """
                Лишь тот, кем бой за жизнь изведан,
                Жизнь и свободу заслужил.""";
        System.out.println(e3);
        System.out.print("Hello world!"); /*не переводит курсор на следующую строку в консоли*/
//        System.out.print("Hello world! \n"); /*можно перевести на след строку с помощью \n*/
        System.out.println("Hello java!");
        System.out.println(a1+b1); /*сумма*/
        System.out.println(a1+" "+b1); /*перечисление*/
        String e4="Dima";
//        printf
        System.out.printf("Name=%s; Age=%d; Height=%.3f; \n",e4,a1,d5);

        /*Scaner, ввод значений
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String f1= in.nextLine();
        System.out.print("Введите возраст: ");
        int f2= in.nextInt();
        System.out.print("Введите вес: ");
        float f3= in.nextFloat(); //вводить нужно через запятую, с точкой ошибка
        System.out.printf("Name=%s; Age=%d; Height=%.2f; \n", f1, f2, f3);
        in.close();*/

        /*Арифметические операции*/
        int g1=25,g2=4,g3,g6,g12=2;
        g3=g2*g1;
        double g4,g5=4.0; //если ответ нужен с дробной частью, одна из переменных должна быть с плавающей точкой!
        g4=g1/g5;
        g6=g1%g2; //остаток от деления
        System.out.println(g3);
        System.out.println(g4);
        System.out.println(g6);
        System.out.println(g1);
        int g7=++g1; //префиксный инкремент, меняет значение g1 и g7 на +1, теперь (g1 и g7)=26
        //изменяет переменную в выражении и в следующих строках, правоассоциативный!
        System.out.println(g7);
        System.out.println(g1);
        int g8=g2++; //постфиксный инкремент,меняет значение g2 на +1, g2=5
        //изменяет переменную только в следующих строках, левоассоциативный!
        System.out.println(g8);
        System.out.println(g2);
        int g9=--g1; //префиксный декремент, меняет значение g1 и g9 на -1, теперь (g1 и g9)=25
        //правоассоциативный!
        System.out.println(g9);
        System.out.println(g1);
        int g10=g2--; //постфиксный декремент,меняет значение g2 на -1, g2=4
        //левоассоциативный!
        System.out.println(g10);
        System.out.println(g2);
        int g11=(g12+g2)*--g12;
        System.out.println(g11);
        double x;
        x=2.2-2.1;
        System.out.println(x);

//        Поразрядные операции
        int h1=4,h2=5;
        System.out.println(h1&h2); //логическое умножение
        System.out.println(h1|h2); //логическое сложение
        // шифрование, логическое исключающее ИЛИ
        int h3=28,h4=159,h5,h6;
        h5=h3^h4;
        System.out.println(h5);
        h6=h5^h4;
        System.out.println(h6);
        System.out.println(~h3); // логическое отрицание, меняет 1 на 0
        boolean h7=h1==h2;
        System.out.println(h7);
        boolean h8=h1==4; // проверка на соответствие
        boolean h9=h1!=4; // обратная операция
        System.out.println(h8);
        System.out.println(h9);
        boolean h10=(4<=4)|(5<3); // true если хоть одно true или оба
        System.out.println(h10);
        boolean h11=(4>5)&(5>6); // true если оба true
        System.out.println(h11);
        h4+=h3; // h4 = h4 + h3
        System.out.println(h4);

        // Преобразования базовых типов данных
        int h16=584;
        byte h12=(byte) h16; // меньше по занимаемом месту в памяти к большему, если наоборот то автоматически
        System.out.println(h12);
        int h13=h12,h15=546849453;
        System.out.println(h13);
        float h14=h15;
        System.out.println(h14);
    }
}








