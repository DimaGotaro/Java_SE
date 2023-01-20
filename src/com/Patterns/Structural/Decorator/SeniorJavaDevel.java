package com.Patterns.Structural.Decorator;

public class SeniorJavaDevel extends Decorator {

    public SeniorJavaDevel(Devel devel) {
        super(devel);
    }

    @Override
    public String makeJob() {
        return super.makeJob() + " Code review.";
    }
}
