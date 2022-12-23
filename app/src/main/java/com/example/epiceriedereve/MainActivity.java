package com.example.epiceriedereve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.epiceriedereve.databinding.ActivityMainBinding;

/**
 * Main Acitivty de l'Épicerie.  Présente le logo de l'épiceire ainsi que 4 options pour l'utilisateur
 *
 * */
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    /**
     * onCreate de MainActivity gère les 4 boutons du layout en leur attribuant un lamba pour ouvrir
     * la bonne acitivty selon le bouton cliqué.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btncommencer.setOnClickListener(view-> {
            Intent intent = new Intent(this, EpicerieActivity.class);
            startActivity(intent);
        });

        binding.btnapropos.setOnClickListener(view-> {
            Intent intent = new Intent(this, ActivityPropos.class);
            startActivity(intent);
        });

        binding.btnplainte.setOnClickListener(view -> {
            Intent intent = new Intent(this, PlainteActivity.class);
            startActivity(intent);
        });

        binding.btnquitter.setOnClickListener(view-> {
            this.finish();
        });

    }
}