package com.rogeriotakashi.examples;

import com.rogeriotakashi.examples.interfaces.RunnableImplementation;

public class RunnableFunctionalInterfaceExample {

    public static void main(String[] args) {

        System.out.println("Hello World");
        // () -> ()
        // There is 3 ways to implement Runnable
        // 1 - Explicit class instantiation
//        Runnable runnable1 = new RunnableImplementation();

        // 2 - Java 7 (Anonymous Class):
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello from Runnable");
//            }
//        };

        // 3 - Java 8: Using lambda expressions and @FunctionalInterface
        // lambda expression = funções anonimas
        Runnable runnable = () -> System.out.println("Hello from Runnable");
        runnable.run();

//
//        Thread thread = new Thread(runnable);
//        thread.start(); // Thread 1

        System.out.println("Seguindo o fluxo");
    }
}

