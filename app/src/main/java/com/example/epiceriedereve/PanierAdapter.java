package com.example.epiceriedereve;

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

/**
 * Adapter pour la PanierActivity.
 */
public class PanierAdapter extends ListAdapter<Aliment, PanierAdapter.ViewHolder> {
    private float prixtotal;
    ActivityPanier actpanier;

    /**
     * Constructeur du PanierAdapter
     * Reçoit un AcitivtyPanier pour pouvoir utiliser une méthode de sa classe.
     * @param act
     */
    public PanierAdapter(ActivityPanier act) {
        super(DIFF_CALLBACK);
        this.actpanier = act;
    }

    /**
     *
     * @return le prix total des achats
     */
    public String getTotal() {
        return String.valueOf(prixtotal);
    }

    private static final DiffUtil.ItemCallback<Aliment> DIFF_CALLBACK = new DiffUtil.ItemCallback<Aliment>() {
        /**
         * Si deux items sont pareils
         * @param oldItem
         * @param newItem
         * @return
         */
        @Override
        public boolean areItemsTheSame(@NonNull Aliment oldItem, @NonNull Aliment newItem) {
            return oldItem.id == newItem.id;
        }

        /**
         * Si deux items sont équivalents
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
                .inflate(R.layout.lignepanier, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Set le text, la quantité et le prix d'un aliment selon la ligne du recyclerview
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull PanierAdapter.ViewHolder holder, int position) {
        holder.textViewqte.setText(String.valueOf(getItem(position).quantite));
        holder.textViewprix.setText((Float.parseFloat(getItem(position).prix)*(getItem(position).quantite))+ "0 $");
        prixtotal += Float.parseFloat(getItem(position).prix)*(getItem(position).quantite);
        actpanier.afficheTotal(prixtotal);
        holder.imgAliment.setImageResource(getItem(position).image);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewprix;
        private final TextView textViewqte;
        private final ImageView imgAliment;
        private final Button btnmoins;
        private final Button btnplus;
        int quantite = 1;
        float prix;

        /**
         * Constructeur du ViewHolder
         * Gère les actions reliées au bouton pour ajuster la quantité d'un item
         * @param itemView
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewprix = itemView.findViewById(R.id.prixAliment);
            textViewqte = itemView.findViewById(R.id.quantite);
            imgAliment = itemView.findViewById(R.id.photo);
            btnmoins = itemView.findViewById(R.id.moins);
            btnplus = itemView.findViewById(R.id.plus);

            btnmoins.setOnClickListener(view -> {
                Aliment a1 = getCurrentList().get(getAdapterPosition());
                quantite = a1.getQuantite();

                if (quantite >= 1)
                {
                    quantite--;
                    a1.setQuantite(quantite);
                    textViewqte.setText(String.valueOf(quantite));
                    prixtotal -= Float.parseFloat(a1.getPrix());
                    actpanier.afficheTotal(prixtotal);
                }

                prix = Float.parseFloat(a1.getPrix());
                prix *= quantite;
                textViewprix.setText(prix + "0 $");
            });

            btnplus.setOnClickListener(view -> {
                Aliment a2 = getCurrentList().get(getAdapterPosition());
                quantite = a2.getQuantite();
                quantite++;
                a2.setQuantite(quantite);
                textViewqte.setText(String.valueOf(quantite));
                prix = Float.parseFloat(a2.getPrix());
                prixtotal += prix;
                prix *= quantite;
                textViewprix.setText(prix + "0 $");
                actpanier.afficheTotal(prixtotal);
            });
        }
    }
}
