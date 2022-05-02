package com.company;

public class Test {
    public static void main(String[] args){
        Person2 tom = new Person2("Tom");
        System.out.println(tom.hashCode());
        System.out.println(tom.hashCode2());
        System.out.println(tom.name.hashCode());
    }
}
class Person2 {
    String name;

    Person2(String name) {
        this.name = name;
    }

    public int hashCode2() {
        return 5*name.hashCode()/3;
    }
}
