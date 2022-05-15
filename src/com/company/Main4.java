package com.company;
import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        // Collection
        // Интерфейс Collection является обобщенным и расширяет интерфейс Iterable
        // Класс ArrayList применяется интерфейс List
        ArrayList<String> people = new ArrayList<String>(8); // 8 - вероятное кол-во элементов
        people.ensureCapacity(8); // установка вероятного кол-ва элементов, только методом
        people.add("Bob"); // добавление элемента в список
        people.add("Tom");
        people.add("Chert");
        people.add("Lina");
        people.add(0,"Sanya"); // добавляем элемент по индексу 0
        people.add(0,"Sanya2"); // присваивается индексу 0, а "Sanya" становится 1
        System.out.println(people.get(1)); // вывод элемента с индексом 1
        people.set(4, "Chert2"); // редактирование элемента с индексом 4
        System.out.println("Количество элементов: " + people.size());
        for (String b:
             people) {
            System.out.println(b);
        }
        if (people.contains("Tom")) { // поиск элемента по содержимому
            System.out.println("Элемент найден!");
        }
        people.remove("Chert2"); // удаление объекта по содержимому
        people.remove(1); // удаление по индексу
        Object[] peopleArr = people.toArray(); // преобразование списка из строк в массив объекта
        System.out.println("Количество элементов: " + peopleArr.length);
        for (Object v:
             peopleArr) {
            System.out.println(v);
        }
        Collections.addAll(people, "Face", "Grecha"); // добавление нескольких элементов
        System.out.println("Количество элементов: " + people.size());
        for (String b:
                people) {
            System.out.println(b);
        }
        ArrayList<String> people2 = new ArrayList<String>(Arrays.asList("Dyra", "Joker")); // добавление элементов при
        // создании объекта
        System.out.println("Количество элементов people2: " + people2.size());
        for (String b:
                people2) {
            System.out.println(b);
        }
        System.out.println();

        // Очереди и класс ArrayDeque реализуют специальные интерфейсы Queue или Deque
        ArrayDeque<String> people3 = new ArrayDeque<String>(); // при пустых скобках 16 - кол-во элементов
        people3.add("Vanessa");
        people3.addFirst("Tosha"); // добавляет в начало очереди
        people3.addLast("Losha"); // добавляет в конец очереди
        people3.push("Jorick"); // добавляет в самое начало очереди
        people3.add("Zosya");
        System.out.println(people3.getFirst()); // возвращает первый элемент
        System.out.println(people3.getLast()); // возвращает последний элемент
        System.out.println("Количество эле в очереди р3: " + people3.size());
        while (people3.peek()!= null) { // peek - возвращает первое значение не удаляя его, null если пусто
            System.out.println(people3.pop()); // pop - возвращает первое значение удаляя его, исключение если пусто
        } // после рор все элементы очереди удалены
//        while (people3.peekFirst()!= null) { // то же самое
//            System.out.println(people3.pollFirst());
//        }
        ArrayDeque<Lichnost> people4 = new ArrayDeque<Lichnost>();
        people4.addFirst(new Lichnost("Armenchik"));
        people4.addLast(new Lichnost("Ashotick"));
        System.out.println("Количество эле в очереди р4: " + people4.size());
        for (Lichnost g:
             people4) {
            System.out.println(g.getName());
        }
        System.out.println();

        // Класс LinkedList - реализует интерфейсы List, Dequeue и Queue
        LinkedList<String> people5 = new LinkedList<String>();
        people5.add("Kruger");
        people5.addFirst("Voyaka");
        people5.addLast("Byyaka");
        people5.add(2, "Oxxx");
        System.out.println(people5.getLast());
        people5.set(1, "Flint");
        System.out.println("Количество эле в очереди р5: " + people5.size());
        for (String j:
             people5) {
            System.out.println(j);
        }
        if (people5.contains("Flint")) {
            System.out.println("Найден элемент - Flint");
        }
        people5.remove("Flint");
        people5.removeLast();
        LinkedList<Lichnost> people6 = new LinkedList<Lichnost>();
        Collections.addAll(people6, new Lichnost("Alan"), new Lichnost("Nail"));
        people6.addFirst(new Lichnost("Jankoi"));
        System.out.println(people6.getFirst().getName());
        people6.removeFirst();
        System.out.println("Количество эле в очереди р6: " + people6.size());
        for (Lichnost l:
             people6) {
            System.out.println(l.getName());
        }
        System.out.println();

        // Интерфейс Set и класс HashSet, представляет хеш-таблицу - Интерфейс Set
        HashSet<String> people7 = new  HashSet<String>();
        people7.add("Ben");
        people7.add("Ben2"); // каждое новое значение становится первым
        System.out.println(people7.add("Ben3")); // добавляет и возвращает true или false
        System.out.println(people7.add("Ben3"));
        people7.remove("Ben3");
        System.out.println("Количество эле в таблице р7: " + people7.size());
        for (String r:
             people7) {
            System.out.println(r);
        }
        HashSet<Lichnost> people8 = new HashSet<Lichnost>();
        Collections.addAll(people8, new Lichnost("Maik"), new Lichnost("Tifani"), new Lichnost("Cler"));
        System.out.println("Количество эле в таблице р8: " + people8.size());
        for (Lichnost p:
             people8) {
            System.out.println(p.getName());
        }
    }
}
class Lichnost {
    private String name;

    public Lichnost(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}