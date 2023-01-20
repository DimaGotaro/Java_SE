package com.Core_sobes.Tread;

public class TreadMag {
    public static void main(String[] args) {
        System.out.println("Начало");

        Magas magas = new Magas();
        int j = 7; // кол-во добавления и покупок товара

        Thread thread = new Thread(new Pokyp(magas, j));
        Zavod zavod = new Zavod(magas, j);
        thread.start();
        zavod.start();
        /* Два потока работают с мьютексом одного объекта, пока первый поток не закончит
        * работу или не вызовет wait() и не переведёт мьютекс в режим - свободно,
        * второй поток работать не начнёт.
        * Когда начнёт, переведёт мьютекс в режим - занято и будет делать свою работу,
        * пока не закончит или не словит wait().
        * Если поток получил wait() он не начнёт работу, пока на мьютексе этого же объекта
        * не будет вызван notify(), который пробудит поток и первый поток, вызвавший notify()
        * не закончит работу или словит wait() - переведёт мьютекс в режим - свободно */
        System.out.println("Конец");
    }
}
class Magas {
    int index;

    public synchronized void dobav() {
        while (index >= 4) {
            try {
                System.out.println("Wait - dobav");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        index++;
        System.out.println("На склад довавлен 1 товар");
        System.out.println("Количество товара на складе: " + index);
        System.out.println();
        if (index >= 3) {
            System.out.println("Notify - dobav");
            notify();
        }
    }

    public synchronized void otprav() {
        while (index <= 0) {
            try {
                System.out.println("Wait - otprav");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        index--;
        System.out.println("Со склада забран 1 товар");
        System.out.println("Количество товара на складе: " + index);
        System.out.println();
        if (index <= 0) {
            System.out.println("Notify - otprav");
            notify();
        }
    }

    public synchronized void open() {
        notify();
    }
}
class Pokyp implements Runnable {
    Magas magas;
    int j;

    public Pokyp(Magas magas, int j) {
        this.magas = magas;
        this.j = j;
    }

    @Override
    public void run() {
        for (int i = 0; i < j; i++) {
            magas.otprav();
        }
        magas.open();
    }
}
class Zavod extends Thread {
    Magas magas;
    int j;

    public Zavod(Magas magas, int j) {
        this.magas = magas;
        this.j = j;
    }

    @Override
    public void run() {
        for (int i = 0; i < j; i++) {
            magas.dobav();
        }
        magas.open();
    }
}
