package com.Core_sobes;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        String[] array = {"Java", "Ruuuuussshhh"};
        java.util.stream.Stream<String> stream = Arrays.stream(array);
        stream.map(s -> s.split("")) //Преобразование слова в массив букв, возвращает
                // 2 потока, которые нужно соединить с помощью flatMap
                .flatMap(Arrays::stream).distinct()/*.toList()*/.forEach(System.out::println);
    }
}
