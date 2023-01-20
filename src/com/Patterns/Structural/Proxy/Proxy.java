package com.Patterns.Structural.Proxy;

public class Proxy implements Proj{
    private String url;

    private RealProj realProj;

    public Proxy(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        if (realProj == null) {
            realProj = new RealProj(url);
        }
        System.out.println("Hello!");
        realProj.run();
        System.out.println("Good bye!");
    }
}
