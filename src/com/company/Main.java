package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Hello Java!");
        int x=10,y=5,z,b; /*объявление и инициализация переменной,*/
        //     x=10;
        //     y=5;
        z=x+y;
        b=x*y;
        System.out.println(z);
        System.out.println(b);
        System.out.println(z+b);
        x=20;/*присваивать значения можно и позже */
        System.out.println(x*y);
        var f=8;/*нужно сразу инициализировать, тип определяется по присвоенномым значениям*/
        System.out.println(f);
        final int LIMON=58;/*константа, нельзя изменять в бдущем*/
        System.out.println(LIMON);
        long num=2147483648L;
        System.out.println(num);
        boolean t=true;
        System.out.println(t);
        float t1=5.8f;
        System.out.println(t1);
        byte k=2;
        System.out.println(k);
        char a1='r';/*100-буква d*/
        System.out.println(a1);
        String a2="Hello\n" +/*\n-новая строка*/
                "prublyda!";
        System.out.print(a2);
        System.out.println("Ny hello.");
        String a3= """
                Hello
                prubluda!
                """;
        System.out.print(a3);
        System.out.println("Ny hello2.");
        System.out.println("x=" + x + "; y=" + y);
        System.out.printf("y=%d; x=%d \n",y,x);
        String a4="Dima";
        System.out.printf("Name:%s, Age:%d, Height:%.3f",a4,b,t1);
    }
}



