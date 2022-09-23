package com.Core_sobes;

public class StackTrace {
    public static void main(String[] args) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement f :
                stackTraceElements) {
            System.out.println(f);
        }
    }
}
