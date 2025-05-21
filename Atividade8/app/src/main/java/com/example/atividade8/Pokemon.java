package com.example.atividade8;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    public String nome;
    public String tipo;
    public int img;

    public Pokemon(String nome, String tipo, int img) {
        this.nome = nome;
        this.tipo = tipo;
        this.img = img;
    }

    public static List<Pokemon> getPokemon(){
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon("Pikachu", "Elétrico",R.drawable.pikachu));
        pokemons.add(new Pokemon("Pidgeot", "Voador", R.drawable.pidgeot));
        pokemons.add(new Pokemon("Bulbasaur", "Planta", R.drawable.bulbasaur));
        pokemons.add(new Pokemon("Squirtle", "Água", R.drawable.squirtle));
        pokemons.add(new Pokemon("Chamander","Fogo", R.drawable.charmander));
        pokemons.add(new Pokemon("Sanslash", "Terra", R.drawable.sandslash));
        pokemons.add(new Pokemon("Caterpie", "Inseto", R.drawable.caterpie));
        pokemons.add(new Pokemon("Blastoise", "Água", R.drawable.blastoise));

        return pokemons;
    }
}
