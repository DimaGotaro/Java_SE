package com.Core_sobes.Collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Coll_1 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("we");
        strings.add("lkdskf");
        strings.add("mnvm");
        strings.add("mnvm");
        strings.add("mnvm");
        strings.add("mnvm");
        strings.add("mnvm");
        strings.add("mnvm");
        strings.add("mnvm");
        strings.add("mnvm");
        strings.add("mnvmExp");
        strings.add("mnvmExp");
        strings.add("mnvmExp");
        strings.add("mnvmExp");
        strings.add("mnvmExp");
        strings.add("mnvmExp2");
        strings.trimToSize();
//        for (String string : strings) {
//            strings.remove(string);
//        }

        int u = 12 >> 1;
        System.out.println(u);

        System.out.println(strings);
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("lkdskf")) {
                iterator.remove();
            }
        }
        System.out.println(strings);

        PriorityQueue<String> strings1 = new PriorityQueue<>();
        strings1.add("2");
        strings1.add("1");
        strings1.add("3");
        strings1.add("4");
        System.out.println(strings1);
        while (strings1.peek() != null) {
            System.out.println(strings1.poll());
        }
        System.out.println(strings1);

        Integer[] f = new Integer[] {1, 4, 6, 2, 9, 4};
        PriorityQueue<Integer> integers = new PriorityQueue<>(List.of(f));
        integers.add(0);
        System.out.println(integers);
        System.out.println(integers.poll());
        integers.peek();
        integers.add(5);
        integers.offer(7);
        integers.contains(3);
        integers.remove();

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        System.out.println(linkedList.indexOf("1"));
        linkedList.add(1, "2.5");
        System.out.println(linkedList);


        HashMap<Exampl, Integer> hashMap = new HashMap<>(64);
        hashMap.put(new Exampl("dima"), 34);
        hashMap.put(new Exampl("dima2"), 35);
        hashMap.put(new Exampl("dima3"), 35);
        hashMap.put(new Exampl("dima4"), 35);
        hashMap.put(new Exampl("dima5"), 35);
        hashMap.put(new Exampl("dima6"), 35);
        hashMap.put(new Exampl("dima7"), 35);
        hashMap.put(new Exampl("dima8"), 36);
        hashMap.put(new Exampl("dima9"), 37);
        hashMap.values();
        for (Map.Entry<Exampl, Integer> examplIntegerEntry : hashMap.entrySet()) {

        }


        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("jj","ii");
        linkedHashMap.put("jj2","ii2");
        String jj2 = linkedHashMap.get("jj2");
//        linkedHashMap.forEach((s, s2) -> System.out.println(s + " " + s2));
        linkedHashMap.containsKey("jj");
        System.out.println(11 >> 1);

        ConcurrentHashMap<Integer, String> hashMap1 = new ConcurrentHashMap<>();
        hashMap1.put(45, "tyt1");
        hashMap1.put(46, "tyt2");
        hashMap1.put(47, "tyt3");
        hashMap1.get(46);

        Map<Exampl, Integer> examplIntegerMap = Collections.synchronizedMap(hashMap);

        TreeSet<String> treeSet = new TreeSet<>();

        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("1", "11");
        treeMap.put("2", "22");


        HashSet<String> strings2 = new HashSet<>();
        strings2.add("fff");
        strings2.contains("fff");
        strings2.remove("fff");

        Object d = new int[3];
        d.equals(new Object());
        d.hashCode();

        ArrayDeque<String> strings3 = new ArrayDeque<>();
        strings3.add("56");
        strings3.add("57");
        strings3.add("58");
        strings3.add("59");
        strings3.add("60");
        strings3.contains("59");
        strings3.offerFirst("yt");
        strings3.addFirst("323");
        strings3.poll();
        strings3.remove();
        strings3.addLast("asd");
        strings3.offerLast("sf");
        strings3.getFirst();
        strings3.getLast();
        strings3.peek();
        strings3.peekFirst();
        strings3.peekLast();
        strings3.poll();
        strings3.pollFirst();
        strings3.pollLast();
        strings3.push("trr");
        strings3.pop();
//        strings3.removeLast();
//        strings3.removeFirst();

        Integer integer = 254;
        Integer integer2 = 254;
        System.out.println(integer.equals(integer2));
        System.out.println(integer.hashCode());

        String r = "rtr";
        System.out.println(r.hashCode());

        Exampl bnm = new Exampl(null, null);
        Exampl exampl = new Exampl(null, null);
        System.out.println(bnm.equals(exampl));
        Exampl sd = new Exampl("sd", 1299);
        try {
            Exampl clone = (Exampl) sd.clone();
            System.out.println(sd.getF() == clone.f); // true
            System.out.println(sd.g == clone.g); // true
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
class Exampl implements Cloneable{
    String f;
    Integer g;

    public Exampl(String f) {
        this.f = f;
    }

    public Exampl(String f, Integer g) {
        this.f = f;
        this.g = g;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

//    @Override
//    public int hashCode() {
//        return 27;
//    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exampl exampl = (Exampl) o;

        /* с проверкой на null */
        if (this.f != null ? this.f.equals(exampl.f) : exampl.f == null &&
        this.g != null ? this.g.equals(exampl.g) : exampl.g == null) return true;

        /* без проверки на null*/
        return Objects.equals(f, exampl.f) && Objects.equals(g, exampl.g);
    }

    @Override
    public int hashCode() {
        return Objects.hash(f, g);
    }
}