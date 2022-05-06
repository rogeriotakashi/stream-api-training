package com.rogeriotakashi.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        // Não é comum declarar Streams!!! Não seria o ideal
        //Stream<String> stringStream = Stream.of("Rogerio", "Jose", "Watson");
        List<Pessoa> pessoas = Arrays.asList(new Pessoa("Rogerio", 25),
                                             new Pessoa("Jose", 22),
                                             new Pessoa("Watson", 19));

//        List<Integer> collect = pessoas.stream()
//                                       .map(pessoa -> pessoa.idade) // Operação Intermediaria
//                                       .collect(Collectors.toList());// Operação Término
        Stream<Pessoa> pessoaStream = pessoas.stream()
                                             .filter(pessoa -> pessoa.idade < 22);

        List<Pessoa> collect1 = pessoas.stream()
                                        .filter(pessoa -> pessoa.idade < 22) // Operação Intermediaria
                                        .collect(Collectors.toList());

        System.out.println(pessoas);
        System.out.println(collect1);
    }
}

class Pessoa {
    String nome;
    Integer idade;

    public Pessoa(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}
