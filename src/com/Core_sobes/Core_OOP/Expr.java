package com.Core_sobes.Core_OOP;

public class Expr {
    public static void main(String[] args) {
        A a = new B();
        a.aaa();
    }
}
class A {
    void aaa() {
        System.out.println("aaa");
    }
}
class B extends A {
//    void aaa() {
//        super.aaa();
//        System.out.println("bbb");
//    }
}
