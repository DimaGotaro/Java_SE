package com.company;
import java.lang.reflect.Array;
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
        Collections.addAll(people8, new Lichnost("Maik"), new Lichnost("Tifani"),
                new Lichnost("Cler"));
        System.out.println("Количество эле в таблице р8: " + people8.size());
        for (Lichnost p:
             people8) {
            System.out.println(p.getName());
        }
        System.out.println();

        // SortedSet, NavigableSet, TreeSet - дерево, сортирует
        TreeSet<String> people9 = new TreeSet<String>(Arrays.asList("Noga", "Jora", "Autya", "Nanika", "Zaron"));
        // расставляет по алфавиту!
//        people9.remove("Furer");
        System.out.println("Количество эле в дерево р9: " + people9.size());
        for (String b:
             people9) {
            System.out.println(b);
        }
        System.out.println();
        System.out.println(people9.first()); // получаем первый элемент
        System.out.println(people9.last()); // получаем последний элемент
        SortedSet<String> iof = people9.subSet("Jora", "Zaron"); // вывести от Jora до Nanika
        System.out.println(iof);
        System.out.println(people9.higher("Fure")); // элемент из набора, который больше текущего
        System.out.println(people9.lower("Fure")); // элемент из набора, который меньше текущего
        System.out.println("Обратный порядок: \n" + people9.descendingSet()); // возвращаем набор в обратном порядке
        System.out.println("Все меньше текущего:\n" + people9.headSet("Nanika")); // возвращаем набор
        // в котороv все элементы меньше текущего
        System.out.println("Все больше текущего:\n" + people9.tailSet("Nanika")); // возвращаем набор
        // в котором все элементы больше текущего
        System.out.println();

        // Интерфейсы Comparable и Comparator. Сортировка
        TreeSet<Lichnost2> people10 = new TreeSet<Lichnost2>();
        Lichnost2 a = new Lichnost2("Fedya");
        people10.add(a);
        Lichnost2 a1 = new Lichnost2("Bodya");
        people10.add(a1);
        System.out.println("Количество эле в дерево р10: " + people10.size());
        for (Lichnost2 f:
             people10) {
            System.out.println(f.getName());
        }
        System.out.println(a.compareTo(a1));
        System.out.println(a1.compareTo(a));

        PreComp preComp = new PreComp();
        TreeSet<Lichnost> people11 = new TreeSet<Lichnost>(preComp);
        Lichnost a2 = new Lichnost("Manya");
        people11.add(a2);
        Lichnost a3 = new Lichnost("Gadya");
        people11.add(a3);
        System.out.println("Количество эле в дерево р11: " + people11.size());
        for (Lichnost m:
             people11) {
            System.out.println(m.getName());
        }
        System.out.println(preComp.compare(a2, a3));
        System.out.println(preComp.compare(a3, a2));

        Comparator<Lichnost3> preComp2 = new PreNameComp().thenComparing(new PreAgeComp()); // сортировка по
        // нескольким компараторам
        TreeSet<Lichnost3> people12 = new TreeSet<Lichnost3>(preComp2);
        Lichnost3 a4 = new Lichnost3("Roma", 31);
        people12.add(a4);
        Lichnost3 a5 = new Lichnost3("Roma", 25);
        people12.add(a5);
        System.out.println("Количество эле в дерево р12: " + people12.size());
        for (Lichnost3 d:
             people12) {
            System.out.println(d.getName()+" "+d.getAge());
        }
        System.out.println(preComp2.compare(a4, a5)); // сначала сортировка по имени, если имена одинаковы,
        // то сортировка по возрасту
        System.out.println(preComp2.compare(a5, a4));
        System.out.println();

        // Интерфейс Map и класс HashMap, Интерфейс Map<K, V> представляет отображение или иначе говоря словарь,
        // где каждый элемент представляет пару "ключ-значение"
        Map<Integer, String> people13 = new HashMap<Integer, String>();
        // В качестве типа ссылки по возможности указывают базовый тип/абстракцию,
        // поскольку это позволяет отвязать нашу переменную от конкретной реализации и в будущем мы можем хранить
        // в ней любой наследник/реализацию (HashMap, HashTable, TreeMap, WeakHashMap, LinkedHashMap, IdentityHashMap)
        people13.put(0, "Obama");
        people13.put(1, "Jack");
        people13.put(2, "Afro");
        people13.put(4, "Ruma");
        System.out.println(people13.entrySet());
        System.out.println(people13.get(2));
        Set<Integer> a6 = people13.keySet();
        System.out.println(a6);
        Collection<String> a7 = people13.values();
        System.out.println(a7);
        people13.replace(1, "Jack2");
        people13.remove(4);
        System.out.println("Количество эле в отображении р13: " + people13.size());
        for (Map.Entry<Integer, String> z:
             people13.entrySet()) {
            System.out.println(z.getKey()+" "+z.getValue());
        }

        Map<Integer, Lichnost> people14 = new HashMap<Integer, Lichnost>();
        people14.put(0, new Lichnost("Olabama"));
        people14.put(1, new Lichnost("Texas"));
        people14.put(2, new Lichnost("California"));
        System.out.println("Количество эле в отображении р14: " + people14.size());
        for (Map.Entry<Integer, Lichnost> x:
             people14.entrySet()) {
            System.out.println(x.getKey()+" "+x.getValue().getName());
        }
        System.out.println();

        // Интерфейсы SortedMap и NavigableMap. Класс TreeMap, в отличие от коллекции HashMap в TreeMap все
        // объекты автоматически сортируются по возрастанию их ключей
        TreeMap<Integer, String> list = new TreeMap<>(people13);
        System.out.println(list);
        System.out.println(list.put(0, "Obama2"));
        System.out.println(list.get(2));
        System.out.println(list.entrySet());
        System.out.println("Количество эле в отображении list: " + list.size());
        for (Map.Entry<Integer, String> item:
                list.entrySet()) {
            System.out.println(item.getKey()+" "+item.getValue());
        }
        Set<Integer> k = list.keySet(); // все ключи
        System.out.println(k);
        Collection<String> v = list.values(); // все значения
        System.out.println(v);
        System.out.println(list.ceilingEntry(1));
        System.out.println(list.descendingKeySet()); // ключи в обратном порядке
        System.out.println(list.descendingMap()); // элементы в обратном порядке
        System.out.println(list.tailMap(1)); // элементы после 1, включая 1
        Map<Integer, String> listM = list.headMap(1); // элементы до 1, без 1
        System.out.println(listM);
        System.out.println(list.firstEntry()); // первый элемент
        System.out.println(list.lastEntry()); // последний элемент
        Map<Integer, Lichnost> list2 = new TreeMap<>(people14);
        System.out.println("Количество эле в отображении list2: " + list2.size());
        for (Map.Entry<Integer, Lichnost> j:
             list2.entrySet()) {
            System.out.println(j.getKey()+" "+j.getValue().getName());
        }
        System.out.println();

        // Итераторы
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList("Roxs", "Roger", "Belous"));
        Iterator<String> iter = list3.iterator();
        System.out.println(list3);
        while (iter.hasNext()) { // если есть следующий элемент - true, если нет - false
            System.out.println(iter.next()); // возвращает следующий элемент
        }

        System.out.println(list3);
        ListIterator<String> list_iter = list3.listIterator();
        while (list_iter.hasNext()) {
            list_iter.add("D");
            System.out.println(list_iter.next());
        }
        System.out.println(list3);
        while (list_iter.hasPrevious()) {
            System.out.println(list_iter.previous());
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
class PreComp implements Comparator<Lichnost> { // не нужно использовать в Lichnost(2) класс Comparable
    @Override
    public int compare(Lichnost o1, Lichnost o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
class Lichnost2 implements Comparable<Lichnost2> { // так в TreeSet можем добавлять объекты
    private String name;

    public Lichnost2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int compareTo(Lichnost2 g) { // Если этот метод возвращает отрицательное число,
        // то текущий объект будет располагаться перед тем, который передается через параметр.
        // Если метод вернет положительное число, то, наоборот, после второго объекта.
        // Если метод возвратит ноль, значит, оба объекта равны.
        return name.compareTo(g.getName());
//        return name.length()-g.getName().length();
    }
}
class Lichnost3 {
    private String name;
    private int age;

    public Lichnost3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
class PreNameComp implements Comparator<Lichnost3> {
    @Override
    public int compare(Lichnost3 o1, Lichnost3 o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
class PreAgeComp implements Comparator<Lichnost3> {
    @Override
    public int compare(Lichnost3 o1, Lichnost3 o2) {
        if (o1.getAge() > o2.getAge()) {
            return 1;
        }
        if (o1.getAge() < o2.getAge()) {
            return -1;
        }
        else {
            return 0;
        }
//        return o1.getAge() - o2.getAge(); можно так, только с числами
    }
}