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
    }
    static void hello() {
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
}
// Ооп
class Personal {
    String name; // поле класса
    int age; // поле класса

    Personal() {
        name = "Общий";
        age = 18;
    }

    Personal(int g) {
        name = "Общий";
        age = g;
    }

    Personal(String n, int g) {
        name = n;
        age = g;
    }

    void info() {
        System.out.printf("Имя: %s. Возраст: %d.\n", name, age);
    }
}

class Personal2 {
    String name; // поле класса
    int age; // поле класса

    {
        name = "Все";
        age = 22;
    }

    Personal2(String n, int g) {
        this.name=n; // параметр n присваивается полю name
        this.age=g;
    }

    Personal2() {
//        this("Все", 22);
    }

    Personal2(String n) {
        this(n, 30);
    }

    void info() {
        System.out.printf("Имя: %s. Возраст: %d.\n", name, age);
    }
}





