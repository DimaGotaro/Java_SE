package com.company;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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
        // takeWhile
        Stream<Integer> b3 = Stream.of(-3, -2, -1, 0, 1, 2, 3, -4, -5);
        b3
                .takeWhile(n -> n < 0) // проверяет по порядку элементы на выполнение условия,
                // если false - останавливается
                .forEach(p -> System.out.print(p + "\t"));
        System.out.println();
        System.out.println();
        Stream<Integer> b4 = Stream.of(-3, -2, -1, 0, 1, 2, 3, -4, -5);
        b4
                .sorted() // сортировка по возростанию
                .takeWhile(n -> n < 0)
                .forEach(p -> System.out.print(p + "\t"));
        System.out.println();
        System.out.println();

        // dropWhile
        Stream<Integer> b5 = Stream.of(-3, -2, -1, 0, 1, 2, 3, -4, -5);
        b5
                .sorted()
                .dropWhile(n -> n < 0) // если условие выполнено - пропускает
                .forEach(p -> System.out.print(p + "\t"));
        System.out.println();
        System.out.println();

        // concat
        Stream<Integer> b6 = Stream.of(1, 3, 4);
        Stream<Integer> b7 = Stream.of(8, 9, 7);
        Stream.concat(b6, b7) // объединение потоков
                .forEach(p -> System.out.print(p + "\t"));
        System.out.println();
        System.out.println();

        // distinct
        Stream<Integer> b8 = Stream.of(8, 9, 7, 8, 2, 9, 2, 1, 3);
        b8
                .distinct() // сортирует на повторения, возвращает уникальные элементы
                .forEach(p -> System.out.print(p + "\t"));
        System.out.println();
        System.out.println();

        // Методы skip и limit
        Stream<String> b9 = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель", "Sanji",
                "Bryk", "Chopper", "Robin");
        b9
                .skip(1) // пропускает один элемент
                .limit(1) // добавляет один элемент
                .forEach(p -> System.out.print(p + "\t"));
        System.out.println();
        System.out.println();
        // поиск по номеру страницы
        Stream<String> b10 = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель", "Sanji",
                "Bryk", "Chopper", "Robin");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер страницы: ");
//        int b = in.nextInt();
        int b = 3;
        int a = 2; // кол-во элементов в странице
        if (b > 1) {
            b10
                    .skip((b-1)*a)
                    .limit(a)
                    .forEach(p -> System.out.print(p + "\t"));
        }
        else {
            System.out.println("Неправильно набран номер страницы!");
        }
        System.out.println();
        System.out.println();

        // Операции сведения
        // count
        Stream<String> b101 = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель", "Sanji",
                "Bryk", "Chopper", "Robin");
        System.out.println(b101.count()); // кол-во элементов потока
        System.out.println();

        // findFirst и findAny
        Stream<String> b11 = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель", "Sanji",
                "Bryk", "Chopper", "Robin");
        System.out.println(b11.findFirst().get()); // вывод первого элемента
        Stream<String> b12 = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель", "Sanji",
                "Bryk", "Chopper", "Robin");
        System.out.println(b12.findAny().get()); // вывод случайного элемента(вызывает первый)
        System.out.println();

        // allMatch, anyMatch, noneMatch - boolean
        Stream<String> b13 = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель", "Sanji",
                "Bryk", "Chopper", "Robin");
        System.out.println(b13.allMatch(p -> p.length()==5)); // true - если все элементы удовлетворяют условию
        Stream<String> b14 = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель", "Sanji",
                "Bryk", "Chopper", "Robin");
        System.out.println(b14.anyMatch(p -> p.length()==5)); // true - если один элемент удовлетворет условию
        Stream<String> b15 = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель", "Sanji",
                "Bryk", "Chopper", "Robin");
        System.out.println(b15.noneMatch(p -> p.length()==3)); // true - если ни один элемент не удовлетворет условию
        System.out.println();

        // min и max
        Stream<Integer> c1 = Stream.of(8, 9, 7, 6, 2, 9, 2, 1, 3);
        System.out.println(c1.min(Integer::compare).get()); // минимальный элемент
        Stream<Integer> c2 = Stream.of(8, 9, 7, 6, 2, 9, 2, 1, 3);
        System.out.println(c2.max(Integer::compare).get()); // максимальный элемент
        // сравнение по Integer - getPrice
        Stream<Phone3> c3 = Stream.of(new Phone3("Motorolla", 500),
                new Phone3("Samsung", 1000), new Phone3("Poco", 300));
        Phone3 min = c3.min(Phone3::compare).get();
        System.out.println("Самый дешёвый: " + min.getName() + " " + min.getPrice());
        Stream<Phone3> c4 = Stream.of(new Phone3("Motorolla", 500),
                new Phone3("Samsung", 1000), new Phone3("Poco", 300));
        Phone3 max = c4.max(Phone3::compare).get();
        System.out.println("Самый дорогой: " + max.getName() + " " + max.getPrice());
        System.out.println();

        // Метод reduce
        // 1 способ
        Stream<Integer> c5 = Stream.of(6, 2, 1, 3, 5);
        Optional<Integer> c51 = c5.reduce((x,y) -> x*y); // перемножение всех элементов
        System.out.println(c51.get());
        Stream<String> c6 = Stream.of("Sanji", "Bryk", "Chopper", "Robin");
        System.out.println(c6.reduce((x, y) -> x + " " + y).get()); // объеденение строк
        // 2 способ
        Stream<Integer> c7 = Stream.of(6, 2, 1, 3, 5);
        System.out.println(c7.reduce(2, (x, y) -> x * y)); // 2 - станет первым элементом
        // 3 способ
        Stream<Phone3> c8 = Stream.of(new Phone3("Motorolla", 500),
                new Phone3("Samsung", 1000), new Phone3("Poco", 300));
        int sum = c8.reduce(0, (x, y) -> {
            if (y.getPrice() < 600) {
                return x + y.getPrice(); // 0 это первое значение, x
            }
            else {
                return x;
            }
        }, (x, y) -> x + y);
        System.out.println("Сумма всех телефонов дешевле 600: " + sum);
        System.out.println();

        // Тип Optional
        Stream<Integer> c9 = Stream.of();
//        System.out.println(c9.min(Integer::compare).get()); // ошибка! пустой поток
        Optional<Integer> c10 = c9.min(Integer::compare);
        if (c10.isPresent()) { // true - если значение присутствует
            System.out.println(c10.get());
        }
        else {
            System.out.println("Пуфто!");
        }

        // orElse
        Stream<Integer> c11 = Stream.of();
        Optional<Integer> c12 = c11.min(Integer::compare);
        System.out.println(c12.orElse(0)); // если значение отсутствует, то будет возвращаться 0
        Stream<Integer> c13 = Stream.of(2, 9, 5, 7);
        Optional<Integer> c14 = c13.min(Integer::compare);
        System.out.println(c14.orElse(0)); // если значение присутствует, то вернётся лругое значение

        // orElseGet
        Stream<Integer> c15 = Stream.of();
        Optional<Integer> c16 = c15.min(Integer::compare);
        Random rnd = new Random();
        System.out.println(c16.orElseGet(() -> rnd.nextInt(100))); // если пусто, вернёт случайное значение
        // до 100, если не пусто вернёт 1

        // orElseThrow
        Stream<Integer> c17 = Stream.of();
        Optional<Integer> c18 = c17.min(Integer::compare);
//        System.out.println(c18.orElseThrow(IllegalStateException::new)); // если пусто генерирует исключение

        // Обработка полученного значения
        Stream<Integer> c19 = Stream.of(1, 6, 7, 3);
        Optional<Integer> c20 = c19.min(Integer::compare);
        c20.ifPresent(System.out::println); // 1, если в Optional есть значение, то выполняется действие

        Stream<Integer> c21 = Stream.of();
        Optional<Integer> c22 = c21.min(Integer::compare);
        c20.ifPresentOrElse(
                p -> System.out.println(p), // если значение есть
                () -> System.out.println("Пуфто!")); // если значения нет
        System.out.println();

        // Метод collect
        List<String> d1 = new ArrayList<>();
        Collections.addAll(d1, "Париж", "Лондон", "Мадрид","Берлин", "Брюссель", "Sanji",
                "Bryk", "Chopper", "Robin");
        List<String> d2 = d1
                .stream()
                .filter(p -> p.length() > 5)
                .collect(Collectors.toList()); // возвращает коллекцию типа List из потока
        d2.forEach(p -> System.out.println(p));
        System.out.println();

        Stream<Phone> d3 = Stream.of(new Phone("Motorolla", 500), new Phone("Samsung", 1000),
                new Phone("Poco", 300));
        Map<String, Integer> d4 = d3.collect(Collectors.toMap(p -> p.getName(), c -> c.getPrice())); // из потока в Map
        d4.forEach((t, j) -> System.out.println(t + " " + j));
        System.out.println();

        Stream<String> d5 = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель", "Sanji",
                "Bryk", "Chopper", "Robin");
        HashSet<String> d6 = d5
                .filter(p -> p.length() < 6)
                .collect(Collectors.toCollection(HashSet::new)); // создание объекта любого типа коллекции
        d6.forEach(p -> System.out.println(p));
        System.out.println();

        String item2 = "Katayanagi";
        List<String> d71 = new ArrayList<>();
        Collections.addAll(d71, "Sanji", "Bryk", "Chopper", "Robin");
        Stream<String> d7 = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель");
        ArrayList<String> d8 = d7.collect(
                ArrayList::new, // пустой объект
                (list, item) -> list.add(item), // добавляем элементы
                (list1, list2) -> list1.addAll(list2) // добавляем список в дргой список
        );
        d8.forEach(p -> System.out.println(p));
        System.out.println();

        // Группировка
        Stream<Phone2> d9 = Stream.of(new Phone2("Motorolla", 500, "Moto"),
                new Phone2("Samsung", 1000, "Sam"),
                new Phone2("Poco", 300, "Xiomi"),
                new Phone2("Poco2", 589, "Xiomi"),
                new Phone2("Juchka", 894, "Sam"));
        Map<String, List<Phone2>> d10 = d9.collect(Collectors.groupingBy(Phone2::getComp)); // назначаем ключ getComp,
        // объекты с одинаковыми ключами будут сгруппированы в список, которым является содержимое
        System.out.println(d10);
        for (Map.Entry<String, List<Phone2>> r:
                d10.entrySet()) {
            System.out.println(r.getKey() + ":");
            for (Phone2 t:
                 r.getValue()) {
                System.out.println(t.getName() + " " + t.getPrice() + " " + t.getComp());
            }
            System.out.println();
        }
        System.out.println();

        // Метод Collectors.partitioningBy, группирование по условию
        Stream<Phone2> d11 = Stream.of(new Phone2("Motorolla", 500, "Moto"),
                new Phone2("Samsung", 1000, "Sam"),
                new Phone2("Poco", 300, "Xiomi"),
                new Phone2("Poco2", 589, "Xiomi"),
                new Phone2("Juchka", 894, "Sam"));
        Map<Boolean, List<Phone2>> d12 = d11.collect(Collectors.partitioningBy(p -> p.getComp()=="Sam"));
        for (Map.Entry<Boolean, List<Phone2>> e:
                d12.entrySet()) {
            if (e.getKey()) {
                System.out.println("Sam:");
            }
            else {
                System.out.println("Undefined:");
            }
            for (Phone2 f:
                 e.getValue()) {
                System.out.println(f.getName() + " " + f.getPrice() + " " + f.getComp());
            }
            System.out.println();
        }

        // Метод Coollectors.counting - кол-во элементов в содержимом
        Stream<Phone2> d13 = Stream.of(new Phone2("Motorolla", 500, "Moto"),
                new Phone2("Samsung", 1000, "Sam"),
                new Phone2("Poco", 300, "Xiomi"),
                new Phone2("Poco2", 589, "Xiomi"),
                new Phone2("Juchka", 894, "Sam"));
        Map<String, Long> d14 = d13.collect(Collectors.groupingBy(Phone2::getComp, Collectors.counting()));
        for (Map.Entry<String, Long> h:
                d14.entrySet()) {
            System.out.println(h.getKey() + "-" + h.getValue());
        }
        System.out.println();

        // Метод Collectors.summing - сумма всех чисел в содержимом
        Stream<Phone2> d15 = Stream.of(new Phone2("Motorolla", 500, "Moto"),
                new Phone2("Samsung", 1000, "Sam"),
                new Phone2("Poco", 300, "Xiomi"),
                new Phone2("Poco2", 589, "Xiomi"),
                new Phone2("Juchka", 894, "Sam"));
        Map<String, Integer> d16 = d15.collect(Collectors.groupingBy(Phone2::getComp,
                Collectors.summingInt(Phone2::getPrice))); // сумма всех getPrice
        for (Map.Entry<String, Integer> w:
                d16.entrySet()) {
            System.out.println(w.getKey() + "-" + w.getValue());
        }
        System.out.println();

        // Методы maxBy и minBy - мин и макс в содержимом
        Stream<Phone2> d17 = Stream.of(new Phone2("Motorolla", 500, "Moto"),
                new Phone2("Samsung", 1000, "Sam"),
                new Phone2("Poco", 300, "Xiomi"),
                new Phone2("Poco2", 589, "Xiomi"),
                new Phone2("Juchka", 894, "Sam"));
        Map<String, Optional<Phone2>> d18 = d17.collect(Collectors.groupingBy(Phone2::getComp,
                Collectors.minBy(Comparator.comparing(Phone2::getPrice)))); // минимальное в содержимом из всех getPrice
        for (Map.Entry<String, Optional<Phone2>> w:
                d18.entrySet()) {
            System.out.println(w.getKey() + " min - " + w.getValue().get().getPrice());
        }
        System.out.println();

        // Метод summarizing - объединяет в набор значения одного типа в содержимом для разных
        // действий(getAverage(): возвращает среднее значение
        //getCount(): возвращает количество элементов в наборе
        //getMax(): возвращает максимальное значение
        //getMin(): возвращает минимальное значение
        //getSum(): возвращает сумму элементов
        //accept(): добавляет в набор новый элемент)
        Stream<Phone2> d19 = Stream.of(new Phone2("Motorolla", 500, "Moto"),
                new Phone2("Samsung", 1000, "Sam"),
                new Phone2("Samsung2", 300, "Sam"),
                new Phone2("Poco", 300, "Xiomi"),
                new Phone2("Poco2", 500, "Xiomi"),
                new Phone2("Poco3", 700, "Xiomi"),
                new Phone2("Juchka", 800, "Sam"));
        Map<String, IntSummaryStatistics> d20 = d19.collect(Collectors.groupingBy(Phone2::getComp,
                Collectors.summarizingInt(Phone2::getPrice)));
        for (Map.Entry<String, IntSummaryStatistics> w:
                d20.entrySet()) {
            System.out.println(w.getKey() + " среднее - " + w.getValue().getAverage()); // вычисляет среднее
        }
        System.out.println();

        // Метод mapping - отображение другого типа данных, от имеющегося Phone2 -> String
        Stream<Phone2> d21 = Stream.of(new Phone2("Motorolla", 500, "Moto"),
                new Phone2("Samsung", 1000, "Sam"),
                new Phone2("Poco", 300, "Xiomi"),
                new Phone2("Poco2", 589, "Xiomi"),
                new Phone2("Juchka", 894, "Sam"));
        Map<String, List<String>> d22 = d21.collect(Collectors.groupingBy(Phone2::getComp,
                Collectors.mapping(Phone2::getName, Collectors.toList())));
        for (Map.Entry<String, List<String>> r:
                d22.entrySet()) {
            System.out.println(r.getKey() + ":");
            for (String t:
                    r.getValue()) {
                System.out.println(t);
            }
            System.out.println();
        }

        // Параллельные потоки
        Stream<Integer> f1 = Stream.of(1, 2, 3, 4, 5, 6);
        f1
                .parallel()
                .forEach(p -> System.out.print(p + "\t")); // вывод в разнобой
        System.out.println();
        System.out.println();

        List<String> f2 = Arrays.asList("Sanji", "Bryk", "Chopper", "Robin");
        System.out.println("Последовательный поток");
        f2
                .stream()
                .forEach(System.out::println);
        System.out.println();
        System.out.println("Параллельный поток");
        f2
                .parallelStream() // вывод в разнобой
                .forEach(System.out::println);
        System.out.println();
        Stream<Integer> f3 = Stream.of(1, 2, 3);
        Integer f = f3
                .parallel() // тот же результат что и в последовательном потоке, можно в параллельный,
                // операция ассоциативна
                .reduce((x, y) -> x * y)
                .get();
        System.out.println(f);
        System.out.println();

        // forEachOrdered - сохраняет последовательность
        List<String> f4 = Arrays.asList("Sanji", "Bryk", "Chopper", "Robin");
        System.out.println("Параллельный поток");
        f4
                .parallelStream() // вывод в разнобой
                .forEachOrdered(System.out::println);
        System.out.println();
        // без сохр последовательности - unordered()
        List<String> f5 = Arrays.asList("Sanji", "Bryk", "Chopper", "Robin");
        System.out.println("Параллельный поток");
        f5
                .parallelStream()
                .unordered()
                .forEach(System.out::println);
        System.out.println();

        // Параллельные операции над массивами
        int[] mass = new int[6];
        Arrays.parallelSetAll(mass, i -> i*10); // добавили в массив с условием, i - это каждый элемент массива
        for (int o:
             mass) {
            System.out.print(o + "\t");
        }
        System.out.println();
        System.out.println();

        int[] mass2 = mass_Set(5);
        for (int o:
                mass2) {
            System.out.print(o + "\t");
        }
        System.out.println();
        System.out.println();

        Phone[] mass3 = new Phone[] {
                new Phone("Motorolla", 500),
                new Phone("Samsung", 1000),
                new Phone("Poco", 300)
        };
        Arrays.parallelSetAll(mass3, i -> {
            mass3[i].setPrice(mass3[i].getPrice() - 100);
            return mass3[i];
        });
        for (Phone o:
                mass3) {
            System.out.println(o.getName() + ": " + o.getPrice());
        }
        System.out.println();

        // Сортировка
        int[] mass4 = {9, 1, -1, -56, 24};
        Arrays.parallelSort(mass4); // сортировка по возрастанию
        for (int o:
                mass4) {
            System.out.print(o + "\t");
        }
        System.out.println();
        System.out.println();

        Phone[] mass5 = new Phone[] {
                new Phone("Motorolla", 500),
                new Phone("Samsung", 1000),
                new Phone("Poco", 300)
        };
        Arrays.parallelSort(mass5, new PhoneComp()); // сортировка по компаратору
        for (Phone o:
                mass5) {
            System.out.println(o.getName() + ": " + o.getPrice());
        }
        System.out.println();

        // Метод parallelPrefix - сохраняет промежуточные операции
        int[] mass6 = {1, 2, 3, 4};
        Arrays.parallelPrefix(mass6, (x, y) -> x * y);
        for (int o:
                mass6) {
            System.out.print(o + "\t");
        }
        System.out.println();
        System.out.println();
    }
    public static int[] mass_Set(int size) {
        int[] val = new int[size];
        Arrays.parallelSetAll(val, i -> i*2); // i - это каждый элемент массива
        return val;
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
class Phone3 {
    private String name;
    private int price;

    Phone3(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static int compare(Phone3 x, Phone3 y) {
        if (x.getPrice() > y.getPrice()) {
            return 1;
        }
        else {
            return -1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
class PhoneComp implements Comparator<Phone> {
    @Override
    public int compare(Phone x, Phone y) {
        if (x.getPrice() > y.getPrice()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}




