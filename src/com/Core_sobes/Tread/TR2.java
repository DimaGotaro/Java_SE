package com.Core_sobes.Tread;

import java.util.Arrays;

public class TR2 {
    public static void main(String[] args) {
        System.out.println("Begin");
        Thread thread = new Thread(new Tread_1());
//        thread.start();
//        try {
//            Thread.sleep(300);
//            thread.interrupt();
//        } catch (InterruptedException e) {
//            System.out.println(Arrays.toString(e.getStackTrace()));
//        }
//        System.out.println();

        Thread thread1 = new Thread(new Tread_2());

        Tread_3 tread_3 = new Tread_3();
        Thread thread2 = new Thread(tread_3);

        thread2.start();
//        thread1.start();
//        thread.start();
        try {
            Thread.sleep(400);
//            thread1.interrupt();
//            thread.interrupt();
            tread_3.dis();
        } catch (InterruptedException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        System.out.println();
        System.out.println("End");
    }
}
class Tread_1 implements Runnable {

    @Override
    public void run() {
        int index = 0;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println(Thread.currentThread().getName() + " Перед 100 " + index);
                Thread.sleep(100);
                index++;
                System.out.println(Thread.currentThread().getName() + " После 100 " + index);
                System.out.println();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " IE");
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    System.out.println(stackTraceElement);
                }
//                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
class Tread_2 implements Runnable {

    @Override
    public void run() {
        int i = 0;
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " Перед 100 " + i);
                Thread.sleep(100);
                i++;
                System.out.println(Thread.currentThread().getName() + " После 100 " + i);
                System.out.println();
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " IE");
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                System.out.println(stackTraceElement);
            }

        }
    }
}
class Tread_3 implements Runnable {
    boolean isActive;

    public Tread_3() {
        this.isActive = true;
    }

    public void dis() {
        isActive = false;
    }

    /* без броска исключения */
    @Override
    public void run() {
        int i = 0;
        try {
            while (isActive) {
                System.out.println(Thread.currentThread().getName() + " Перед 100 " + i);
                Thread.sleep(100);
                i++;
                System.out.println(Thread.currentThread().getName() + " После 100 " + i);
                System.out.println();
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " IE");
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                System.out.println(stackTraceElement);
            }
        }
    }
}
