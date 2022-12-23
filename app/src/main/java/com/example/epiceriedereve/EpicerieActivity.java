package com.example.epiceriedereve;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.epiceriedereve.databinding.ActivityEpicerieBinding;

/**
 * L'EpicerieActivity contient le recyclerview pour afficher les aliments disponibles à l'achat.
 */
public class EpicerieActivity extends AppCompatActivity {

    ActivityEpicerieBinding binding;
    AlimentViewModel model;

    /**
     * onCreate intitialise le ViewModel et l'adapter pour gérer les aliments de la liste d'épicerie
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEpicerieBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        model = new ViewModelProvider(this).get(AlimentViewModel.class);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DataAdapter adapter = new DataAdapter(this);
        binding.recyclerView.setAdapter(adapter);

        model.getData().observe(this, adapter::submitList);
        model.getData().observe(this, aliments -> {
            if(aliments.isEmpty()) {
                model.repository.ajoutAliment();
            }
        });
    }

    /**
     * Initialisation du menu de l'EpicerieActivity.
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Menu permettant à l'utilisateur d'accéder à son panier en tout temps.
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){

            case R.id.menuPanier :
                Intent intent = new Intent(this, ActivityPanier.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}