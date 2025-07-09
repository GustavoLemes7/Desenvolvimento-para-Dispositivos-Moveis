package com.example.trabalhofinal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PokemonDAO {
    @Insert
    void inserir(Pokemon pokemon);

    @Update
    void atualizar(Pokemon pokemon);

    @Delete
    void remover(Pokemon pokemon);

    @Query("SELECT * FROM pokemon ORDER BY nome ASC")
    LiveData<List<Pokemon>> listar();

    @Query("SELECT * FROM pokemon WHERE id = :id LIMIT 1")
    Pokemon SelectId(int id);
}