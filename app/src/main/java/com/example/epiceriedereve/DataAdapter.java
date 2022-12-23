package com.example.epiceriedereve;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

/**
 * RecyclerView pour afficher les aliments disponibles dans l'épierie
 * Ce sert des objets stockés dans la database
 */
public class DataAdapter extends ListAdapter<Aliment, DataAdapter.ViewHolder> {
    private EpicerieActivity epicerie;

    /**
     * Constructeur du DataAdapter
     * Reçoit EpicerieActivity pour pouvoir utilisée une de ces méthodes plus bas.
     * @param epicerie
     */
    public DataAdapter(EpicerieActivity epicerie) {
        super(DIFF_CALLBACK);
        this.epicerie = epicerie;
    }

    private static final DiffUtil.ItemCallback<Aliment> DIFF_CALLBACK = new DiffUtil.ItemCallback<Aliment>() {
        /**
         * Si deux objets sont pareils
         * @param oldItem
         * @param newItem
         * @return
         */
        @Override
        public boolean areItemsTheSame(@NonNull Aliment oldItem, @NonNull Aliment newItem) {
            return oldItem.id == newItem.id;
        }

        /**
         * Si deux objets sont équivalents
         * @param oldItem
         * @param newItem
         * @return
         */
        @Override
        public boolean areContentsTheSame(@NonNull Aliment oldItem, @NonNull Aliment newItem) {
            return oldItem.nom.equals(newItem.nom);
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ligneepicerie, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Set le nom, le prix et l'image reliée à un aliment selon la ligne du RecyclerView
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewNom.setText(getItem(position).getNom());
        holder.textViewPrix.setText(getItem(position).getPrix());
        holder.imageViewAliment.setImageResource(getItem(position).getImage());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewNom;
        private final TextView textViewPrix;
        private final ImageView imageViewAliment;

        /**
         * Constructeur du ViewHolder
         * Ajoute un aliment au panier et l'ouvre lorsque l'utilisateur clique dessus
         * @param itemView
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNom = itemView.findViewById(R.id.nomaliment);
            textViewPrix = itemView.findViewById(R.id.prixaliment);
            imageViewAliment = itemView.findViewById(R.id.imageAliment);

            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(epicerie, ActivityPanier.class);
                intent.putExtra("aliment", getCurrentList().get(getAdapterPosition()));
                epicerie.startActivity(intent);
            });
        }
    }
}
