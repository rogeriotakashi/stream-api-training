package com.rogeriotakashi.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSpoilerExample {


    public static void main(String[] args) {
        List<String> lista = Arrays.asList("Rogerio","Jose","Watson");
//        Predicate<String> predicate = nome -> nome.equals("Rogerio");
        List<String> nomeFiltrado = lista.stream()
                                         .filter(nome -> nome.equals("Rogerio"))
                                         .collect(Collectors.toList());

        System.out.println(nomeFiltrado);

    }
}
