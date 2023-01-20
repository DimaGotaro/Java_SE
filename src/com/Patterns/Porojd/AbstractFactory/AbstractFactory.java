package com.Patterns.Porojd.AbstractFactory;

import com.Patterns.Porojd.AbstractFactory.banking.BankingFact;

public class AbstractFactory {
    public static void main(String[] args) {
        Dev dev = new BankingFact().getDev();
        Test test = new BankingFact().getTest();
        PM pm = new BankingFact().getPM();

        dev.writeCod();
        test.testCode();
        pm.manageProject();
    }
}
