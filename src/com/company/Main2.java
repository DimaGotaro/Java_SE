package com.company;
import java.util.Scanner;
//import java.util.*; // импорт всех классов из пакета java.util
import com.company3.Persona2; // импортирован из другого пакета

public class Main2 {
    public static void main(String[] args) {
//        java.util.Scanner in = new java.util.Scanner(System.in); // полный адрес сканера
//        Scanner in = new Scanner(System.in);
//        java.util.Date utilDate = new java.util.Date();
//        java.sql.Date sqlDate = new java.sql.Date();
        /* два класса Date имеются в двух разных пакетах java.util. и java.sql., что бы их использовать нужно
        указывать полный путь к этим классам, по примеру сканера*/

        // Начало
        System.out.println("Hello world!");
        /* System - класс, out - статическая переменная, println - метод*/
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
         in(перед равно) используется и в последующих операциях ввода,
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
        А программа сравнивает два введенных числа и выводит на консоль результат сравнения
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
        Если число одновременно меньше 9 и больше 2, то программа выводит "Число больше 2 и меньше 9".
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

        // Циклы
        for (float i=1.7f; i<8; i+=2) { /*первый цикл - [инициализация счетчика];, [условие];, {действие},
        [изменение счетчика];, далее следующий цикл начинается с [условие];*/
//            System.out.printf("Квадрат числа %d равен: %d \n", i, i*i); // если int i=1;
            System.out.printf("Квадрат числа %.1f равен: %.2f \n", i, i*i);
        }

        int j1=10;
        for (int i=0, j=j1-1; i<j; i++,j--) {
            System.out.println("Результат: " +i+" "+j);
        }

        do {  /*первый цикл - [инициализация объекта];, {действие}, [условие];, далее следующий цикл
             Один раз точно исполнится*/
            System.out.println(j1);
            j1-=2;
        }
        while (j1>0);

        int j2=11;
        while (j2>=5) {
            System.out.println("Квадрат: "+j2*j2+" из числа"+j2);
            j2-=2;
        }

        for (int i=0; i<10;i++) {
            if (i==5)
                break; // прекращает выполнение при условии
            System.out.println(i);
        }

        for (int i=0; i<5;i++) {
            if (i==3)
                continue; // пропускает выполнение при условии
            System.out.println(i);
        }

        /*System.out.println("Вопрос 3"); // интересный момент с поразрядными опер-ми, -2147483648*2=0
        int j=2;
        for (int i=2; i<32; i=i*2) {
            System.out.println("j "+j+" i "+i);
            while (i<j) {
                j*=2;
                System.out.println("j "+j);
            }
            System.out.println("j "+j+" i "+i);
            i=j-i;
            System.out.println("j "+j+" i "+i);*/

        for (int i=1,j3=2;i<3 && j3>0;i++,j3--) {
            System.out.printf("Число: %d, %d \n", i++,j3--);
        }

        /*В стране XYZ население равно 10 миллионов человек. Рождаемость составляет 14 человек на 1000 человек,
        смертность - 8 человек. Рассчитайте, какая численность населения будет через 10 лет,
        принимая во внимание, что показатели рождаемости и смертности постоянны.*/
        double j7=10000000,j6,j8=6;
        for (int i=1;i<=10;i++) {
            j6=0;
            for (int j=1000; j<=j7; j+=1000) {
                j6+=j8;
            }
            j7+=j6;
        }
        System.out.printf("Численность населения через 10 лет: %.0f \n", j7);
        // Код слишком громоздкий, так делать не нужно

        double j5=14,j9=8,j10=10000000,j11=1000;
        for (int i=1;i<=10;i++) {
            j10+=(j5-j9)*j10/j11;
        }
        System.out.printf("Численность населения через 10 лет: %.0f \n", j10);

        /*В стране XYZ население равно 10 миллионов человек. Рождаемость составляет 14 человек на 1000 человек,
        смертность - 8 человек. Каждый год рождается и умирает на 1 человек, меньше чем в предыдущий год.
        Рассчитайте, какая численность населения будет через 10 лет, учитывая,
        что рождаемость не может быть меньше 7 человек на 1000 человек,
        а смертность не может быть меньше 6 человек на 1000 человек.*/
        double j12=14,j13=8,j14=10000000,j15=1000;
        for (int i=1;i<=10;i++) {
            j14+=(j12-j13)*j14/j15;
            if (j12>7) {
                j12--;
            }
            if (j13>6) {
                j13--;
            }
        }
        System.out.printf("Численность населения через 10 лет: %.0f \n", j14);

        /*За каждый месяц банк начисляет к сумме вклада 7% от суммы.
        Напишите консольную программу, в которую пользователь вводит сумму вклада и количество месяцев.
        А банк вычисляет конечную сумму вклада с учетом начисления процентов за каждый месяц.
        Для вычисления суммы с учетом процентов используйте цикл for.
        Пусть сумма вклада будет представлять тип float.*/
        /*System.out.print("Введите сумму вклада: ");
        float j16=in.nextFloat();
        System.out.print("Введите кол-во месяцев: ");
        int j17=in.nextInt(), j18=7;
        for (int i=1; i<=j17;i++) {
            j16+=j16*j18/100;
        }
        System.out.printf("После %d месяцев сумма вклада составит: %.2f \n", j17, j16);*/

        /*Перепишите предыдущую программу, только вместо цикла for используйте цикл while.*/
        /*System.out.print("Введите сумму вклада: ");
        float j16=in.nextFloat();
        System.out.print("Введите кол-во месяцев: ");
        int j17=in.nextInt(), j18=7, j19=1;
        while (j19<=j17) {
            j19++;
            j16+=j16*j18/100;
        }
        System.out.printf("После %d месяцев сумма вклада составит: %.2f \n", j17, j16);*/

        /*Напишите программу, которая выводит на консоль таблицу умножения*/
        for (int j=1; j<10; j++) {
            for (int i = 1; i < 10; i++) {
                System.out.print("\t"+i*j);
            }
            System.out.println();
        }
        // правильное решение, остальное разные способы
        System.out.println();

        int j20=1,j21=1;
        for (int j=1;j<10;j++) {
            for (int i=1; i < 10; i++) {
                System.out.print("\t" + j20);
                j20+=j21;
            }
            System.out.println();
            j21++;
            j20=j21;
        }
        System.out.println();

        int j22=1,j23=1;
        for (int j=1; j<10; j++) {
            for (int i = 1; i < 10; i++) {
                System.out.print("\t" + j22*j23);
                j23++;
            }
            System.out.println();
            j22++;
            j23=1;
        }
        System.out.println();

        int j24=1,j25=0,j26=1;
        for (int j=1; j<10; j++) {
            for (int i = 1; i < 10; i++) {
                System.out.print((j24+j25)+"\t");
                j25+=j26;
            }
            System.out.println();
            j26++;
            j24++;
            j25=0;
        }
        System.out.println();

        /*В цикле программа просит у пользователя ввести два числа и выводит результат их умножения.
        После вывода результата умножения программа спрашивает, надо ли завершить выполнение.
        И если пользователь введет число 1, то программа завершает цикл. Если введено любое другое число,
        то программа продолжает спрашивать у пользователя два числа и умножать их.*/
        /*boolean j31=true;
        do {
            System.out.print("Введите два числа: ");
            int j27 = in.nextInt();
            int j28 = in.nextInt(), j29;
            j29 = j27 * j28;
            System.out.printf("Результат: %d \n", j29);
            System.out.print("Нужно ли завершить выполнение: ");
            int j30 = in.nextInt();
            switch (j30) {
                case 1:
                    j31=false;
                    break;
                default:
                    j31=true;
            }
        }
        while (j31==true);*/

        /*int j31;
        do {
            System.out.print("Введите два числа: ");
            int j27 = in.nextInt();
            int j28 = in.nextInt(), j29;
            j29 = j27 * j28;
            System.out.printf("Результат: %d \n", j29);
            System.out.print("Нужно ли завершить выполнение:(1-выход, любое-продолжить) ");
            j31 = in.nextInt();
        }
        while (j31!=1);*/

        /*В банк внесён депозит в 100$ под 5% годовых, каждый месяц депозит пополняется на сумму первоначального
         вклада. Рассчитать сумму через 20 лет.*/
        double j32=5, j33=100, j34=240, j35=1, j36=0;
        do {
            j36+=j33;
            j36+=j36*j32/100/12;
            j35++;
        }
        while (j35<=j34);
        System.out.printf("%.2f \n", j36);

        // Массивы
        int mass[];
//        int[] mass2; // объявление
        mass = new int[5];
        int[] mass2 = new int[4]; // объявление и инициализация
        mass2[0]=95;
        mass2[1]=65; // задали второй элемент массива
        mass2[2]=18;
        mass2[3]=36;
        System.out.println(mass2[1]); // вывод третьего элемента массива
        int[] mass3 = new int[] {1,5,7,8,9}; // при таком способе скобки должны быть пустыми!
        System.out.println(mass3[3]);
        int[] mass4 = {2,3,4,9};

        int length = mass4.length; // количество элементов массива
        System.out.println(length);
        int last = mass4[mass4.length-1]; // вывод последнего элемента "4-1" mass4[3]
        System.out.println(last);

        int[][] mass5 = {{1,3},{6,7,9}}; // двумерный массив
        System.out.println(mass5[1][2]); // в первых скобках номер строки, во вторых порядковый номер элемента
        int[][] mass6 = new int[2][3]; // кол-во строк и столбцов
        mass6[1][0] = 87;
        System.out.println(mass6[1][0]);

        int[][][] mass7 = new int[3][2][3]; /*трёхмерный, параллелограмм, длина 3, ширина 2, высота 3,
        0,0,0 в одной вершине, а 2,1,2 в противоположной через диагональ, 18 элементов*/
        System.out.println(mass7[0][0][1]); // x,y,z
        System.out.println(mass7[0][0].length);
        System.out.println();
        int k1 = 0;
        for (int i=0; i< mass7[0][0].length; i++) { // перебор элементов трёхмерного массива
            for (int j=0; j< mass7[0].length; j++) {
                for (int k=0; k< mass7.length; k++) {
                    mass7[k][j][i]+=k1;
                    System.out.print(mass7[k][j][i]+"\t");
                    k1++;
                }
                System.out.println();
            }
            System.out.println();
        }

        int[][] mass8 = new int[2][]; // зубчатый массив, в двумерном массиве строки это - одномерные массивы
        mass8[0] = new int[2]; // в первых скобках номер строки, во вторых скобках кол-во элементов
        mass8[1] = new int[3];
        System.out.println(mass8[1][2]);
        System.out.println();

        for (int i : mass4) { // перебор элементов в наборах элементов, например, в массивах
            System.out.println(i);
        }
        System.out.println();
        for (int i = 0; i < mass4.length; i++) { // то же самое, но подробнее
            System.out.println(mass4[i]);
        }
        System.out.println();
        int[][] mass9 = {
                {2,5,9,7},
                {5,8},
                {3,7,9}
        };
//        System.out.println(mass9[0].length);
        // перебор многомерных массивом
        for (int i=0; i< mass9.length; i++) {
            for (int j=0; j < mass9[i].length; j++) {
                System.out.print(mass9[i][j]+"\t");
            }
            System.out.println();
        }
        // Методы
        hello();
        welcome();
        sum(8,3);
        int k4=8, k5=2;
        sum(k4,k5);
        sum(10,k5);
        disp("Dimonchik", 25);
        sum_all("Сумма чисел: 6,9,7,4,1,5,8 = ",6,9,7,4,1,5,8);
        int k10=sum2(5,9,6);
        System.out.println(k10);
        System.out.println(sum2(5,8,9));
        System.out.println(day(9));
        System.out.println(day(15));
        dayt(56);
        System.out.println(sum3(2,3,5,1));
        System.out.println(sum4(2,3,5,2));
        System.out.printf("%.1f \n", sum3(1.2,5.3,2.8,1.4));
        System.out.println(fact(6));
        System.out.println(fact2(7));
        System.out.println(fib(5));

        // Обработка исключений
        try {
            int[] mass11 = new int[3];
//            mass11[3]=45; // Ошибка. Выход за рамки массива!
            mass11[2]=Integer.parseInt("kfg"); // Ошибка преобразования из строки в число!
            System.out.println(mass11[3]);
        }
        // тип Exception универсальный, для большинства исключений, в конце будет ошибка, ниже конкретные исключения
        // они ошибку не вызывают.
        // Если сработало исключение, то управление переходит к блоку catch, ниже!
//        catch (Exception ex) {
//            ex.printStackTrace();
//        }
        catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Выход за рамки массива!");
        }
        catch (NumberFormatException ex) {
            System.out.println("Ошибка преобразования из строки в число!");
        }
        finally {
            System.out.println("Блок Finally.");
        }
        System.out.println("Программа завершена!"); // следующее условие, выполнено
        System.out.println();

        // throw
        /*try {
            int k13 = in.nextInt();
            if (k13>=30) {
                throw new Exception(*//*"Число должно быть меньше 30"*//*); *//* Если сработало исключение,
                то управление переходит к блоку catch, ниже*//*
            }
        }
        catch (Exception ex){
            System.out.println("Число должно быть меньше 30"*//*ex.getMessage()*//*);
        }
        System.out.println("Программа завершена!");*/

        // Ооп
        /*В одном файле может быть только один класс public. Класс это новый тип объекта, параметры этого типа
        мы задали при написании класса, внизу, после класса Main2. Dima это переменная, ниже мы указываем на объект*/
        Personal Dima = new Personal(); // создание объекта класса Personal(объект имеет тип Personal), без параметров
        Dima.info();
        Dima.name="Dimonchik";
        Dima.age=25;
        Dima.info();
        System.out.println();

        Personal Dima2 = new Personal("Димоньчик", 255); // вызов конструктора с параметрами
        Dima2.info();

        Personal Sanya = new Personal("Санёчек", 26);
        Sanya.info();

        Personal All = new Personal(20);
        All.info();

        Personal All2 = new Personal();
        All2.info();
        System.out.println();

        Personal2 tom = new Personal2();
        tom.info();

        Personal2 bob = new Personal2("Bob");
        bob.info();

        Personal2 cris = new Personal2("Cris", 27);
        cris.info();
        System.out.println();

        Persona2 jack = new Persona2("Jack", 28); // класс импортирован из пакета com.company3
        jack.inf();
        System.out.println();

        Person polin = new Person();
        polin.info();

        Person polina = new Person("Polina", 26, "Rechica", "+375559845327");
        polina.info();
        polina.info_name();
        polina.info_age();
        polina.info_adress();
        polina.info_phone();

        // Инкапсуляция - ограничение доступа к данным, с помощью модификаторов. Сокрытие данных внутри области.
        Pers2 sato = new Pers2("Sato", 111);
        sato.info();
//        sato.age=20; // нельзя задать значение, потому что поле с модификатором private

        Pers gats = new Pers("Gats",110);
        System.out.println(gats.getAge()); // геттер для вывода значений
        gats.setAge(30); // сеттер для ввода значений
        System.out.println(gats.getAge());
        gats.setName("Gatss");
        System.out.println(gats.getName());
        Pers gats2 = new Pers(); // Новый конструктор, новый объект
        gats2.info();
        System.out.println();

        // static поля, можем вызывать без объекта класса, через сам класс
        System.out.println(Count.con);
        Count cv = new Count();
        cv.info();
        Count cv2 = new Count();
        cv2.info();
        Count.con = 5; // изменяем статическое поле, во всём классе Count
        // статическая переменная - общая переменная для всех классов
        Count cv3 = new Count();
        cv3.info();
        Count cv4 = new Count();
        cv4.info();
        System.out.println("con = "+Count.con);
        System.out.println();
        /* System - класс, out - статическая переменная, println - метод*/

        // static константа
        double radius = 30;
        System.out.println(radius*Count.pi);
//        Count.pi+=1; // не можем изменить - константа(final)
        System.out.println();

        // static инициализатор
        Count2 cb = new Count2();
        cb.info();
        Count2 cb2 = new Count2();
        cb2.info();
        Count2.con = 105;
        Count2 cb3 = new Count2();
        cb3.info();
        System.out.println();

        // static метод, то же через класс, без объекта. Только статические переменные
        Count3.info_con();
        Count3 ch = new Count3();
        ch.info_id();
        Count3.info_con();
        Count3 ch2 = new Count3();
        ch2.info_id();
        Count3.info_con();
        System.out.println();

        // статические методы могут быть вызваны без создания объекта
        System.out.println(Count4.sum(5,7));
        System.out.println(Count4.sum_v(5,7));
        System.out.println(Count4.umn(5,7));
        System.out.println();

        // Объекты как параметры методов
        Param nat = new Param("Натали");
        System.out.println(nat.getName());
        changeName(nat);
        System.out.println(nat.getName());
        // переменная kate и параметр p метода changeName будут указывать на один и тот же объект в памяти,
        // новый объект не создавался!
        // то же, через объект
//        nat.setName("Натали.через объект");
//        System.out.println(nat.getName());
        changeH(nat);
        System.out.println(nat.getName()); // nat.name не изменён, потому что h теперь не параметр, а объект
        System.out.println();

        // Внутренние и вложенные классы
        Intro nm = new Intro("Bob", "1234");
        nm.info_Intro();
        nm.account.info_Passw();
        Intro2 nm3 = new Intro2("Сюзанна");
        nm3.info_1("4321");
        // пример с факториалом
        Intro3.Fact nm4 = Intro3.getFact(6); // объект создаётся в методе Intro3.getFact()
        // здесь Intro3.getFact() это - new Fact(c, d), которы в сою очередь является - new Fact(int y, int x)
        System.out.printf("Факториал числа %d, равен: %d\n", nm4.getB(), nm4.getA());
        System.out.println();

        // Наследование
        Nacl ff = new Nacl("Накл"); // Объект родительского класса
        ff.info(); // метод родительского класса, ниже будет переопределён
        Emporio ff2 = new Emporio("Ива-сан"); // объект наследуемого класса
        ff2.info(); // метод из родительского класса
        Emporio ff3 = new Emporio("Зурема", "Кича");
        ff3.info_all();
        System.out.println();
        ff3.info(); // переопределённый метод в наследуемом классе, с добавлением изначального метода
        // Динамическая диспетчеризация методов, объект Emporio является в то же время и объектом Nacl
    }
    public static void hello() {
        System.out.println("Hello!");
    }
    static void welcome() {
        System.out.println("Welcome to Java!");
    }
    static void sum(int k2, int k3) {
        int k4=k2+k3;
        System.out.println(k4);
    }
    static void disp(String name, int k6) {
        System.out.println(name+" "+k6);
    }
    static void sum_all(String name, int ...mass10) { // сумма элементов массива, int ...mass10 должна стоять последней!
        int mas=0;
        for (int i:
             mass10) {
            mas+=i;
        }
        System.out.println(name+mas);
    }
    static int sum2(int k7,int k8, int k9) { // возвращает в sum2 сумму, в void - не возвращает!
        return k7+k8+k9;
    }
    static String day(int k11) {
        if (k11>=0 && k11<=6) {
            return "Сейчас ночь.";
        }
        else if (k11>=7 && k11<=12) {
            return "Сейчас утро!";
        }
        else if (k11>=13 && k11<=18) {
            return "Сейчас день.";
        }
        else if (k11>=19 && k11<=24) {
            return "Сейчас вечер.";
        }
        else {
            return "Введите число от 0 по 24";
        }
    }
    static void dayt(int k11) {
        if (k11>=0 && k11<=6) {
            System.out.println("Сейчас ночь.");
        }
        else if (k11>=7 && k11<=12) {
            System.out.println("Сейчас утро!");
        }
        else if (k11>=13 && k11<=18) {
            System.out.println("Сейчас день.");
        }
        else if (k11>=19 && k11<=24) {
            System.out.println("Сейчас вечер.");
        }
        else {
            return; // выход из метода void dayt
        }
    }
    // Перегрузка методов
    static int sum3(int ...sum3m) {
        int sum3s=0;
        for (int i:
             sum3m) {
            sum3s+=i;
        }
        return sum3s;
    }
    static double sum3(double ...sum3m) {
        double sum3s=0;
        for (double i:
                sum3m) {
            sum3s+=i;
        }
        return sum3s;
    }
    static int sum4(int ...sum3m) { // другой способ суммы элементов массива, больше возможностей
        for (int i =1; i<sum3m.length; i++) {
            sum3m[0]+=sum3m[i];
        }
        return sum3m[0];
    }
    /*Рекурсивная функция. Всегда нужен базовый вариант, то есть первый в рекурсии,
    мы постоянно будем к нему возвращаться*/
    // Факториал
    static int fact(int k12) {
        if (k12 == 1) { // первый вариант
            return 1;
        }
        return k12*fact(k12-1);
    }
    static int fact2(int k12) {
        int k13=1;
        for (int i=1; i<=k12; i++) {
            k13*=i;
        }
        return k13;
    }
    // Число Фибоначчи
    static int fib(int m) {
        if (m == 0) {
            return 0;
        }
        if (m == 1) {
            return 1;
        }
        else {
            return fib(m-1)+fib(m-2);
        }
    }
    static void changeName(Param h) { // h - это параметр, не объект. В памяти то же место, что и у kate
        h.setName("Натали.h");
    }
    static void changeH(Param h) {
        h = new Param(" 2Наташа"); // h - создан объект класса Param
        System.out.println(h.getName());
        h.setName(" 2Наташа.h"); // изменено поле name в объекте h
        System.out.println(h.getName());
    }
}
// Ооп
class Personal {
    String name; // поле класса, определяет состояние класса
    int age; // поле класса, хранит данные

    Personal() { // конструктор
        name = "Общий";
        age = 18;
    }

    Personal(int g) { // конструктор
        name = "Общий";
        age = g;
    }

    Personal(String n, int g) { // конструктор
        name = n;
        age = g;
    }

    void info() { // метод, определяет поведение класса
        System.out.printf("Имя: %s. Возраст: %d.\n", name, age);
    }
}

class Personal2 {
    String name; // поле класса
    int age; // поле класса

    { // инициализатор, выполняется один раз до создания объекта
        name = "Все";
        age = 22;
        System.out.println("Инициализация");
    }

    Personal2(String n, int g) {
        this.name=n; // параметр n присваивается полю name
        age=g; // можно и без this
    }

    Personal2() {
//        this("jgdgn", 65); // обращаемся к Personal2(String n, int g)
    }

    Personal2(String n) {
        name=n;
//        this.name=n;
//        this("jgnk", 52);
    }

    void info() {
        System.out.printf("Имя: %s. Возраст: %d.\n", name, age);
    }
}
class Person {
    String name;
    public int age; // доступен в дргих пакетах
    protected String adress;
    /*private*/ String phone; // private - доступен только в классе где был создан

    Person (String n, int a, String dr, String p) {
        name=n;
        age=a;
        adress=dr;
        phone=p;
    }

    Person () {
//        this("sfn", 56, "jfn", "fkmg");
    }

    void info() {
        System.out.printf("Имя: %s. Возраст: %d. Адрес: %s. Номер телефона: %s.\n", name, age, adress, phone);
    }

    void info_name() {
        System.out.printf("Имя: %s.\n", name);
    }

    public void info_age() { // доступен в дргих пакетах
        System.out.printf("Возраст: %d.\n", age);
    }

    protected void info_adress() {
        System.out.printf("Адрес: %s.\n", adress);
    }

    /*private*/ void info_phone() { // private - доступен только в классе где был создан
        System.out.printf("Номер телефона: %s.\n", phone);
    }
}
// Инкапсуляция
/* Использование сеттеров и геттеров для изменения или вывода значений полей с модификатором private.
Для ограничения доступа к полю из других классов.*/
class Pers {
    private String name;
    private int age = 1;

    public void setName(String m) {
        this.name = m;
    }

    public void setAge(int e) {
        if (e >0 && e <110) {
            this.age = e;
        }
    }

    public String getName() {
        String sb = name; // интересный трюк для полной неизменяемости геттера. Если геттер(sb) изменить,
        // ему всё равно присвоится значение поля(name)
        return sb;
    }

    public int getAge() {
        return age;
    }

    Pers(String n, int g) {
        setName(n);
        setAge(g);
    }

    Pers () {    }

    void info() {
        System.out.printf("%s %d\n", name, age);
    }
}
// то же без инкапсуляции
class Pers2 {
    private String name;
    private int age;

    public Pers2(String n, int g) {
        name=n;
        if (g > 0 && g < 110){
            age = g;
        }
    }

    public void info() {
        System.out.println(name+" "+age);
    }
}
class Count {
    private int id;
    static int con = 1; // статическая переменная, можем использовать без объекта класса,
    // обращаясь к классу, а не к объекту
    public static final double pi = 3.14; // final - константа, не можем изменить

    Count () {
        id = con++;
    }

    public void info() {
        System.out.println("id = "+id);
    }
}

class Count2 {
    private int id;
    static int con;

    static { // выполняется один раз до создания объекта. Для статических полей(static)
        con = 102;
        System.out.println("Инициализация");
    }

    Count2 () {
        id = con++;
        System.out.println("Конструктор");
    }

    public void info() {
        System.out.println("id = "+id);
    }
}
class Count3 {
    private int id;
    private static int con = 1;

    Count3() {
        id = con++;
        System.out.println("Конструктор");
    }

    public static void info_con() {
        System.out.println("con = "+con);
    }

    public void info_id() {
        System.out.println("id = "+id);
    }
}
class Count4 {
    static int sum(int a, int b) {
        return a+b;
    }

    static int sum_v(int a, int b) {
        return a-b;
    }

    static int umn(int a, int b) {
        return a*b;
    }
}
class Param {
    private String name;

    Param (String name) {
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
class Intro { /* обращение к переменной внутреннего класса через объект этого класса,
 обращение переменных между внутренним и внешним классами.
  Внутренний класс(Passw) ведет себя как обычный класс за тем исключением,
  что его объекты могут быть созданы только внутри внешнего класса(Intro).*/
    private String name; // достп к полям между внутр и внешн классами разрешён, да же с private
    Passw account;

    Intro (String name, String pass) {
        this.name=name;
        account = new Passw(pass); // можно создать только в первом внешнем классе
    }

    void info_Intro() {
        System.out.printf("Intro name: %s. Password: %s\n", name, account.password/* обращение к перем внутр класса*/);
    }

    public class Passw {
        private String password;

        Passw (String pass2) {
            this.password = pass2;
        }

        void info_Passw() {
            System.out.printf("Passw name: %s. Password: %s\n", Intro.this.name/*обр к перем внешн класса*/, password);
        }
    }
}
class Intro2 {
    private String name;

    Intro2 (String name) {
        this.name=name;
    }

    public void info_1(String password) {
        class Passw2 {
            void info_2() {
                System.out.printf("Passw2 name: %s. Password: %s\n", Intro2.this.name, password);
            }
        }
        Passw2 nm2 = new Passw2();
        nm2.info_2();
    }
}
class Intro3 {
    public static class Fact {
        private int a;
        private int b;

        Fact(int y, int x) {
            a = y;
            b = x;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }
    public static Fact getFact(int d) { // тип Fact для того чтобы, вернуть значения c и x в объект класса Fact(nm4)
        // и его конструктор. Объекты и методы класса по сути это его конструкторы
        int c = 1;
        for (int i=1; i<=d; i++) {
            c *= i;
        }
        return new Fact(c, d); // создание и возвращение в объект класса Fact(nm4) соответствующему конструктору
    }
}
// Наследование. Наследуемые классы не имеют доступа к полям private
/*final*/ class Nacl { // final запрещает наследование классов, при создании Emporio была бы ошибка
    private String name;

    public String getName() {
        return name;
    }

    public Nacl(String name) {
        this.name = name;
    }

    public /*final*/ void info() { // final запрещает наследование методов
        System.out.printf("Имя: %s\n", name);
    }
}
class Emporio extends Nacl { // Emporio(наследник) наследует Nacl(родитель), наследует все те же поля и методы,
    // а конструкторы нужно вызывать
    private String comp;

    Emporio(String name) {
        super(name); // обращение к переменной из родительского класса
    }

    Emporio(String name, String comp) { // если базовый класс определяет конструктор,
        // то производный класс должен его вызвать
        super(name);
        this.comp = comp;
    }

    public void info_all() {
        System.out.printf("Имя: %s, Компания: %s\n", getName(), comp);
    }

    // переопределение метода
    @Override
    public void info() {
        super.info(); // добавили метод из базового класса с помощью super
        System.out.printf("Компания: %s\n", comp);
    }
}



