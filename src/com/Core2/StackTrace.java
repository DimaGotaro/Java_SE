package com.Core2;

public class StackTrace {
    public static void main(String[] args) {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            System.out.println(stackTraceElement);
        }

    }
}
