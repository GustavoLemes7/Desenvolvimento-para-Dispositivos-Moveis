package com.example.trabalhofinal;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trabalhofinal.databinding.ActivityEdtPokemonBinding;

public class EdtPokemonActivity extends AppCompatActivity {

    private ActivityEdtPokemonBinding binding;
    private PokemonRepository pokemonRepository;
    private Pokemon pokemonEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEdtPokemonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        pokemonRepository = new PokemonRepository(getApplication());
        setTitle("Editar");

        int pokemonId = getIntent().getIntExtra("pokemon_id", -1);

        if (pokemonId != -1) {
            carregarPokemon(pokemonId);
        }

        binding.btnAtualizar.setOnClickListener(v -> atualizarPokemon());
    }

    private void atualizarPokemon() {
        if (pokemonEditar == null) return;

        String nome = binding.edtNome.getText().toString();
        String tipo = binding.edtTipo.getText().toString();


        if (TextUtils.isEmpty(nome) || TextUtils.isEmpty(tipo)) {
            Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        pokemonEditar.setNome(nome);
        pokemonEditar.setTipo(tipo);


        pokemonRepository.atualizar(pokemonEditar);

        Toast.makeText(this, "Atualizado!", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void carregarPokemon(int id) {

        pokemonRepository.findPokemonById(id, pokemon -> {
            pokemonEditar = pokemon;
            if (pokemonEditar != null) {
                runOnUiThread(() -> {
                    binding.edtNome.setText(pokemonEditar.getNome());
                    binding.edtTipo.setText(pokemonEditar.getTipo());
                });
            }
        });
    }

}