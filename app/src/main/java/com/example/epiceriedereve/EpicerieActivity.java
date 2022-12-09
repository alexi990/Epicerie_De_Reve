package com.example.epiceriedereve;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.epiceriedereve.databinding.ActivityEpicerieBinding;

public class EpicerieActivity extends AppCompatActivity {

    ActivityEpicerieBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEpicerieBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){

            case R.id.menuPanier :
                Intent intent2 = new Intent(this, ActivityPanier.class);
                startActivity(intent2);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}