package com.Patterns.Poved.Chain_of_Responsibility;

public abstract class Notif {
    private int priority;
    private Notif nextNotif;

    public Notif(int priority) {
        this.priority = priority;
    }

    public void setNextNotif(Notif nextNotif) {
        this.nextNotif = nextNotif;
    }

    public void notifMan(String m, int pr) {
        if (pr >= priority) {
            write(m);
        }
        if (nextNotif != null) {
            nextNotif.notifMan(m, pr);
        }
    }

    abstract void write(String m);
}
