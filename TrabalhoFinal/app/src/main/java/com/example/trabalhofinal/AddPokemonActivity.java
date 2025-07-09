package com.example.trabalhofinal;



import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trabalhofinal.databinding.ActivityAddPokemonBinding;

public class AddPokemonActivity extends AppCompatActivity {

    private ActivityAddPokemonBinding binding;
    private PokemonRepository pokemonRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddPokemonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        pokemonRepository = new PokemonRepository(getApplication());
        setTitle("Adicionar Pokemon");

        binding.btnSalvar.setOnClickListener(v -> salvar());
    }

    private void salvar() {
        String nome = binding.edtNome.getText().toString();
        String tipo = binding.edtTipo.getText().toString();

        if (TextUtils.isEmpty(nome) || TextUtils.isEmpty(tipo)) {
            Toast.makeText(this, "preencha todos os campos.", Toast.LENGTH_SHORT).show();
            return;
        }
        Pokemon newPokemon = new Pokemon(nome, tipo);

        pokemonRepository.inserir(newPokemon);

        Toast.makeText(this, "Salvo com sucesso!", Toast.LENGTH_SHORT).show();
        finish();
    }


}