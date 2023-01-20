package com.Core_sobes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Generik {
    public static void main(String[] args) {
        Generik generik = new Generik();

        generik.addM(new ArrayList<>());
        generik.addM(new ArrayList<>());
        System.out.println();

        List<? super Number> list = new ArrayList<>();
        list.add(5.5d);
        Object object = list.get(0);
        System.out.println(object);

        List<? extends Number> list2 = new ArrayList<>();
        Number number = list2.get(0);
        System.out.println(number);
//        list2.add(new Object());
//        list2.add(6);

//        list2 = list;
//        list = list2;
//        List<? extends Number> list3 = list;
        List<? extends Number> list4 = list2;

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(5);
        generik.addM2(integers);
//        generik.addM(integers);
        ArrayList<Object> numbers2 = new ArrayList<>();
//        generik.addM2(numbers2);
        generik.addM(numbers2);
        ArrayList<Number> numbers = new ArrayList<>();
        numbers.add(5);
        generik.addM2(numbers);

        /* не можем положить в коллекцию Integer объект Number */
//        ArrayList<Number> numbers1 = integers;
//        ArrayList<Integer> integers1 = numbers;

        List<? extends Number> list5 = integers;
        Number number1 = list5.get(0);
//        list5.add(45);
        List<? extends Number> list7 = numbers;
//        List<? extends Number> list7 = numbers2;
        List<? super Number> list6 = numbers2;
        list6.add(67);
        list6.add(67.5);
//        list6.add(new Object());

        S<? extends B> s = new S<C>();
//        s.setV(new C());
//        s.setV(new A());
//        s.setV(new B());
        B v = s.getV();
        System.out.println(v);

        S<? super B> s2 = new S<A>();
        s2.setV(new C());
        s2.setV(new B());
//        s2.setV(new A());
        Object v1 = s2.getV();
        System.out.println(v1);

        try {
            Constructor<A> declaredConstructors = A.class.getDeclaredConstructor();
            declaredConstructors.setAccessible(true);
            A a = declaredConstructors.newInstance();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void addM(List<? super Number> list) {
        list.add(5.5d);
        Object object = list.get(0);
        System.out.println(object);
    }

    public void addM2(List<? extends Number> list) {
        Number number = list.get(0);
        System.out.println(number);
//        list.add(new Object());
//        list.add(3);
    }
}
class A {}
class B extends A {}
class C extends B {}
class S<V> {
    V v;

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
}
