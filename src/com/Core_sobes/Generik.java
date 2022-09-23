package com.Core_sobes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Generik {
    public static void main(String[] args) {
        Generik generik = new Generik();

        generik.addM(new ArrayList<Object>());
        generik.addM(new ArrayList<Number>());
//        core_col.addM(new ArrayList<Integer>());
        System.out.println();

        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(5);
        generik.addM2(integers);
        ArrayList<Number> numbers = new ArrayList<Number>();
        numbers.add(5);
        generik.addM2(numbers);
//        core_col.addM2(new ArrayList<Object>());

        S<? extends B> s = new S<C>();
//        s.setV(new C());
        B v = s.getV();
        System.out.println(v);

        S<? super B> s2 = new S<A>();
        s2.setV(new C());
        s2.setV(new B());
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
