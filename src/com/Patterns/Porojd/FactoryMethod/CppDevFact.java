package com.Patterns.Porojd.FactoryMethod;

public class CppDevFact implements DevFact{
    @Override
    public Dev createDev() {
        return new CppDev();
    }
}
