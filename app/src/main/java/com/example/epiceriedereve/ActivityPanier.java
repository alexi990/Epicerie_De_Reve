package com.example.epiceriedereve;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.epiceriedereve.databinding.ActivityPanierBinding;

/**
 * ActivityPanier utilise un Recyclerview et un ViewModel afin de montrer le panier contenant les aliments que
 * l'utilisateur souhaite acheté
 */
public class ActivityPanier extends AppCompatActivity {

    ActivityPanierBinding binding;
    PanierViewModel paniermodel;

    /**
     * Attribue le initialise le recyclerview avec la liste contenue dans le panierviewmodel.
     * Crée une fonction lambda pour le bouton passer qui ouvre l'activité finale qui montre le prix total des achats.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPanierBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        paniermodel = new ViewModelProvider(this).get(PanierViewModel.class);

        Aliment alim = (Aliment) getIntent().getSerializableExtra("aliment");
        if (alim != null) {
            paniermodel.ajouterItemPanier(alim);
        }

        PanierAdapter panieradapter = new PanierAdapter(this);

        binding.passer.setOnClickListener(view -> {
            Intent intent = new Intent(this, FinActivity.class);
            intent.putExtra("total", panieradapter.getTotal());
            startActivity(intent);
        });

        binding.panierRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.panierRecycler.setAdapter(panieradapter);
        panieradapter.submitList(paniermodel.getListPanier());
    }

    /**
     * Affichage du prix total dans le bas du panier
     * @param prix
     */
    public void afficheTotal(Float prix) {
        binding.totalpanier.setText(String.valueOf(prix) + "0 $");
    }

}