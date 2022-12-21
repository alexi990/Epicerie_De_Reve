package com.example.epiceriedereve;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.epiceriedereve.databinding.ActivityPanierBinding;

public class ActivityPanier extends AppCompatActivity {

    ActivityPanierBinding binding;
    PanierViewModel paniermodel;

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

    public void afficheTotal(Float prix) {
        binding.totalpanier.setText(String.valueOf(prix) + "0 $");
    }

}