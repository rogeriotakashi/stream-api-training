package com.rogeriotakashi.examples;

import com.rogeriotakashi.examples.interfaces.Consumidor;
import com.rogeriotakashi.examples.vo.Pessoa;

public class ConsumidorExample {

    public static void main(String[] args) {
//        Consumidor consumidor = new Consumidor() {
//            @Override
//            public void aplicar(Pessoa pessoa) {
//                System.out.println("Nome da pessoa eh "+ pessoa.getNome());
//            }
//        };

        // (x) -> ( ) - Consumidor
        Consumidor consumidor = p -> System.out.println("Nome da pessoa eh "+ p.getNome());
        Consumidor consumidor2 = p -> System.out.println("Nome da pessoa eh "+ p.getNome().toUpperCase());


        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Jose");

        consumidor.aplicar(pessoa);
        consumidor2.aplicar(pessoa);
    }
}
