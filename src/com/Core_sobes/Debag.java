package com.Core_sobes;

import java.util.Scanner;

public class Debag {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            Integer nums = num();
            if (nums >= 100) {
                System.out.println("Больше или равно 100");
            }
            else {
                System.out.println("Меньше 100");
            }
        }
    }

    private static Integer num() {
        var f = scanner.nextInt();
        var s = scanner.nextInt();
        return f * s;
    }
}
