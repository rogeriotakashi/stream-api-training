package com.rogeriotakashi.examples;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
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
                new Pessoa("Dona Benta",90, 'F', true),
                new Pessoa("George",16, 'M', false),
                new Pessoa("Jessica",23, 'F', false),
                new Pessoa("Elon Musk",43, 'M', true)
        );
    }

    @Test
    public void filtrarSexoMasculino() {
        List<Pessoa> result = null;

        // Implementar solução

        assertThat(result)
                .extracting(Pessoa::getNome)
                .containsExactly("Rogerio", "Gabriel","Jose", "Roberto", "Renato", "Joaquim", "George", "Elon Musk");
    }

    @Test
    public void filtrarIdadeMaiorQue60() {
        List<Pessoa> result = null;

        // Implementar solução

        assertThat(result)
                .extracting(Pessoa::getNome)
                .containsExactly("Joaquim", "Dona Benta");
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