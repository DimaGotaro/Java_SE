package com.Patterns.Poved.TemplateMethod;

public class TemplateMethod {
    public static void main(String[] args) {
        PageTemp pageTemp = new WelcomeP();
        PageTemp pageTemp1 = new NewsP();

        pageTemp.runP();
        System.out.println();
        pageTemp1.runP();
    }
}
