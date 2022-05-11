package com.rogeriotakashi.examples;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ConsumerExampleTest {

    List<Pessoa> pessoas;

    @BeforeEach
    public void setup() {
        pessoas = Arrays.asList(
                new Pessoa("Rogerio",25, 'M', true),
                new Pessoa("Gabriel",18, 'M', false),
                new Pessoa("Thais",35, 'F', false),
                new Pessoa("Jose",19, 'M', false),
                new Pessoa("Roberto",40, 'M', true),
                new Pessoa("Renato",10, 'M', false),
                new Pessoa("Joaquim",85, 'M', false),
                new Pessoa("Dona Benta",90, 'F', false),
                new Pessoa("George",16, 'M', false),
                new Pessoa("Jessica",23, 'F', false),
                new Pessoa("Elon Musk",43, 'M', true)
        );
    }

    @Test
    public void filtrarSexoMasculino() {
//        List<Pessoa> result = null; // Colete o resultado dentro dessa variavel ou renomei ela
        // Implementar solução



        // Estilo imperativo
        // Mutavel
        List<Pessoa> result = new ArrayList<>(); // Acumulador
        for(int i = 0; i < pessoas.size(); i++) {
            if(pessoas.get(i).getSexo() == 'M') {
                result.add(pessoas.get(i));
            }
        }

        // Estilo Funcional
        // Lazy Evaluation
        // Imutavel vs Mutavel
        List<Pessoa> result2 = pessoas.stream()
                                      .filter(pessoa -> pessoa.getSexo() == 'M')
                                      .collect(Collectors.toList());

        assertThat(result2)
                .extracting(Pessoa::getNome)
                .containsExactly("Rogerio", "Gabriel","Jose", "Roberto", "Renato", "Joaquim", "George", "Elon Musk");
    }

    @Test
    public void filtrarIdadeMaiorQue60EIndicarQueEhEspecial() {
        List<Pessoa> result = null; // Colete o resultado dentro dessa variavel ou renomei ela

        // Pratica Ruim
//        pessoas.stream() // Imutavel
//               .filter(pessoa -> pessoa.getIdade() > 60) // Imutavel
//               .forEach(pessoa -> result.add(pessoa)); // Mutavel (Usando acumulador)

        // Pratica Ruim
        List<Pessoa> resultado = pessoas.stream() // Imutavel
                                        .filter(pessoa -> pessoa.getIdade() > 60)
                                        .map(pessoa -> {
                                            pessoa.setEspecial(true); // Mutavel
                                            return pessoa;
                                        })
                                        .collect(Collectors.toList()); // Imutavel


        // Se a gente precisar adicionar em uma lista, o ideal seria usar for (estilo imperativo)
        for(Pessoa p : pessoas){
            if(p.getIdade() > 60){
                p.setEspecial(true);
                result.add(p);
            }
        }

        // Lista -> stream() [Iniciando Operação] -> Operação Intermediarias -> Termino (retornando uma lista)

        System.out.println(pessoas);

//        assertThat(result)
//                .extracting(Pessoa::getNome)
//                .containsExactly("Joaquim", "Dona Benta");
    }

    @Test
    public void filtrarIdadeMaiorQue60() {
        List<Pessoa> result = null; // Colete o resultado dentro dessa variavel ou renomei ela

        // Implementar solução

        assertThat(result)
                .extracting(Pessoa::getNome)
                .containsExactly("Joaquim", "Dona Benta");
    }

    @Test
    public void mapearTodasIdades() {
        // Lista de idades das pessoas
        List<Integer> result = null;

        // Implementar solução

        assertThat(result).contains(25, 18, 35, 19, 40, 10, 85, 90, 16, 23, 43);
    }


    @Test
    public void filtrarPeloNomeRenatoEFazerUppercaseDoNome() {
        // Nota: Lista contendo somente o nome Renato em uppercase
        List<String> result = null;



        // Implementar solução

        assertThat(result).containsOnly("RENATO");
    }


}

class Pessoa {
    private String nome;
    private int idade;
    private char sexo;
    private boolean especial;

    public Pessoa(String nome, int idade, char sexo, boolean especial) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.especial = especial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", sexo=" + sexo +
                ", pcd=" + especial +
                '}';
    }
}