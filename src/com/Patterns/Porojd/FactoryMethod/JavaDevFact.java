package com.Patterns.Porojd.FactoryMethod;

public class JavaDevFact implements DevFact{
    @Override
    public Dev createDev() {
        return new JavaDev();
    }
}
