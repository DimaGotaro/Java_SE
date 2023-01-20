package com.Patterns.Porojd.AbstractFactory;

public interface ProjectFactory {
    Dev getDev();
    Test getTest();
    PM getPM();
}
