package com.rogeriotakashi.examples;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        Optional<Animal> optionalVazio = Optional.empty();

        Animal animal = getAnimal(true); // false estaria errado
        Optional<Animal> optional = Optional.ofNullable(animal); // Empty
        Animal animal2 = optional.orElse(new Animal("Leao", 'M', false,
                null));
//        String optionalNome = optional.map(a -> a.getNome())
//                                      .orElse("Valor default porque veio vazio");

        System.out.println(animal2.getRegiao());
//        if(animal != null) {
//            System.out.println(animal.getNome());
//        } else {
//            System.out.println("Valor default porque veio vazio");
//        }




//        if(optional.isPresent()) {
//            System.out.println(optional.get().getNome());
//        }
//
//        if(animal != null) {
//            System.out.println(animal.getNome());
//        }

//        if(animal != null) {
//            if(animal.getRegiao() != null) {
//                System.out.println(animal.getRegiao().getPais()); // bug -> nullpointer exception
//            }
//        }
    }

    private static Animal getAnimal(boolean deveRetornarCapivara) {
        if(deveRetornarCapivara) {
            return new Animal("Capivara", 'M', false,
                    null);
        }
        return null;
    }

}

class Animal {
    private String nome;
    private char sexo;
    private boolean isExtinto;
    private Localizacao regiao;

    public Animal(final String nome, final char sexo, final boolean isExtinto, final Localizacao regiao) {
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

    public Localizacao getRegiao() {
        return regiao;
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

class Localizacao {
    private String pais;
    private String regiao;

    public Localizacao(final String pais, final String regiao) {
        this.pais = pais;
        this.regiao = regiao;
    }

    public String getPais() {
        return pais;
    }

    public String getRegiao() {
        return regiao;
    }
}
