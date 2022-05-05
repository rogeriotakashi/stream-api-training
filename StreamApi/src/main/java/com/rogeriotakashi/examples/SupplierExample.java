package com.rogeriotakashi.examples;

import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        // () -> x
//        Supplier<String> supplier = new Supplier() {
//            @Override
//            public Object get() {
//                return "Xpto";
//            }
//        };
        Supplier<String> supplier = () -> "Rogerio";
        System.out.println(supplier.get());
    }
}
