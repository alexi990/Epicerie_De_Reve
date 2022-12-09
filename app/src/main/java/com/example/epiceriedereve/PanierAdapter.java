package com.example.epiceriedereve;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    public PanierAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ligneepicerie, parent, false);
        return new PanierAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull PanierAdapter.ViewHolder holder, int position) {
        holder.textViewNom.setText(getItem(position).nom);
        holder.textViewPrix.setText(getItem(position).prix);
        holder.photo.setImageResource(getItem(position).image);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {


    }
}
