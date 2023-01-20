package com.Patterns.Structural.Decorator;

public class JavaTM extends Decorator {

    public JavaTM(Devel devel) {
        super(devel);
    }

    @Override
    public String makeJob() {
        return super.makeJob() + " Send report.";
    }
}
