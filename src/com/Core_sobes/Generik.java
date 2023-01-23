package com.Core_sobes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Generik {
    public static void main(String[] args) {
        ArrayList<A> list1 = new ArrayList<>();
        list1.add(new A());
        list1.add(new B());
        list1.add(new C());
        A a1 = list1.get(1);
        System.out.println(a1);
        ArrayList<B> list2 = new ArrayList<>();
        ArrayList<C> list3 = new ArrayList<>();

        /* Компилятор не знает коллекцию с каким дженериком мы сюда передадим.
        * В худшем случае мы передадим коллекцию с классом, указанным в дженерике,
        * который будет низшим в иерархии наследования. И тогда мы не сможем добавить
        * объект в коллекцию, который выше по иерархии, чем указанный класс в дженерике,
        * переданной коллекции. Компилятор не знает какой класс, является низшим в иерархии,
        * по отношению к классу указанному после extends.
        * Поэтому добавлять ничего нельзя. */
        List<? extends B> listEx = list3;
//        listEx.add(new C());
        B b = listEx.get(0);

        /* Компилятор знает что, класс указанный после super, это низший в иерархии класс
        * в дженерике коллекции, который мы сюда передадим. Поэтому компилятор позволяет
        * добавлять в коллекцию объекты с классом указанным после super. А значит можно
        * передать и объект, который наследуется от класса после super - потому что полиморфизм. */
        List<? super B> listSup = list1;
//        listSup.add(new A());
        listSup.add(new B());
        listSup.add(new C());
        Object object2 = listSup.get(0);

        S<? extends B> s = new S<C>();
//        s.setV(new C());
//        s.setV(new A());
//        s.setV(new B());
        B v = s.getV();

        S<? super B> s2 = new S<A>();
        s2.setV(new C());
        s2.setV(new B());
//        s2.setV(new A());
        Object v1 = s2.getV();

        B b1 = new B();
        A a = b1;
        B b2 = (B) a;

        A a2 = new A();
        B b3 = (B) a2;

        B b4 = (B) new A();

        try {
            Constructor<A> declaredConstructors = A.class.getDeclaredConstructor();
            declaredConstructors.setAccessible(true);
            A a5 = declaredConstructors.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
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
