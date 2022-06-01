package com.company;

import com.sun.jdi.Value;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Main9 {
    public static void main(String[] args) {
        // Дополнительные классы
        // Математические вычисления и класс Math
        System.out.println(Math.abs(-5)); // абсолютное значение(модуль)
        System.out.println(Math.pow(5, 2)); // 5 в квадрате
        System.out.println(Math.PI*Math.pow(5, 2)); // площадь круга с радиусом 5

        // Большие числа BigInteger и BigDecimal
        BigInteger a = BigInteger.valueOf(568975156);
        BigInteger b = BigInteger.valueOf(389329875);
        BigInteger c = a.multiply(b);
        System.out.println(c);
        long x = c.longValue();
        System.out.println(x);

        BigDecimal a1 = BigDecimal.valueOf(56851698412.518);
        BigDecimal a2 = BigDecimal.valueOf(38745216888.589);
        BigDecimal a3 = a1.multiply(a2);
        System.out.println(a3);
        System.out.println();

        // Работа с датами. LocalDate
        LocalDate b1 = LocalDate.now();
        System.out.println(b1);
        System.out.println(b1.getEra());
        System.out.println(b1.getYear());
        DayOfWeek b2 = b1.getDayOfWeek();
        System.out.println(b2); // день недели
        LocalDate b3 = LocalDate.of(1996, 9, 28);
        System.out.println(b3.getDayOfWeek());
    }
}











