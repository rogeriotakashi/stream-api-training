package com.rogeriotakashi.examples;

import com.rogeriotakashi.examples.interfaces.Consumidor;
import com.rogeriotakashi.examples.interfaces.ConsumidorString;
import com.rogeriotakashi.examples.vo.Pessoa;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ConsumerExample {

    public static void main(String[] args) {
        // (x) -> ( ) - Consumidor
        Consumer<String> consumer = nome -> System.out.println("Nome da pessoa eh "+ nome);
        consumer.accept("Teste");

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Jose");

        Consumer<Pessoa> consumer2 = p -> System.out.println("Nome da pessoa eh "+ p.getNome());
        consumer2.accept(pessoa);

        // Consumer, Predicate, Supplier, Function and Runnable
    }
}
