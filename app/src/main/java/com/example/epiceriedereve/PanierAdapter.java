package com.example.epiceriedereve;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class PanierAdapter extends ListAdapter<Aliment, PanierAdapter.ViewHolder> {

    public PanierAdapter() {super(DIFF_CALLBACK);}

    private static final DiffUtil.ItemCallback<Aliment> DIFF_CALLBACK = new DiffUtil.ItemCallback<Aliment>() {
        @Override
        public boolean areItemsTheSame(@NonNull Aliment oldItem, @NonNull Aliment newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Aliment oldItem, @NonNull Aliment newItem) {
            return oldItem.nom.equals(newItem.nom);
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lignepanier, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull PanierAdapter.ViewHolder holder, int position) {
        holder.textViewqte.setText(getItem(position).quantite);
        holder.textViewprix.setText(getItem(position).prix);
        holder.imgAliment.setImageResource(getItem(position).image);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewprix;
        private final TextView textViewqte;
        private final ImageView imgAliment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewprix = itemView.findViewById(R.id.prixAliment);
            textViewqte = itemView.findViewById(R.id.quantite);
            imgAliment = itemView.findViewById(R.id.photo);
        }


    }
}
