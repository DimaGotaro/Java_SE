package com.Core_sobes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMy {
    public static void main(String[] args) {
        String[] array = {"Java", "Ruuuuussshhh"};
        java.util.stream.Stream<String> stream = Arrays.stream(array);
        stream.map(s -> s.split("")) //Преобразование слова в массив букв, возвращает
                // 2 потока, которые нужно соединить с помощью flatMap
                .flatMap(Arrays::stream).distinct()/*.toList()*/.forEach(System.out::print);
        System.out.println();
        System.out.println();

        java.util.stream.Stream<String> stream2 = Arrays.stream(array);
        stream2.map(s -> s.split(""))
                .map(Arrays::stream).distinct().forEach(System.out::println);
        System.out.println();

        java.util.stream.Stream<Phon> d9 = java.util.stream.Stream.of(new Phon("Motorolla", 500, "Moto"),
                new Phon("Samsung", 1000, "Sam"),
                new Phon("Poco", 300, "Xiomi"),
                new Phon("Poco", 589, "Xio"),
                new Phon("Juchka", 894, "Sam"));
        Map<String, List<Phon>> d10 = d9.collect(Collectors.groupingBy(x -> {
            return x.getComp().length() > 3 ? x.getName() : x.getComp();
        }));
//        Map<String, List<Phon>> d10 = d9.collect(Collectors.groupingBy(Phon::getComp));
        System.out.println(d10);
        System.out.println();

        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0, x))
                .forEach(System.out::print);
        System.out.println();
        System.out.println();

        Byte r = 45;
        System.out.println(r);
    }
}
class Phon {
    private String name;
    private int price;
    private String comp;

    Phon(String name, int price, String comp) {
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
