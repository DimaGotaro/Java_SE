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
//        � ��������������� ������ ����� �������� ����������, ����� ��, ���� ����
//        �� ��������!
    }

    public F() throws Exception {
        /* ������� ��������, ����� ��, ���� ���� �� ��������*/
        super();
    }
}
class G {
    public static void main(String[] args) throws Exception {
        System.out.println("1");
//        new Exp().vvv();
        System.out.println("2");
        try {
            new F().vvv();

            /* ���� finally �� ����� ��������. ���������� ��������� ��-�� ������ */
//            System.exit(0);
//            while (true) {
//            }
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.out.println("3");
        try {
            throw new MyExp("MyEror");
        }
        catch (MyExp e) {
            e.printStackTrace();
        }
        System.out.println("4");
    }
}
class MyExp extends Exception {

    @Serial
    private static final long serialVersionUID = -3748776786673086228L;

    public MyExp(String message) {
        super(message);
    }
}
