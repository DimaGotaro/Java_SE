package com.company;

public class Main7 {
    public static void main(String[] args) {
        // Многопоточное программирование
        // Класс Thread
        Thread t = Thread.currentThread(); // получаем главный поток
        System.out.println(t.getName());
        System.out.println(t.getThreadGroup().getName());
        System.out.println(t); // имя потока, приоритет потока, имя группы потоков
        System.out.println();

        // Создание и выполнение потоков
        // Для создания нового потока мы можем создать новый класс, либо наследуя его от класса Thread,
        // либо реализуя в классе интерфейс Runnable.
        // Наследование от класса Thread
        System.out.println("Главный поток запущен..."); // поток выполнения этого кода
        new S_Thread("S_Thread").start(); // запуск потока, в конструктор передали имя потока, start вызывает run
        System.out.println();

        // запуск нескольких потоков
        for (int i = 0; i < 6; i++) {
            new S_Thread("S_Thread " + i).start();
        }

        // Ожидание завершения потока
        S_Thread gr = new S_Thread("S_Thread_2");
        gr.start();
        try {
            gr.join(); // главный поток будет ждать завершения gr, первым завершится поток gr, потом главный поток.
            // Для всех дочерних потоков нужно вызывать join, что бы главный поток закрылся последним
            // пока не закроется gr, новый поток не запустится
        }
        catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        // Реализация интерфейса Runnable
        Thread gr2 = new Thread(new M_Thread(), "M_Thread"); // создаём объект Thread и наш класс только указываем
        gr2.start();
        try {
            gr2.join();
        }
        catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        M_Thread gr4 = new M_Thread();

        /*Runnable grR3 = () -> {
            System.out.println(Thread.currentThread().getName() + " started...");
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println(Thread.currentThread().getName() + " finished...");
        };
        Thread gr3 = new Thread(grR3, "L_Thread");*/

        // сразу, без отдельной переменной Rummable
        Thread gr3 = new Thread(() -> { // с помощью лямбд переопределяем метод сразу
            System.out.println(Thread.currentThread().getName() + " started...");
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println(Thread.currentThread().getName() + " finished...");
        }, "L_Thread");
        gr3.start();
        try {
            gr3.join();
        }
        catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        // Завершение и прерывание потока
        // Завершение потока
        B_Thread gr5 = new B_Thread();
        Thread gr6 = new Thread(gr5, "B_Thread");
        gr6.start();
        System.out.println("После start");
        try {
            System.out.println("Перед 1100");
            Thread.sleep(1100);
            System.out.println("После 1100");
            gr5.dis();
            System.out.println("После dis");
            Thread.sleep(1000);
//            gr6.join();
            // если закрыть все join, то "Главный поток закрыт..." всё равно выведет после всех потоков, потому что
            // мы останавливаем его, то есть задействуем в коде
        }
        catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        A_Thread gr7 = new A_Thread("A_Thread");
        gr7.start();
        try {
            Thread.sleep(10);
            gr7.interrupt(); // прерывает цикл
            Thread.sleep(10);
        }
        catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

//        A2_Thread grR8 = new A2_Thread();
//        Thread gr8 = new Thread(grR8, "A2_Thread");
//        gr8.start();
//        try {
//            Thread.sleep(10);
//            gr8.interrupt();
//            Thread.sleep(10);
//        }
//        catch (InterruptedException ex) {
//            System.out.println(ex.getMessage());
//        }

        A3_Thread gr9 = new A3_Thread("A3_Thread");
        gr9.start();
        try {
            Thread.sleep(10);
            gr9.interrupt(); // прерывает цикл
            Thread.sleep(10);
        }
        catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        System.out.println();
        System.out.println("Главный поток закрыт...");
    }
}
class S_Thread extends Thread { // создали класс для потока, который наследует Thread
    S_Thread(String name) {
        super(name); // имя потока передали в конструктор базового класса
    }
    public void run() { // код этого метода и есть код который будет выполняться в потоке
        System.out.println(Thread.currentThread().getName() + " started...");
        try {
            Thread.sleep(500); // останавливаем поток S_Thread
        }
        catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " finished...");
    }
}
class M_Thread implements Runnable { // конструктор переопределять нельзя, переопределяем только метод run
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started...");
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " finished...");
    }
}
class B_Thread implements Runnable {
    private boolean isAct;
    B_Thread() {
        isAct = true;
    }
    void dis() {
        isAct = false;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started...");
        int count = 1;
        while (isAct) {
            System.out.println("Loop: " + count++);
            try {
                Thread.sleep(400);
            }
            catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished...");
    }
}
class A_Thread extends Thread {
    A_Thread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started...");
        int count = 1;
        while (!isInterrupted()) { // условие - поток не может быть остановлен, потому что он итак остановлен
            System.out.println("Loop" + count++);
            try {
                Thread.sleep(5); // без Thread.sleep пример ниже
            }
            catch (InterruptedException ex) {
                System.out.println(getName() + " has been interrupted");
                // 1 способ
//                System.out.println(isInterrupted());
//                interrupt(); // повторно сбрасываем состояние
                // 2 способ
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished...");
    }
}
class A2_Thread implements Runnable { // без Thread.sleep, как выше
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started...");
        int count = 1;
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Loop" + count++); // будет выводить пока не закончится Thread.sleep
        }
        System.out.println(Thread.currentThread().getName() + " finished...");
    }
}
class A3_Thread extends Thread { // 3 способ, если цикл обернуть в try...catch
    A3_Thread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started...");
        int count = 1;
        try {
            while (!isInterrupted()) {
                System.out.println("Loop" + count++);
                Thread.sleep(5);
            }
        }
        catch (InterruptedException ex) {
            System.out.println(getName() + " has been interrupted");
        }
        System.out.println(Thread.currentThread().getName() + " finished...");
    }
}
