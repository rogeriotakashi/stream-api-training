package com.rogeriotakashi.examples;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
        // (T) -> (R)
        // (x) -> (y)
//        Function<Boolean, Integer> function = new Function<Boolean, Integer>() {
//            @Override
//            public Integer apply(Boolean aBoolean) {
//                if(aBoolean){
//                    return 1;
//                }
//                return 0;
//            }
//        };

        Function<Boolean, Integer> function = aBoolean -> aBoolean ? 1 : 0;

        Integer result = function.apply(Boolean.TRUE);
        System.out.println("Resultado eh:" + result);
    }
}
