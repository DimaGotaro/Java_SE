package com.Core_sobes;

import java.lang.reflect.Field;

public class Str {
    public static void main(String[] args) {
        String a = "1234";

        try {
            Field value = a.getClass().getDeclaredField("value");
            value.setAccessible(true);
            Byte[] g = (Byte[]) value.get(a);
            g[0] = 2;
            for (byte f :
                    g) {
                System.out.print(f);
            }
            System.out.println();
            System.out.println(a);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
