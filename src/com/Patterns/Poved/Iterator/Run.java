package com.Patterns.Poved.Iterator;

public class Run {
    public static void main(String[] args) {
        String[] sk = {"Java", "Spring", "Hibernate", "PostgreSQL"};

        JavaD javaD = new JavaD("Super", sk);

        Iterator iterator = javaD.getIterator();

        System.out.println(javaD.getName());
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
