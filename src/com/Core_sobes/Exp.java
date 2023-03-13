package com.Core_sobes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serial;

public class Exp {
    public void vvv() throws Exception {
        throw new Exception("error");
    }

    public Exp() throws ReflectiveOperationException, IOException {

    }
}
class F extends Exp{
    @Override
    public void vvv() throws IOException {
        throw new IOException("IOExc");
//        в переопределённом методе можем добавить исключение, такое же, либо ниже
//        по иерархии!
    }

    public F() throws Exception {
        /* обязаны добавить, такое же, либо выше по иерархии*/
        super();
    }
}
class G {
    public static void main(String[] args) throws Exception, MyExp {
        System.out.println("1");
//        new Exp().vvv();
        System.out.println("2");
        try {
//            new F().vvv();

            NullPointerException aNull = new NullPointerException("Null");
            System.out.println(aNull.getMessage());
            throw aNull;
            /* блок finally не будет выполнен. Завершение программы из-за ошибки */
//            System.exit(0);
//            while (true) {
//            }
        } catch (RuntimeException r) {
            System.out.println(r.getMessage());
        }

        System.out.println("3");
        try {
            throw new MyExp("MyExp");
        }
        catch (MyExp e) {
            System.out.println(e.getMessage());
        }
        System.out.println("End");
    }
}
class MyExp extends Exception {

    @Serial
    private static final long serialVersionUID = -3748776786673086228L;

    public MyExp(String message) {
        super(message);
    }
}
