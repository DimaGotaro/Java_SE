package com.Core_sobes;

import java.util.concurrent.TimeUnit;

public class Solution {
    public static void main(String[] args) {
        new Child();
    }
}

class Parent {
    private static final String staticName = initName();

    private final String instanceAccount = initAccount();

    static {
        //static block #1
        System.err.println("4. Initializing: static block #1 (Parent)");
        sleep();
    }

    private static final int staticAge = initAge();

    static {
        //static block #2
        System.err.println("6. Initializing: static block #2 (Parent)");
        sleep();
    }

    {
        //instance initialize block #1
        System.err.println("12. Initializing: instance block #1 (Parent)");
        sleep();
    }

    private final int instanceTotal = initTotal();

    {
        //instance initialize block #2
        System.err.println("14. Initializing: instance block #2 (Parent)");
        sleep();
    }

    public Parent() {
        System.err.println("15. Executing body of Parent constructor (Parent)");
        sleep();
    }

    private String initAccount() {
        System.err.println("11. Initializing: instance variable - instanceAccount (Parent)");
        sleep();
        return "Angela";
    }

    private int initTotal() {
        System.err.println("13. Initializing: instance variable - instanceTotal (Parent)");
        sleep();
        return 100;
    }

    private static String initName() {
        System.err.println("3. Initializing: static - name (Parent)");
        sleep();
        return "Angela";
    }

    private static int initAge() {
        System.err.println("5. Initializing: static - age (Parent)");
        sleep();
        return 25;
    }

    protected static void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
        }
    }
}

class Child extends Parent {
    private static final String address = initAddress();

    private final String instanceKey = initKey();

    static {
        //static block #3
        System.out.println("8. Initializing: static block #3 (Child)");
        sleep();
    }

    private static final int count = initCount();

    static {
        //static block #4
        System.out.println("10. Initializing: static block #4 (Child)");
        sleep();
    }

    {
        //instance initialize block #3
        System.out.println("17. Initializing: instance block #3 (Child)");
        sleep();
    }

    private final int instanceLength = initLength();

    {
        //instance initialize block #4
        System.out.println("19. Initializing: instance block #4 (Child)");
        sleep();
    }

    public Child() {
        System.out.println("20. Executing body of Child constructor (Child)");
        sleep();
    }

    // порядок методов не имеет значения, они отработают тогда и только тогда
    // когда будут вызваны явно в коде

    private String initKey() {
        System.out.println("16. Initializing: instance variable - instanceKey (Child)");
        sleep();
        return "Magic Key";
    }

    private int initLength() {
        System.out.println("18. Initializing: instance variable - instanceLength (Child)");
        sleep();
        return 20;
    }

    private static String initAddress() {
        System.out.println("7. Initializing: static - String address (Child)");
        sleep();
        return "Angela";
    }

    private static int initCount() {
        System.out.println("9. Initializing: static - int count ");
        sleep();
        return 25;
    }
}
