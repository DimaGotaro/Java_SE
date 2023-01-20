package com.Patterns.Structural.Decorator;

public class Decorator implements Devel{
    Devel devel;

    public Decorator(Devel devel) {
        this.devel = devel;
    }

    @Override
    public String makeJob() {
        return devel.makeJob();
    }
}
