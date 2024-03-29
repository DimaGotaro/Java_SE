package com.Patterns.Porojd.Singl;

public class Singleton {

    private static Singleton instance;

    private String log = "This log...\n\n";

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) instance = new Singleton();
        return instance;
    }

    public void addLog(String s) {
        log += s + "\n";
    }

    public String getLog() {
        return log;
    }
}
enum Singleton2 {
    /* Singleton ��� synchronized � ������ */
    SINGLETON_2;
}
class Singleton3 {
    /* Singleton ��� synchronized � ������ */
    private static volatile Singleton3 instance;

    public static Singleton3 getInstance() {

        Singleton3 localInstance = instance;

        if (localInstance == null) {
            synchronized (Singleton3.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Singleton3();
                }
            }
        }
        return localInstance;
    }
}
class Singleton4 {
    public static Singleton4 getInstance() {
        return Singl.singleton4;
    }
    private static class Singl{
        private static final Singleton4 singleton4 = new Singleton4();
    }
    private Singleton4() { }
    static class Sd {
        String f;
        static String g;
        static void d() {}
    }
}
class M {
    public static void main(String[] args) {
        Singleton4.Sd.d();
        String g = Singleton4.Sd.g;

        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
        System.out.println(Singleton.getInstance());
        System.out.println();

        Singleton.getInstance().addLog("1 log...");
        Singleton.getInstance().addLog("2 log...");
        Singleton.getInstance().addLog("3 log...");
        Singleton.getInstance().addLog("4 log...");

        System.out.println(Singleton.getInstance().getLog());

        Singleton2 singleton2 = Singleton2.SINGLETON_2;
    }
}
