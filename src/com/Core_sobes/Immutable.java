package com.Core_sobes;

import java.util.*;

public final class Immutable {
    private final String string;
    private final Map<? extends String, ? extends String> map;

    public Immutable(String string, Map<? extends String, ? extends String> map) {
        this.string = string;
        this.map = new HashMap<String, String>(map); // ложем в поле map копию
    }

    public String getString() {
        return string;
    }

    public Map<? extends String, ? extends String> getMap() {
        return map;
    }
}
final class Person {
    private final Date birthDate;
    private final String name;
    private int id;

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
}
class App {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ImmuKey", "ImmuValue");

        Immutable filed = new Immutable("Filed", hashMap);
        System.out.println(filed.getString() + " - " + filed.getMap());

//        filed.getMap().put("NoImmuKey", " No ImmuValue"); // ошибка, изменить не получилось

        hashMap.put("NoImmuKey", " No ImmuValue");
        System.out.println(filed.getString() + " - " + filed.getMap());
        System.out.println();

//        Date date = new Date();
        Date date = new Date(45L);
        String string = "Immutable";
        int y = 5;
        Person immutable = new Person(date, string, y);

        System.out.println(immutable.getBirthDate().getTime());
        System.out.println(immutable.getName());
        System.out.println(immutable.getId());
        System.out.println(immutable.getBirthDate());
        System.out.println();

        immutable.getBirthDate().setTime(54L);
        immutable.getName().toUpperCase();
        date.setTime(66L);
        string.toUpperCase();
        y = 6;

        System.out.println(immutable.getBirthDate().getTime());
        System.out.println(immutable.getName());
        System.out.println(immutable.getId());
        System.out.println(immutable.getBirthDate());
    }
}
