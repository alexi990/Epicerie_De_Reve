package com.example.epiceriedereve;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class PanierAdapter extends ListAdapter<Aliment, PanierAdapter.ViewHolder> {
    private ActivityPanier actpanier;

    public PanierAdapter(ActivityPanier actpanier) {
        super(DIFF_CALLBACK);
        this.actpanier = actpanier;
        ;}

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
        holder.textViewqte.setText(String.valueOf(getItem(position).quantite));
        holder.textViewprix.setText(getItem(position).prix);
        holder.imgAliment.setImageResource(getItem(position).image);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewprix;
        private final TextView textViewqte;
        private final ImageView imgAliment;
        private final Button btnpasser;
        private final Button btnmoins;
        private final Button btnplus;
        int quantite = 1;
        float prix;
        float prixtotal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewprix = itemView.findViewById(R.id.prixAliment);
            textViewqte = itemView.findViewById(R.id.quantite);
            imgAliment = itemView.findViewById(R.id.photo);
            btnpasser = itemView.findViewById(R.id.passer);
            btnmoins = itemView.findViewById(R.id.moins);
            btnplus = itemView.findViewById(R.id.plus);

            btnpasser.setOnClickListener(view -> {
                Intent intent = new Intent(actpanier, Activityfin.class);
                intent.putExtra("Prix", prixtotal);
                actpanier.startActivity(intent);
            });

            btnmoins.setOnClickListener(view -> {
                Aliment a = getCurrentList().get(getAdapterPosition());
                quantite = a.getQuantité();
                quantite--;
                a.setQuantite(quantite);
                textViewqte.setText(String.valueOf(quantite));
            });

            btnplus.setOnClickListener(view -> {
                Aliment a = getCurrentList().get(getAdapterPosition());
                quantite = a.getQuantité();
                quantite++;
                a.setQuantite(quantite);
                textViewqte.setText(String.valueOf(quantite));
            });
        }
    }
}
