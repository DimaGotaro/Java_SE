package com.Core_sobes;

import java.util.HashMap;
import java.util.Objects;

public class EquHash {
    public static void main(String[] args) {
        System.out.println("Example:");
        Example one1 = new Example("One", 1);
        Example one2 = new Example("One", 1);
        HashMap<Example, Integer> mapOne = new HashMap<>();
        mapOne.put(one1, 1);
        System.out.println(mapOne.get(one1)); // 1
        System.out.println(mapOne.get(one2)); // 1
        mapOne.put(one2, 2);
        System.out.println(mapOne.get(one1)); // 2, значение перезаписано
        System.out.println();
        /* При переопределённом equals ключом по сути являются поля объектов Example */

        System.out.println("ExampleNon:");
        ExampleNon twoNon1 = new ExampleNon("Two", 2);
        ExampleNon twoNon2 = new ExampleNon("Two", 2);
        HashMap<ExampleNon, Integer> mapNon = new HashMap<>();
        mapNon.put(twoNon1, 2);
        System.out.println("twoNon1 = " + mapNon.get(twoNon1)); // 2
        System.out.println("twoNon2 = " + mapNon.get(twoNon2)); // null
        mapNon.put(twoNon2, 3);
        System.out.println("twoNon1 = " + mapNon.get(twoNon1)); // 2
        System.out.println("twoNon2 = " + mapNon.get(twoNon2)); // 3, пара добавлена
        System.out.println();
        /* При не переопределённом equals ключом по сути являются объекты ExampleNon */

        System.out.println("ExampleHash:");
        ExampleHash hash1 = new ExampleHash("Three", 99);
        ExampleHash hash2 = new ExampleHash("Three", 99);
        HashMap<ExampleHash, Integer> mapHash = new HashMap<>();
        mapHash.put(hash1, 4);
        System.out.println("hash1 = " + mapHash.get(hash1)); // 4
        System.out.println("hash2 = " + mapHash.get(hash2)); // null
        /* При не переопределённом equals ключом по сути являются объекты ExampleNon */
    }
}
class Example {
    private String s;
    private int i;

    public Example(String s, int i) {
        this.s = s;
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Example example = (Example) o;
        return i == example.i && s.equals(example.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s, i);
    }
}
class ExampleNon {
    private String s;
    private int i;

    public ExampleNon(String s, int i) {
        this.s = s;
        this.i = i;
    }
}
class ExampleHash {
    private String s;
    private int i;

    public ExampleHash(String s, int i) {
        this.s = s;
        this.i = i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(s, i);
    }
}
class ExampleEquals {
    private String s;
    private int i;

    public ExampleEquals(String s, int i) {
        this.s = s;
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExampleEquals that = (ExampleEquals) o;
        return i == that.i && s.equals(that.s);
    }
}
