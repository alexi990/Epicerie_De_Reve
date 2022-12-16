package com.example.epiceriedereve;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.epiceriedereve.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btncommencer.setOnClickListener(view-> {
            Intent intent = new Intent(this, EpicerieActivity.class);
            //intent.putExtra("id_aliment", 0);
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