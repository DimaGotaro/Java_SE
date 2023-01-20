package com.Core_sobes;

import java.util.*;

public class Immutable {
    private final int anInt;
    private final String string;
    private final StringBuilder stringBuilder;
    private final Map<String, StringBuilder> map;

    public Immutable(int anInt, String string, StringBuilder stringBuilder, Map<String, StringBuilder> map) {
        this.anInt = anInt;
        this.string = string;
        this.stringBuilder = new StringBuilder(stringBuilder);
        HashMap<String, StringBuilder> hashMap = new HashMap<>();
        for (Map.Entry<String, StringBuilder> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), new StringBuilder(entry.getValue()));
        }
        this.map = hashMap;
    }
    public int getAnInt() {
        return anInt;
    }
    public String getString() {
        return string;
    }
    public StringBuilder getStringBuilder() {
        return new StringBuilder(stringBuilder);
    }
    public Map<String, StringBuilder> getMap() {
        HashMap<String, StringBuilder> hashMap = new HashMap<>();
        for (Map.Entry<String, StringBuilder> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), new StringBuilder(entry.getValue()));
        }
        return hashMap;
    }
    @Override
    public String toString() {
        return "Immutable{" +
                "anInt=" + anInt +
                ", string='" + string + '\'' +
                ", stringBuilder=" + stringBuilder +
                ", map=" + map +
                '}';
    }
}
class App {
    public static void main(String[] args) {
        int a = 2;
        String str = "Hello!";
        StringBuilder stringBuilder = new StringBuilder("World!");
        HashMap<String, StringBuilder> hashMap = new HashMap<>();
        hashMap.put(str, stringBuilder);

        Immutable immutable1 = new Immutable(a, str, stringBuilder, hashMap);
        System.out.println(immutable1);
        System.out.println();

        StringBuilder sb2 = stringBuilder;
        sb2.append(" Dima!");
        hashMap.put("1234", new StringBuilder("Epta!"));
        System.out.println(immutable1);

        System.out.println();

        long lg = 55L;
//        Date date = new Date(lg);
        Date date = new Date();
        String string = "Immutable";
        int y = 5;
        Person person = new Person(date, string, y);

        System.out.println(person);
        System.out.println(person.getBirthDate().getTime());
        System.out.println();

        lg = 30L;
        date.setTime(70L);
//        date = new Date();
        y = 10;
        person.getBirthDate().setTime(54L);

        System.out.println(person);
        System.out.println(person.getBirthDate().getTime());
        System.out.println();
    }
}
final class Person {
    private final Date birthDate;
    private final String name;
    private final int id;

    Person (Date birthDate, String name, int id) {
        this.birthDate = new Date(birthDate.getTime());
        this.name = name;
        this.id = id;
    }

    public Date getBirthDate() {
        return new Date(birthDate.getTime());
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "birthDate=" + birthDate +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
