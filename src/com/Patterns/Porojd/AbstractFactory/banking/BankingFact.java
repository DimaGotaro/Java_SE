package com.Patterns.Porojd.AbstractFactory.banking;

import com.Patterns.Porojd.AbstractFactory.Dev;
import com.Patterns.Porojd.AbstractFactory.PM;
import com.Patterns.Porojd.AbstractFactory.ProjectFactory;
import com.Patterns.Porojd.AbstractFactory.Test;

public class BankingFact implements ProjectFactory {
    @Override
    public Dev getDev() {
        return new JavaDev();
    }

    @Override
    public Test getTest() {
        return new QATest();
    }

    @Override
    public PM getPM() {
        return new PMDev();
    }
}
