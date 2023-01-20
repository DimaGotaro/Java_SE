package com.Patterns.Poved.Chain_of_Responsibility;

public class SNotif extends Notif{

    public SNotif(int priority) {
        super(priority);
    }

    @Override
    void write(String m) {
        System.out.println("S" + m);
    }
}
