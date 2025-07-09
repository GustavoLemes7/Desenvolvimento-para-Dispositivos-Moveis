package com.example.trabalhofinal;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalhofinal.databinding.ItemPokemonBinding;

import java.util.List;
import java.util.Locale;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.FilmeViewHolder> {

    private List<Pokemon> pokemonList;
    private OnPokemonClickListener listener;

    public interface OnPokemonClickListener {
        void onPokemonClick(Pokemon pokemon);
    }

    public void setOnPokemonClickListener(OnPokemonClickListener listener) {
        this.listener = listener;
    }

    public PokemonAdapter(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemonList = pokemon;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemPokemonBinding binding = ItemPokemonBinding.inflate(layoutInflater, parent, false);
        return new FilmeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        holder.bind(pokemon);
    }

    @Override
    public int getItemCount() {
        return pokemonList != null ? pokemonList.size() : 0;
    }

    class FilmeViewHolder extends RecyclerView.ViewHolder {
        private final ItemPokemonBinding binding;

        public FilmeViewHolder(@NonNull ItemPokemonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onPokemonClick(pokemonList.get(position));
                }
            });
        }

        public void bind(Pokemon pokemon) {
            binding.txtNome.setText(pokemon.getNome());
            binding.txtTipo.setText(pokemon.getTipo());

        }
    }
}