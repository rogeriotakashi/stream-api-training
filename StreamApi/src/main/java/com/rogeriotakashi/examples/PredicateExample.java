package com.rogeriotakashi.examples;

import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        // (x) -> (bollean) - Predicate

//        Predicate predicate = new Predicate() {
//            @Override
//            public boolean test(Object o) {
//                if("Jose".equals("Rogerio")){
//                    return true;
//                }
//                return false;
//            }
//        };


        Predicate<String> predicate = nome -> nome.equals("Rogerio");

        boolean isRogerio = predicate.test("Rogerio");
        System.out.println("A variavel eh Rogerio?:"+isRogerio);

    }
}
