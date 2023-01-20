package com.Core_sobes.Core;

public class Core_2 extends Core_11{
    public static void main(String[] args) {
        Core_11 core_11 = new Core_11();
        String a = core_11.a;
        String b = core_11.b;
        String c1 = core_11.c1;
//        core_11.d // d - private
        Core_1 core_1 = new Core_1() {
            public void trata() {
                System.out.println("Тратата");
            }
        };

        core_11.abc();
    }
}
