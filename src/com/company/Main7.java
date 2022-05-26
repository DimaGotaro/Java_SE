package com.company;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

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
//        S_Thread gr4 = new S_Thread("S2_Thread");
//        gr4.start(); // без join открывается и закрывается после "Главный поток закрыт..."

        // Синхронизация потоков. Оператор synchronized
        ComRes dt = new ComRes();
        for (int i = 1; i < 4; i++) {
            Thread dt2 = new Thread(new Com_Thread(dt));
            dt2.setName("Com_Thread " + i);
            dt2.start();
            try {
                dt2.join();
            }
            catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println();

        // можно синхронизировать метод
        ComRes2 dt3 = new ComRes2();
        for (int i = 1; i < 4; i++) {
            Thread dt4 = new Thread(new Com_Thread2(dt3), "Com_Thread2 " + i);
            dt4.start();
            try {
                dt4.join();
            }
            catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println();

        // Методы wait и notify
        // задача с магазином, wait насильно прерывает synchronized
        Magazin dt5 = new Magazin();
        Pokyp dt6 = new Pokyp(dt5);
        Zavod dt7 = new Zavod(dt5);
        Thread dt8 = new Thread(dt7); // Zavod
        Thread dt9 = new Thread(dt6); // Pokyp
        dt9.start(); // Pokyp
        dt8.start(); // Zavod
        try {
            dt8.join();
            dt9.join();
        }
        catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        // Семафоры
//        Semaphore sem = new Semaphore(2);
//        Peremen per = new Peremen();
//        new Thread(new Isp_Sem(per, sem, "Isp_Sem 1")).start();
//        new Thread(new Isp_Sem(per, sem, "Isp_Sem 2")).start();
//        new Thread(new Isp_Sem(per, sem, "Isp_Sem 3")).start();
//        System.out.println();

        // Философы
//        Semaphore sem2 = new Semaphore(2); // за столом максимум 2 философа
//        for (int i = 0; i < 6; i++) { // 5 философов всего
//            Thread dt11 = new Thread(new Filosof(sem2, "Философ " + i, 2, i)); // t - приёмы пищи
//            dt11.start();
//        }
//        System.out.println();

        // Обмен между потоками. Класс Exchanger
        // передача сообщения между двумя классами
        Exchanger<String> cx = new Exchanger<String>();
        new Thread(new PutEx(cx)).start();
        new Thread(new GetEx(cx)).start();
//        new Thread(new GetEx2(cx)).start(); // только два класса!

        // Класс Phaser
        Phaser ph = new Phaser(1);
        new Thread(new K_Phaser(ph, "K_Phaser 1")).start();
        new Thread(new K_Phaser(ph, "K_Phaser 2")).start();
        // заканчивается фаза 0
        int phase = ph.getPhase();
        ph.arriveAndAwaitAdvance(); // начинаем фазу 1
        System.out.println("Фаза " + phase + " завершена");
        // заканчивается фаза 1
        phase = ph.getPhase();
        ph.arriveAndAwaitAdvance(); // начинаем фазу 2
        System.out.println("Фаза " + phase + " завершена");
        // заканчивается фаза 2
        phase = ph.getPhase();
        ph.arriveAndAwaitAdvance(); // начинаем фазу 3
        System.out.println("Фаза " + phase + " завершена");
        ph.arriveAndDeregister(); // отмена регистраций всех участников

        // Блокировки. ReentrantLock
        Chil cx2 = new Chil();
        ReentrantLock cx3 = new ReentrantLock();
        for (int i = 0; i < 4; i++) {
            Thread cx4 = new Thread(new Look_Turead(cx2, cx3), "Look_Turead " + i);
            cx4.start();
        }

        // Условия в блокировках
        Magazin2 cx7 = new Magazin2();
        Thread cx5 = new Thread(new Pokyp2(cx7));
        Thread cx6 = new Thread(new Zavod2(cx7));
        cx5.start();
        cx6.start();
        try {
            cx5.join();
            cx6.join();
        }
        catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

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
        System.out.println(getName() + " started...");
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
        System.out.println(getName() + " finished...");
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
        System.out.println(getName() + " started...");
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
        System.out.println(getName() + " finished...");
    }
}
// синхронизация переменной
class ComRes {
    int x = 0;
}
class Com_Thread implements Runnable {
    ComRes res;
    Com_Thread(ComRes res) {
        this.res = res;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started...");
        synchronized (res) { // без метода res некорректно работает
            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " Loop " + res.x);
                res.x++;
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException ex) {
                    System.out.println(Thread.currentThread().getName() + " has been interrupted");
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished...");
    }
}
// можно синхронизировать метод
class ComRes2 {
    int x = 0;

    synchronized void incr() { // можно синхронизировать метод
        System.out.println(Thread.currentThread().getName() + " started...");
        x = 1;
        for (int i = 1; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " Loop " + x);
            x++;
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ex) {
                System.out.println(Thread.currentThread().getName() + " has been interrupted");
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished...");
    }
}
class Com_Thread2 implements Runnable {
    ComRes2 res;
    Com_Thread2(ComRes2 res) {
        this.res = res;
    }

    @Override
    public void run() {
        res.incr(); // ссылка на синхронизированный метод
    }
}
// Методы wait и notify
// задачка с магазином
class Magazin {
    int prodyct = 0;
    synchronized void get() {
        while (prodyct < 1) {
            try {
                wait();
            }
            catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        prodyct--;
        System.out.println("Покупатель забрал 1 товар");
        System.out.println("На складе осталось товара: " + prodyct);
        notify();
    }
    synchronized void put() {
        while (prodyct >= 3) {
            try {
                wait();
            }
            catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        prodyct++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("На складе осталось товара: " + prodyct);
        notify();
    }
}
class Pokyp implements Runnable {
    Magazin mag;
    Pokyp(Magazin mag) {
        this.mag = mag;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            mag.get();
        }
    }
}
class Zavod implements Runnable {
    Magazin mag;
    Zavod(Magazin mag) {
        this.mag = mag;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            mag.put();
        }
    }
}
// Семафоры
class Peremen {
    int x = 0;
}
class Isp_Sem implements Runnable {
    Peremen per;
    Semaphore sem;
    String name;
    Isp_Sem(Peremen per, Semaphore sem, String name) {
        this.per = per;
        this.sem = sem;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " ожидает подключения");
            sem.acquire();
            per.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.println(this.name + ": " + per.x);
                per.x++;
                Thread.sleep(100);
            }
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " освобождает разрешение");
        sem.release();
    }
}
class Filosof implements Runnable {
    String name;
    Semaphore sem;
    int t; // кол-во приёмов пищи
    int id; // i в цикле потоков, кол-во философов

    Filosof(Semaphore sem, String name, int t, int id) {
        this.sem = sem;
        this.name = name;
        this.t = t;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= t; i++) {
                sem.acquire();
                System.out.println(name + " сел жрать");
                if (id%2 == 0) { // чётный философ
                    Thread.sleep(150); // философ жрёт
                }
                else { // нечётный философ
                    Thread.sleep(200); // философ жрёт
                }
                System.out.println(name + " закончил жрать");
                sem.release();
                Thread.sleep(400); // философ гуляет
            }
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
// Обмен между потоками. Класс Exchanger
class PutEx implements Runnable {
    Exchanger<String> ex;
    String mes;
    PutEx(Exchanger<String> ex) {
        this.ex = ex;
        mes = "Hello priblyda";
    }

    @Override
    public void run() {
        try {
            mes = ex.exchange(mes);
            System.out.println("Сообщение отправлено - " + mes);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
class GetEx implements Runnable {
    Exchanger<String> ex;
    String mes;
    GetEx(Exchanger<String> ex) {
        this.ex = ex;
        mes = "Hello лох";
    }

    @Override
    public void run() {
        try {
            mes = ex.exchange(mes);
            System.out.println("Сообщение получено - " + mes);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
class GetEx2 implements Runnable {
    Exchanger<String> ex;
    String mes;
    GetEx2(Exchanger<String> ex) {
        this.ex = ex;
        mes = "Hello fanboy";
    }

    @Override
    public void run() {
        try {
            mes = ex.exchange(mes);
            System.out.println("Сообщение получено - " + mes);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
// Класс Phaser
class K_Phaser implements Runnable {
    Phaser ph;
    String name;
    K_Phaser(Phaser ph, String name) {
        this.ph = ph;
        this.name = name;
        ph.register();
    }
    @Override
    public void run() {
        System.out.println(name + " выполняет фазу " + ph.getPhase());
        ph.arriveAndAwaitAdvance();
        try {
            Thread.sleep(200);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " выполняет фазу " + ph.getPhase());
        ph.arriveAndAwaitAdvance();
        try {
            Thread.sleep(200);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " выполняет фазу " + ph.getPhase());
        ph.arriveAndDeregister();
    }
}
// Блокировки. ReentrantLock
class Chil {
    int x = 0;
}
class Look_Turead implements Runnable {
    Chil res;
    ReentrantLock loock;
    Look_Turead(Chil res, ReentrantLock loock) {
        this.res = res;
        this.loock = loock;
    }

    @Override
    public void run() {
        loock.lock();
        try {
            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " Loop " + res.x);
                res.x++;
                Thread.sleep(100);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            loock.unlock();
        }
    }
}
// Условия в блокировках
class Magazin2 {
    int prod = 0;
    ReentrantLock ret;
    Condition con;
    Magazin2() {
        ret = new ReentrantLock();
        con = ret.newCondition();
    }
    public void get() {
        ret.lock();
        try {
            while (prod < 1) {
                con.await();
            }
            prod--;
            System.out.println("Покупатель забрал 1 товар");
            System.out.println("На складе осталось товара: " + prod);
            con.signalAll();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            ret.unlock();
        }
    }
    public void put() {
        ret.lock();
        try {
            while (prod >= 3) {
                con.await();
            }
            prod++;
            System.out.println("Производитель добавил 1 товар");
            System.out.println("На складе осталось товара: " + prod);
            con.signalAll();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            ret.unlock();
        }
    }
}
class Pokyp2 implements Runnable {
    Magazin2 mag;
    Pokyp2(Magazin2 mag) {
        this.mag = mag;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            mag.get();
        }
    }
}
class Zavod2 implements Runnable {
    Magazin2 mag;
    Zavod2(Magazin2 mag) {
        this.mag = mag;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            mag.put();
        }
    }
}