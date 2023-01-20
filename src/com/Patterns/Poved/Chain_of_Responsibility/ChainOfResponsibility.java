package com.Patterns.Poved.Chain_of_Responsibility;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Notif notif1 = new FNotif(1);
        Notif notif2 = new SNotif(2);
        Notif notif3 = new TNotif(3);

        notif1.setNextNotif(notif2);
        notif2.setNextNotif(notif3);

        notif2.notifMan("Message", 3);
    }
}
