package com.Patterns.Porojd.Builder;

public class Builder {
    public static void main(String[] args) {
        WebSite webSite = new Director(new VCWebSite()).createWebSite();
        WebSite webSite1 = new Director(new EWebSite()).createWebSite();

        System.out.println(webSite);
        System.out.println(webSite1);
    }
}
