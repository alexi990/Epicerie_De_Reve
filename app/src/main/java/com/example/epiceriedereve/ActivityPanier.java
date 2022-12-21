package com.example.epiceriedereve;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.epiceriedereve.databinding.ActivityPanierBinding;

public class ActivityPanier extends AppCompatActivity {
    int quantite=1;
    float prix;
    float prixtotal;

    ActivityPanierBinding binding;
    PanierViewModel paniermodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPanierBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        paniermodel = new ViewModelProvider(this).get(PanierViewModel.class);

        Aliment alim = (Aliment) getIntent().getSerializableExtra("aliment");
        if (alim != null)
        {
            paniermodel.ajouterItemPanier(alim);
        }

        PanierAdapter panieradapter = new PanierAdapter(this);
        binding.panierRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.panierRecycler.setAdapter(panieradapter);
        panieradapter.submitList(paniermodel.getListPanier());


    }


}