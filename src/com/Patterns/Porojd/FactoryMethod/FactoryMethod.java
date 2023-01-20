package com.Patterns.Porojd.FactoryMethod;

public class FactoryMethod {
    public static void main(String[] args) {
        DevFact devFact = createDevFact("c++");
        Dev dev = devFact.createDev();

        dev.writeCode();
    }

    public static DevFact createDevFact(String s) {
        if (s.equalsIgnoreCase("java")) {
            return new JavaDevFact();
        } else if (s.equalsIgnoreCase("c++")) {
            return new CppDevFact();
        }
        else {
            throw new RuntimeException(s + " developer is unknown.");
        }
    }
}
