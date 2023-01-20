package com.Core2;

public class StringM {
    public static void main(String[] args) {
        String a = "ggg";
        String b;

        b = a;
        a.toUpperCase();
        System.out.println(b);
        System.out.println(a);

        StringBuilder stringBuilder1 = new StringBuilder("1");
        StringBuilder stringBuilder2;
        stringBuilder2 = stringBuilder1;
        stringBuilder1.append("1");
        System.out.println(stringBuilder2);
    }
}
