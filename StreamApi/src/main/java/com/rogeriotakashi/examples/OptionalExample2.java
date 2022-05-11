package com.rogeriotakashi.examples;

import java.util.Optional;

public class OptionalExample2 {

    public static void main(String[] args) {
        Optional<Animal2> animalOptional = getAnimal(true);

        String nomeAnimal = animalOptional.map(animal -> animal.getNome()).orElse("Default");
        System.out.println(nomeAnimal);

        // outro
//        if(animal != null) {
//            if(animal.getRegiao() != null) {
//                System.out.println(animal.getRegiao().getPais()); // bug -> nullpointer exception
//            }
//        }
        Localizacao2 localizacao = animalOptional
                                          .flatMap(animal -> animal.getRegiao())
                                          .orElse(new Localizacao2("Outro Pais", "Outra Regiao"));

        System.out.println(localizacao);
    }

    private static Optional<Animal2> getAnimal(boolean deveRetornarCapivara) {
        if(deveRetornarCapivara) {
            return Optional.of(new Animal2("Capivara", 'M', false,
                    new Localizacao2("Brazil", "Sudeste")));
        }
        return Optional.empty();
    }
}

class Animal2 {
    private String nome;
    private char sexo;
    private boolean isExtinto;
    private Localizacao2 regiao;

    public Animal2(final String nome, final char sexo, final boolean isExtinto, final Localizacao2 regiao) {
        this.nome = nome;
        this.sexo = sexo;
        this.isExtinto = isExtinto;
        this.regiao = regiao;
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public boolean isExtinto() {
        return isExtinto;
    }

    public Optional<Localizacao2> getRegiao() {
        return Optional.ofNullable(regiao);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", isExtinto=" + isExtinto +
                ", regiao=" + regiao +
                '}';
    }
}

class Localizacao2 {
    private String pais;
    private String regiao;

    public Localizacao2(final String pais, final String regiao) {
        this.pais = pais;
        this.regiao = regiao;
    }

    public String getPais() {
        return pais;
    }

    public String getRegiao() {
        return regiao;
    }

    @Override
    public String toString() {
        return "Localizacao2{" +
                "pais='" + pais + '\'' +
                ", regiao='" + regiao + '\'' +
                '}';
    }
}
// JPA
interface teste {

    Optional<Entidade> findById(int id);
}