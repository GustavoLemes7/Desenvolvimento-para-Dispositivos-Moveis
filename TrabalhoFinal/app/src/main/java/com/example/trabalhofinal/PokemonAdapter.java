package com.example.trabalhofinal;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalhofinal.databinding.ItemPokemonBinding;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private List<Pokemon> pokemonList;
    private OnPokemonClickListener listener;
    private OnPokemonDeleteClickListener deleteListener;

    public interface OnPokemonClickListener {
        void onPokemonClick(Pokemon pokemon);
    }

    public interface OnPokemonDeleteClickListener {
        void onPokemonDeleteClick(Pokemon pokemon);
    }

    public void setOnPokemonClickListener(OnPokemonClickListener listener) {
        this.listener = listener;
    }

    public void setOnPokemonDeleteClickListener(OnPokemonDeleteClickListener deleteListener) {
        this.deleteListener = deleteListener;
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
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemPokemonBinding binding = ItemPokemonBinding.inflate(layoutInflater, parent, false);
        return new PokemonViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        holder.bind(pokemon);
    }

    @Override
    public int getItemCount() {
        return pokemonList != null ? pokemonList.size() : 0;
    }

    class PokemonViewHolder extends RecyclerView.ViewHolder {
        private final ItemPokemonBinding binding;

        public PokemonViewHolder(@NonNull ItemPokemonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            // Clique no item (abrir edição)
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

            // Clique no botão de deletar
            binding.btnDelete.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (deleteListener != null && position != RecyclerView.NO_POSITION) {
                    deleteListener.onPokemonDeleteClick(pokemonList.get(position));
                }
            });
        }
    }
}
