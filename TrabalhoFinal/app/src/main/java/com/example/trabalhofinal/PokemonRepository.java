package com.example.trabalhofinal;
import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PokemonRepository {

    private final PokemonDAO pokemonDao;
    private final LiveData<List<Pokemon>> pokemons;
    private final ExecutorService databaseWriteExecutor = Executors.newSingleThreadExecutor();

    public PokemonRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        pokemonDao = db.pokemonDAO();
        pokemons = pokemonDao.listar();
    }

    public LiveData<List<Pokemon>> getPokemons() {
        return pokemons;
    }

    public void inserir(Pokemon pokemon) {
        databaseWriteExecutor.execute(() -> {
            pokemonDao.inserir(pokemon);
        });
    }

    public void atualizar(Pokemon pokemon) {
        databaseWriteExecutor.execute(() -> {
            pokemonDao.atualizar(pokemon);
        });
    }

    public void remover(Pokemon pokemon) {
        databaseWriteExecutor.execute(() -> {
            pokemonDao.remover(pokemon);
        });
    }

    public void findPokemonById(int id, OnPokemonResultCallback callback) {
        databaseWriteExecutor.execute(() -> {
            Pokemon pokemon = pokemonDao.SelectId(id);
            callback.onResult(pokemon);
        });
    }

    public interface OnPokemonResultCallback {
        void onResult(Pokemon pokemon);
    }
}