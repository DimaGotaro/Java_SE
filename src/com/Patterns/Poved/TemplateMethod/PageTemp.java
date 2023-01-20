package com.Patterns.Poved.TemplateMethod;

public abstract class PageTemp {

    void runP() {
        System.out.println("Header");
        contentP();
        System.out.println("Footer");
    }

    abstract void contentP();
}
