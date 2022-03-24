package com.company;
import java.util.Scanner;

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

//        Scaner, ввод значений
        Scanner in = new Scanner(System.in); /*пишется один раз,
         in(перед равно) используется и в последющих операциях ввода,
         это имя вводимой переменной которую мы вводим с консоли*/
        /*System.out.print("Введите имя: ");
        String f1= in.nextLine(); // момент ввода с консоли, in это имя вводимой переменной
        System.out.print("Введите возраст: ");
        int f2= in.nextInt();
        System.out.print("Введите вес: ");
        float f3= in.nextFloat(); //вводить нужно через запятую, с точкой ошибка
        System.out.printf("Name=%s; Age=%d; Height=%.2f; \n", f1, f2, f3);*/
//        in.close();
        /*заканчивает ввод с консоли, ставить в самом конце, после всех операций ввода
         если поставить сейчас то вводить с консоли больше будет нельзя*/


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
        boolean h7=h1==h2; // == - равно, не присваивание
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
        byte h12=(byte) h16,h22=56; // меньше по занимаемом месту в памяти к большему, если наоборот то автоматически
        System.out.println(h12);
        int h13=h12,h15=546849453;
        System.out.println(h13);
        float h14=h15;
        System.out.println(h14);
        double h17=5.56497,h20=8.9856;
        int h18=(int)Math.round(h17),h19=4; // округление
        System.out.println(h18);
        double h21=h19+h20;
        System.out.println(h21);
        short h23=6895;
        byte h24=(byte) (h23+h22); // не хватило памяти в byte
        int h25=h22+h23;
        System.out.println(h24+" "+h25);
        char h26='v'; // char в int
        int h27=h26+h23;
        System.out.println(h27);

        // Условные конструкции
        int i1=7,i2=9;
        if (i1<i2 && i2>7) { // после совпадения, следующие не рассматривает
            System.out.println("i1 меньше чем i2 и i2 больше 7");
        }
        else if (i1<i2){
            System.out.println("i1 больше чем i2");
        }
        else if (i1==9){
            System.out.println("i1 равно 9");
        }
        else  {
            System.out.println("числа равны");
        }

        switch (i1) {
            case 7:
                System.out.println("число равно 7");
                // break; // прекращает выполнение следующих case, если выполнено
            case 8:
                System.out.println("число равно 8");
                //i1++;
            case 9:
                System.out.println("число равно 9");
                break;
            default:
                System.out.println("число не 2,3,4");
        } // если не будет break, то задачи будут выполняться без совпадений case, до break

        switch (i1) {
            case 7:
                i2=11;
            case 8:
                i2=12;
                break;
            default:
                i2=24;
        }
        System.out.println(i2);

        // теренарная операция, условие ? (true) : (false)
        int i3=4, i4=5;
        int i5=i3<i4? (i3+i4) : (i4-i3);
        System.out.println(i5);

        /*Напишите консольную программу, в которой пользователь с клавиатуры вводит два числа.
        А программа сранивает два введенных числа и выводит на консоль результат сравнения
        (два числа равны, первое число больше второго или первое число меньше второго).*/
        /*System.out.print("Введите i6: ");
        int i6= in.nextInt();
        System.out.print("Введите i7: ");
        int i7= in.nextInt();
        if (i6<i7) {
            System.out.println("i6 меньше чем i7");
        }
        else if (i6>i7) {
            System.out.println("i6 больше чем i7");
        }
        else {
            System.out.println("i6 равно i7");
        }*/

        /*Напишите консольную программу, в которой пользователь вводит с клавиатуры число.
        Если число одновременно меньше 9 и больше 2, то программа выводит "Число больше 5 и меньше 10".
        Иначе программа выводит сообщение "Неизвестное число".*/
        /*System.out.print("Введите число: ");
        int i8= in.nextInt();
        if (i8<9 && i8>2) {
            System.out.println("Число больше 2 и меньше 9");
        }
        else {
            System.out.println("Неизвестное число");
        }*/

        // вывод до первого пробела
        /*String i9= in.nextLine();
        System.out.println(i9);*/

        /*В банке в зависимости от суммы вклада начисляемый процент по вкладу может отличаться.
        Напишите консольную программу, в которую пользователь вводит сумму вклада.
        Если сумма вклада меньше 100, то начисляется 5%. Если сумма вклада от 100 до 200, то начисляется 7%.
        Если сумма вклада больше 200, то начисляется 10%. В конце программа должна выводить сумму вклада
        с начисленными процентами.*/
        /*System.out.print("Введите сумму вклада: ");
        float i10= in.nextFloat();
        if (i10>0) {
            if (i10<100) {
                i10*=1.05;
            }
            else if (i10<200) {
                i10*=1.07;
            }
            else {
                i10*=1.1;
            }
            System.out.printf("Ваш вкалад с процентами: %.2f \n", i10);
        }
        else {
            System.out.println("Неверная сумма вклада");
        }*/

        /*Напишите консольную программу, которая выводит пользователю сообщение
        "Введите номер операции: 1.Сложение 2.Вычитание 3.Умножение".
        Рядом с названием каждой операции указан ее номер, например, операция вычитания имеет номер 2.
        Пусть пользователь вводит в программе номер операции, и в зависимости от этого номера программа
        выводит название операции. Для определения операции по введенному номеру используйте конструкцию switch...case.
        Если введенное пользователем число не соответствует никакой операции (например, число 120),
        то выведите пользователю сообщение о том, что операция неопределена.*/
        /*System.out.println("Введите номер операции: 1.Сложение 2.Вычитание 3.Умножение");
        int i11= in.nextInt();
        switch (i11) {
            case 1:
                System.out.println("Сложение");
                break;
            case 2:
                System.out.println("Вычитание");
                break;
            case 3:
                System.out.println("Умножение");
                break;
            default:
                System.out.println("Операция неопределена");
        }*/

        /*Измените предыдущую программу. Пусть пользователь кроме номера операции вводит два числа,
        и в зависимости от номера операции с введенными числами выполняются определенные действия
        (например, при вводе числа 3 числа умножаются). Результат операции выводиться на консоль.*/
        /*System.out.print("Введите два числа: ");
        int i13= in.nextInt();
        int i14= in.nextInt();
        System.out.println("Введите номер операции: 1.Сложение 2.Вычитание 3.Умножение");
        int i12= in.nextInt();
        switch (i12) {
            case 1:
                System.out.println("Сложение: " + i13+i14);
                break;
            case 2:
                i13-=i14;
                System.out.println("Вычитание: " + i13);
                break;
            case 3:
                System.out.println("Умножение: " + i13*i14);
                break;
            default:
                System.out.println("Операция неопределена");
        }*/
        /*switch (i12) {
            case 1:
                i13+=i14;
                break;
            case 2:
                i13-=i14;
                break;
            case 3:
                i13*=i14;
                break;
            default:
                System.out.println("Операция неопределена");
        }
        if (i12>0 && i12<4) {
            System.out.printf("Вывод: %d", i13);
        }*/

    }
}








