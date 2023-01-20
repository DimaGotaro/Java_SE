package com.Patterns.Poved.Chain_of_Responsibility;

public class TNotif extends Notif{

    public TNotif(int priority) {
        super(priority);
    }

    @Override
    void write(String m) {
        System.out.println("T" + m);
    }
}
