package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main8 {
    public static void main(String[] args) {
        // Stream API
        //Введение в Stream API
        // кол-во чисел из массива которые больше 0
        long a1 = IntStream.of(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5).filter(w -> w > 0).count();
        // count - возвращает кол-во элементов в потоке
        System.out.println(a1);
        System.out.println();

        // Создание потока данных
        ArrayList<String> a2 = new ArrayList<String>();
        Collections.addAll(a2, "Biba", "Boba", "Ubershtormfurer", "Yahve");
        a2.stream() // получаем поток
                .filter(w -> w.length() > 4) // новый список, отсортированный
                .forEach(w -> System.out.println(w)); // перечисляем список
        System.out.println();

        ArrayList<String> a3 = new ArrayList<String>();
        Collections.addAll(a3, "Sanji", "Bryk", "Chopper", "Robin");
        Stream<String> a4 = a3.stream(); // получаем поток
        a4 = a4.filter(s -> s.length()==5); // поток изменён
        a4.forEach(s -> System.out.println(s)); // после терминальных операций к потоку не могут быть применены
        System.out.println();
        // не терминальные не промежуточные операции, поток уже употреблён
//        System.out.println(a4.count()); // ошибка!
        // цикл потока:
        // Создание потока
        //Применение к потоку ряда промежуточных операций
        //Применение к потоку терминальной операции и получение результата
        Stream<String> a5 = Arrays.stream(new String[]{"Batman", "Bane", "Joker"}); // создание потока
        a5.forEach(r -> System.out.println(r));
        System.out.println();
        Stream<Integer> a6 = Arrays.stream(new Integer[]{ 1, 5, 8, 6});
        a6.forEach(r -> System.out.print(r + "\t"));
        System.out.println();
        IntStream a7 = IntStream.of(6, 8, 9, 7); // создание потока
        a7.forEach(r -> System.out.print(r + "\t"));
        System.out.println();
        Stream<String> a8 = Stream.of("Lido", "Paper", "Granj");
        a8.forEach(r -> System.out.println(r));

        // Фильтрация, перебор элементов и отображение
        // Перебор элементов. Метод forEach
        Stream<Integer> a9 = Arrays.stream(new Integer[]{6, 9, 5, 4});
        a9.forEach(System.out::print);
        System.out.println();
        System.out.println();

        // Фильтрация. Метод filter
        Stream<String> a10 = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель");
        a10.filter(w -> w.length() < 8).forEach(w -> System.out.println(w));
        System.out.println();

        Stream<Phone> a11 = Stream.of(new Phone("Motorolla", 500), new Phone("Samsung", 1000),
                new Phone("Poco", 300));
        a11
                .filter(w -> w.getPrice() > 300)
                .forEach(w -> System.out.println(w.getName())); // больше 300
        System.out.println();

        // Отображение. Метод map
        Stream<Phone> a12 = Stream.of(new Phone("Motorolla", 500), new Phone("Samsung", 1000),
                new Phone("Poco", 300));
        a12
                .map(p -> "Name: " + p.getName() + ", Price: " + p.getPrice())
                .forEach(p -> System.out.println(p));

        Stream<Phone> a13 = Stream.of(new Phone("Motorolla", 500), new Phone("Samsung", 1000),
                new Phone("Poco", 300));
        a13
                .mapToInt(p -> p.getPrice())
                .forEach(p -> System.out.println(p));
        System.out.println();

        // Плоское отображение. Метод flatMap
        Stream<Phone> a14 = Stream.of(new Phone("Motorolla", 500), new Phone("Samsung", 1000),
                new Phone("Poco", 300));
        a14
                .flatMap(p -> Stream.of(
                        String.format("Name: %s, price: %d", p.getName(), p.getPrice()),
                        String.format("Name: %s, price -10: %d", p.getName(), p.getPrice() - (int)(p.getPrice()*0.1))
                ))
                .forEach(p -> System.out.println(p));
        System.out.println();

        // Сортировка
        ArrayList<String> b1 = new ArrayList<>();
        Collections.addAll(b1, "Париж", "Лондон", "Мадрид","Берлин", "Брюссель", "Sanji",
                "Bryk", "Chopper", "Robin");
        b1.stream()
                .filter(p -> p.length() < 6)
                .sorted() // сортировка по возрастанию
                .forEach(p -> System.out.println(p));
        System.out.println();

        Stream<Phone2> b2 = Stream.of(new Phone2("Motorolla", 500, "Moto"),
                new Phone2("Samsung", 1000, "Sam"),
                new Phone2("Poco", 300, "Xiomi"));
        b2.sorted(new Phone2Comp())
                .forEach(p -> System.out.printf("%s: (%s) - %d\n", p.getName(), p.getComp(), p.getPrice()));
        System.out.println();

        // Получение подпотока и объединение потоков
    }
}
class Phone {
    private String name;
    private int price;
    Phone(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
class Phone2 {
    private String name;
    private int price;
    private String comp;

    Phone2(String name, int price, String comp) {
        this.name = name;
        this.price = price;
        this.comp = comp;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getComp() {
        return comp;
    }
}
class Phone2Comp implements Comparator<Phone2> {
    @Override
    public int compare(Phone2 o1, Phone2 o2) {
        return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
    }
}




