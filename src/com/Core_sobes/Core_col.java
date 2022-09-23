package com.Core_sobes;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Core_col {
    public static class Util {
        public static <T> T sss(Object obj, Class<T> tClass) {
            return (T) obj;
        }
        public static <T> T sss(Object obj) {
            return (T) obj;
        }
    }

    public static void main(String[] args) {
        List list = Arrays.asList("Jojo", "Bobo"); // неизменяемый массив
//        List list = new ArrayList<>();
//        list.add("Hello!");
//        list.add("345");
        for (Object f :
                list) {
            System.out.println(f);
        }
        String a = Util.sss(list.get(0), String.class);
        System.out.println(a);
        String a1 = Util.<String>sss(list.get(0), String.class);
        System.out.println(a1);
        String a2 = Util.<String>sss(list.get(0));
        System.out.println(a2);
        System.out.println();

        List<String> list1 = new ArrayList<>(Arrays.asList("Job", "Bob", "Demo", "Rumo"));
        list1.add("Demo");
        System.out.println(list1);
//        for (String f :
//                list1) {
//            list1.remove(f); // ошибка, можно через итератор
//        }
//        System.out.println(list1);

        ListIterator<String> listIterator = list1.listIterator();
        listIterator.next();
        list1.remove(1);
//        listIterator.next(); // исключение
        System.out.println("ListIterator:");
        System.out.println(list1);


        Iterator<String> iterator = list1.iterator();
        System.out.println(iterator);
        System.out.println(iterator.next());
        iterator.remove(); // удалил элемент вызванный в next
        System.out.println();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
        for (String f :
                list1) {
            System.out.println(f);
        }

        // fail-safe итератор
        for (String s : new CopyOnWriteArrayList<>(list1)) {
            list1.remove(s);
        }
        System.out.println(list1);
        System.out.println();

        // Set - уникальные значения
        // HashSet - нет последовательности добавления
        Set<String> set = new HashSet<>(Arrays.asList("Job", "Bob", "Demo", "Demo"));
        set.add("Rumo");
        System.out.println(set);
        set.add("Rumo1");
        System.out.println(set);
        System.out.println(set.contains("Bob"));
        System.out.println(set.stream().filter(x -> x.equals("Bob")));
        String bob = set.stream().filter(x -> x.equals("Bob")).findAny().orElse(null);
        System.out.println(bob);

        // TreeSet - сортировка по алфавиту или величине
        System.out.println("TreeSet.................................");
        Set<String> set1 = new TreeSet<>(Arrays.asList("Job", "Bob", "Demo", "Demo"));
        set1.add("Aumo");
        System.out.println(set1);

        TreeSet<Integer> set11 = new TreeSet<>(Arrays.asList(1, 2, 4, 5, 6, 7));
        System.out.println(set11.floor(3));
        System.out.println("TreeSet.................................");

        // LinkedHashSet - элементы хранятся в порядке добавления
        Set<String> set2 = new LinkedHashSet<>(Arrays.asList("Job", "Bob", "Demo", "Demo"));
        set2.add("Aumo");
        System.out.println(set2);
        System.out.println();

        // Queue
        // однонаправленная очередь, упорядоченная по компаратору
        PriorityQueue<String> queue = new PriorityQueue<>(new PrComp()); // нужен компаратор
        queue.offer("Job");
        queue.offer("Demo");
        queue.offer("Bob");
        queue.offer("Mumo");
        System.out.println(queue); // хранится не по порядку
        while (queue.peek() != null) {
            System.out.println(queue.poll());
        }

        // двунаправленная очередь
        ArrayDeque<String> queue1 = new ArrayDeque<>(Arrays.asList("Job", "Bob", "Demo"));
        queue1.add("Noitora");
        queue1.addFirst("Demo");
        System.out.println(queue1);

        // LinkedList - интерфейсы: List, Deque, Queue
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("Job", "Bob", "Demo"));
        linkedList.add("Lula");
        System.out.println(linkedList);
        System.out.println();

        // Map
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Goga");
        hashMap.put(2, "Tomiyoka");
        hashMap.put(3, "Fugi");
        System.out.println(hashMap);
        hashMap.put(3, "Fugi1");
        System.out.println(hashMap);
        hashMap.put(4, "Fugi1");
        System.out.println(hashMap);

        TreeMap<Integer, String> treeMap = new TreeMap<>(); // сортирует по возрастанию
        treeMap.put(2, "Hash");
        treeMap.put(1, "Truble");
        treeMap.put(5, "Jordan");
        System.out.println(treeMap);

        String[] v = new String[] {"g", "g"};
        for (String f :
                v) {
            System.out.println(f);
        }
    }
}
class PrComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}




