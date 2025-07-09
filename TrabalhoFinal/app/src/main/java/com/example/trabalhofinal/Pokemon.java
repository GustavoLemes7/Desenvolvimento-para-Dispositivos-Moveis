package com.example.trabalhofinal;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pokemon")
public class Pokemon {

    @PrimaryKey(autoGenerate = true)
    private int id;
    public String nome;
    public String tipo;


    public Pokemon(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}