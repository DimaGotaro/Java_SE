package com.Patterns.Poved.Chain_of_Responsibility;

public class FNotif extends Notif{

    public FNotif(int priority) {
        super(priority);
    }

    @Override
    void write(String m) {
        System.out.println("F" + m);
    }
}
