package com.Algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class A1 {
    public static void main(String[] args) {
        /* Массив целых чисел, в котором каждое число встречается 2 раза,
        * и лишь одно число встречается 1 раз*/
        int[] mass = {9, 9, 2, 7, 7, 4, 4};

        System.out.println("O(n^2)");
        search(mass);
        System.out.println();

        System.out.println("Stream.sort");
        Integer[] mass2 = {6, 4, 5, 4, 3, 5, 3};
        Object[] objects = Arrays.stream(mass2).sorted().toArray();
        for (Object object : objects) {
            System.out.print(object);
        }
        System.out.println();
        for (int i = 0; i < objects.length; i += 2) {
            if (i == objects.length - 1 || !Objects.equals(objects[i], objects[i + 1])) {
                System.out.println(objects[i]);
                break;
            }
        }

        System.out.println();
        System.out.println();

        System.out.println("O(n)");
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mass.length; i++) {
            int g = 1;
            if (map.containsKey(mass[i])) {
                g++;
            }
            map.put(mass[i], g);
        }
        for (Integer g :
                map.keySet()) {
            Integer integer = map.get(g);
            if (integer == 1) {
                System.out.println(g);
            }
        }
        System.out.println();

        /* O(n)*/
        System.out.println("O(n) - короче");
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < mass.length; i++) {
            if (map2.containsKey(mass[i])) {
                map2.remove(mass[i]);
            }
            else {
                map2.put(mass[i], null);
            }
        }
        System.out.println(map2.keySet());
        System.out.println();

        System.out.println("XOR");
        int f = 0;
        int[] mass5 = {9, 9, 2, 7, 7, 4, 4};
        for (int g : mass5) {
            f ^=g;
        }
        System.out.println(f);
        System.out.println();

        System.out.println("Пузырьковая сорт");
        int[] mass3 = {2, 1, 8, 5, 0, 6, 4, 2, 4, 1};
        for (int i = 0; i < mass3.length; i++) {
            for (int j = i + 1; j < mass3.length; j++) {
                if (mass3[j] <= mass3[i]) {
                    int d = mass3[i];
                    mass3[i] = mass3[j];
                    mass3[j] = d;
                }
            }
        }
        for (int i : mass3) {
            System.out.print(i);
        }
        System.out.println();
        System.out.println();

        int[] mass4 = {2, 1, 8, 5, 0, 6, 4, 2, 4, 1};
        System.out.println("Быстрая сорт, n log n");
        quickSort(mass4, 0, mass4.length - 1);
        for (int i : mass4) {
            System.out.print(i);
        }
        System.out.println();
        System.out.println();


    }
    public static void search(int[] mass) {
        for (int j : mass) {
            int index = 0;
            for (int k : mass) {
                if (j == k) {
                    index++;
                }
            }
            if (index == 1) {
                System.out.println(j);
            }
        }
    }
    public static void quickSort(int[] sortArr, int low, int high) {
        //завершить,если массив пуст или уже нечего делить
        if (sortArr.length == 0 || low >= high) return;

        //выбираем опорный элемент
        int middle = low + (high - low) / 2;
        int border = sortArr[middle];

        //разделияем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            while (sortArr[i] < border) i++;
            while (sortArr[j] > border) j--;
            if (i <= j) {
                int swap = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = swap;
                i++;
                j--;
            }
        }

        //рекурсия для сортировки левой и правой части
        if (low < j) quickSort(sortArr, low, j);
        if (high > i) quickSort(sortArr, i, high);
    }
}
