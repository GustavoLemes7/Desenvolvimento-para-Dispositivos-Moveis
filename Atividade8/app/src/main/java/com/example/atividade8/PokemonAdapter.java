package com.example.atividade8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder>{
    private final List<Pokemon> localDataSet;

    public PokemonAdapter(List<Pokemon> localDataSet) {
        this.localDataSet = localDataSet;
    }

    @NonNull
    @Override
    public PokemonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_row_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonAdapter.ViewHolder holder, int position) {
        Pokemon pokemon = localDataSet.get(position);
        holder.getImageView().setImageResource(pokemon.img);
        holder.getTextViewNome().setText(pokemon.nome);
        holder.getTextViewTipo().setText(pokemon.tipo);
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView textViewNome;
        private final TextView textViewTipo;
        private final ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNome = itemView.findViewById(R.id.txtNome);
            textViewTipo = itemView.findViewById(R.id.txtTipo);
            imageView = itemView.findViewById(R.id.imgPokemon);

            itemView.setOnClickListener(this);
        }

        public TextView getTextViewNome() {
            return textViewNome;
        }

        public TextView getTextViewTipo() {
            return textViewTipo;
        }

        public ImageView getImageView() {
            return imageView;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(imageView.getContext(), "Pokemon: " + getTextViewNome().getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
