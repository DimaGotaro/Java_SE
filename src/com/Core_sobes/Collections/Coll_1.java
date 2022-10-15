package com.Core_sobes.Collections;

import java.util.*;

public class Coll_1 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("we");
        strings.add("lkdskf");
        strings.add("mnvm");
        strings.trimToSize();
//        for (String string : strings) {
//            strings.remove(string);
//        }

        System.out.println(strings);
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("lkdskf")) {
                iterator.remove();
            }
        }
        System.out.println(strings);

        PriorityQueue<String> strings1 = new PriorityQueue<>();
        strings1.add("1");
        strings1.add("2");
        strings1.add("3");
        strings1.add("4");
        System.out.println(strings1);
        while (strings1.peek() != null) {
            System.out.println(strings1.poll());
        }
        System.out.println(strings1);

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        System.out.println(linkedList.indexOf("1"));
        linkedList.add(1, "2.5");
        System.out.println(linkedList);

        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();

        TreeSet<String> treeSet = new TreeSet<>();

        HashSet<String> strings2 = new HashSet<>();

        Object d = new int[3];

        ArrayDeque<String> strings3 = new ArrayDeque<>();
    }
}
interface WordPath {

}
class Word {
    Root root;
}
class Root {

}