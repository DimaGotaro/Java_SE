package com.Patterns.Structural.Proxy;

public class RealProj implements Proj {
    private String url;

    public RealProj(String url) {
        this.url = url;
        load();
    }

    private void load() {
        System.out.println("Loading proj " + url + "...");
    }

    @Override
    public void run() {
        System.out.println("Run proj " + url + "...");
    }
}
